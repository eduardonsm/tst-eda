import java.util.Scanner;
import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                sc.close();
                BST bst = new BST();
                for(int i =0;i<entrada.length;i++){
                        bst.add(Integer.parseInt(entrada[i]));
                }
                bfsDireita(bst);

        }
        public static void bfsDireita(BST bst){
            System.out.println(bst.somaFolha());
        }
}

 
class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        Node aux = this.root;
        while( aux!=null){
            if (element==aux.value)return aux;
            if(element<aux.value) aux=aux.left;
            else aux=aux.right;
        }
        return null;
    }
    
    public int somaFolha(){
        return recSomaFolha(this.root);
    }
    private int recSomaFolha(Node node){
        if (node==null) {
            return 0;
        }
        if (node.right==null && node.left==null) {
            return node.value;
        }
        return recSomaFolha(node.right)+recSomaFolha(node.left);
    }

    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if(node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean equals(BST outra) {
        return this.preOrder().equals(outra.preOrder());
    }
    private String preOrder() {
        return preOrder(this.root).trim();
    }
    
    private String preOrder(Node node) {
        if (node == null) {
            return "";
        }
        return node.value + " " + preOrder(node.left) + preOrder(node.right);
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        if (this.root == null )return 0;
        else return recContaFolhas(this.root);
    }
    private int recContaFolhas(Node aux){
        if(aux.left==null && aux.right==null) return 1;
        if (aux.left == null) return recContaFolhas(aux.right);
        if (aux.right == null) return recContaFolhas(aux.left);
        return recContaFolhas(aux.right)+recContaFolhas(aux.left);	    
    
    }
    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }
    
    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param a raiz da árvore.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    /**
     * Retorna o nó que contém o valor máximo da árvore. Implementação iterativa.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    public Node max() {
        if (isEmpty()) return null;
        
        Node node = this.root;
        while(node.right != null)
            node = node.right;
        
        return node;
    }
    
    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param raiz da árvore.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    
    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }
    
    /**
     * Retorna o nó cujo valor é predecessor do valor passado como parâmetro. 
     * @param valor O nó para o qual deseja-se identificar o predecessor.
     * @return O nó contendo o predecessor do valor passado como parâmetro. O método retorna null caso não haja 
     * predecessor.
     */
    public Node predecessor(Node node) {
        if (node == null) return null;
        
        if (node.left != null)
            return max(node.left);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value > node.value)
                aux = aux.parent;
            
            return aux;
        }
    }
	
    public String bfsDireita() {
        LinkedList<Node> queue = new LinkedList<Node>();
        String out = "";
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                    
                out += current.value+" ";
                    
                if(current.right != null) 
                    queue.addLast(current.right);   
                if(current.left != null) 
                    queue.addLast(current.left);
            }
        }
        return out;
    }
   	
    /**
     * Retorna o nó cujo valor é sucessor do valor passado como parâmetro. 
     * @param valor O valor para o qual deseja-se identificar o sucessor.
     * @return O nó contendo o sucessor do valor passado como parâmetro. O método retorna null
     * caso não haja sucessor.
     */
    public Node sucessor(Node node) {
        if (node == null) return null;
        
        if (node.right != null)
            return min(node.right);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value < node.value)
                aux = aux.parent;
            
            return aux;
        }
    }
    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }
    
}
