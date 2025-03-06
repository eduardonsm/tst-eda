import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamPilha = Integer.parseInt(sc.nextLine());
        String[] entrada = sc.nextLine().split(" ");
        Pilha numeros = new Pilha(tamPilha);
        for (int i = 0; i < tamPilha; i++) {
            numeros.push(Integer.parseInt(entrada[i]));
        }
        ordenaPilha(numeros, tamPilha);
    }

    public static void ordenaPilha(Pilha pilha, int tamPilha) {
        Pilha aux = new Pilha(tamPilha);
        int tamanhoAtual = tamPilha; // Corrigido para acompanhar o tamanho real da pilha

        while (!pilha.isEmpty()) {
            int maior = maxPilha(pilha, tamanhoAtual - 1, tamPilha);
            aux.push(maior);
            removeValue(pilha, maior, tamPilha);
            tamanhoAtual--;
        }

        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }
        invertePilhaIndex(pilha, tamPilha-1, tamPilha);
        System.out.println("-");
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    public static int maxPilha(Pilha pilha, int indice, int tamPilha) {
        Pilha aux = new Pilha(tamPilha);
        int maior = pilha.pop();
        aux.push(maior);

        for (int i = 1; i <= indice && !pilha.isEmpty(); i++) {
            int elem = pilha.pop();
            aux.push(elem);
            if (elem > maior) maior = elem;
        }

        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }
        return maior;
    }
    public static void invertePilhaIndex(Pilha pilha, int indice, int tamPilha) {
        Pilha aux = new Pilha(tamPilha);
        Pilha aux2 = new Pilha(tamPilha);

        for (int i = 0; i <= indice && !pilha.isEmpty(); i++) {
            aux.push(pilha.pop());
        }

        while (!aux.isEmpty()) {
            aux2.push(aux.pop());
        }

        while (!aux2.isEmpty()) {
            pilha.push(aux2.pop());
        }
    }
    public static void removeValue(Pilha pilha, int valor, int tamPilha) {
        Pilha aux = new Pilha(tamPilha);
        boolean retirado = false;
        while (!pilha.isEmpty()) {
            int elem = pilha.pop();
            if (elem == valor && retirado==false) {
                retirado=true;
            }else{
                aux.push(elem);
            }
        }

        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }
    }
}

class Pilha {
    private int t;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.t = -1;
    }

    public boolean isEmpty() {
        return this.t == -1;
    }

    public boolean isFull() {
        return this.t == pilha.length - 1;
    }

    public void push(int valor) {
        if (this.isFull()) throw new RuntimeException("Pilha Cheia!");
        this.pilha[++t] = valor;
    }

    public int pop() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia!");
        return this.pilha[t--];
    }
}
