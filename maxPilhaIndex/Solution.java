import java.util.Scanner;
import java.util.Arrays;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                String indice = sc.nextLine();
                Pilha numeros = new Pilha(entrada.length);
                for(int i =0;i<entrada.length;i++){
                        numeros.push(Integer.parseInt(entrada[i]));
                }
                invertePilhaIndex(numeros,Integer.parseInt(indice),entrada.length);

        }
        public static void invertePilhaIndex(Pilha pilha,int indice,int tamPIlha){
                Pilha aux = new Pilha(tamPIlha);
                int maior = 0;
                int elem = 0;
                for (int i = 0; i <= indice; i++) {
                    elem = pilha.pop() ;
			        aux.push(elem);
                	if(elem>=maior) maior=elem ;
                }
                while (!aux.isEmpty()) {
                        pilha.push(aux.pop());
                }
              System.out.println(maior); 
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
    
        public boolean isFull(){
            return this.t == pilha.length-1;
        }
    
        public void push(int valor) {
            if (this.isFull()) throw new RuntimeException("Pilha Cheia!");
            this.pilha[++t] = valor;
        }
    
        public int pop() {
            if (this.isEmpty()) throw new RuntimeException("Pilha vazia!");
            int v = this.pilha[t--];
            return v ;
        }
        public String toString() {
                String saida = "";
                Pilha aux = new Pilha(this.t+1);
                if (this.isEmpty()) {
                    return saida;
                }
                int elem = this.pop();
                saida += elem;
                aux.push(elem);
        
                while (!this.isEmpty()) {
                    elem = this.pop();
                    saida +=   ", " + elem;
                    aux.push(elem);
                }
                while (!aux.isEmpty()) {
                    this.push(aux.pop());
                }
                
                return saida;
            }
}

