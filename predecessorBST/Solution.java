import java.util.Scanner;
import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int no = sc.nextInt();
                sc.close();
                BST bst = new BST();
                for(int i =0;i<entrada.length;i++){
                        bst.add(Integer.parseInt(entrada[i]));
                }
                predecessor(bst,no);

        }
        public static void predecessor(BST bst,int no){
            System.out.println(Arrays.toString(bst.predecessor(no)));
        }
}

 class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }

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
    public Node max() {
        if (isEmpty()) return null;
            
        Node node = this.root;
        while(node.right != null)
            node = node.right;      
    
        return node;
    
    }
   
    public Node search(int element) {
        Node aux = this.root;
        while( aux!=null){
            if (element==aux.value)return aux;
            if(element<aux.value) aux=aux.left;
            else aux=aux.right;
        }
        return null;
    }

    public int[] predecessor(int no) {
        Node inicial = this.search(no);
        int i = 0;
        int[] caminho = new int[size+1];
        Node aux = inicial;

        if (aux.left != null){
            while(aux.right != null){
                caminho[i++] = aux.value;
                aux = aux.right; 
            }
            
        }
             
        else {
            aux = inicial.parent;
            while (aux != null && aux.value > inicial.value){
                caminho[i++] = aux.value;
                aux = aux.parent;

            }
                
        }
        return caminho;
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
