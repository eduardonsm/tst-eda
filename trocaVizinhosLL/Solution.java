import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int index = sc.nextInt();
                MyLinkedList numeros = new MyLinkedList();
                for(int i =0;i<entrada.length;i++){
                        numeros.addLast(Integer.parseInt(entrada[i]));
                }
                trocaVizinhos(numeros,index);

        }
        public static void trocaVizinhos(MyLinkedList ll,int index){
		ll.swap(index,index+1);
            System.out.println("here");
            System.out.println( ll.toString());
        }
}
class MyLinkedList {

        private Node tail;
        private Node head;
        private int size;
    
        public MyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
    
        public boolean isEmpty() {
            return this.size == 0;
        }
    
    
        public void addLast(int valor) {
            Node newNode = new Node(valor);
            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            }else {
                newNode.prev = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
            } 
            this.size++;
        }   
    
        public int removeFirst() {
            if (isEmpty()) throw new NoSuchElementException();
            int elem = this.head.value;
            if (this.head.next==null){
                this.head = null;
                this.tail=null;
            }else{
                this.head = this.head.next;
                this.head.prev = null;
            }
            
            size--;
            return elem;
        }
    
        public int removeLast() {
            if (isEmpty()) throw new NoSuchElementException();
            int elem = this.tail.value;
            if (this.tail.prev == null) {
                this.head = null;
                this.tail= null;
            }else{
                this.tail = this.tail.prev;
            this.tail.next = null;
            }
            
            size--;
            return elem;
    
        }
        public int remove(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        if (index==0) return this.removeFirst();
        if (index==size-1) return this.removeLast();

        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        int elem = aux.value;

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        size--;
        return elem;
        }

        public boolean removeByValue(int value) {
        Node aux = this.head;
        int index=0;
        while (aux!=null) {
            if (aux.value==value) {
                remove(index);
                return true;
            }
            aux = aux.next;
            index+=1;
        }
        return false;
    }
        public String toString() {
        if (isEmpty()) return "vazia";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + " ";

            aux = aux.next;
        }
        return out.substring(0, out.length() - 1);
        }
	private Node getNode(int index) {
        	if (isEmpty()) throw new NoSuchElementException();
 	       	Node aux = this.head;
        	for (int i = 0; i < index; i++) {
            		aux = aux.next;
        	}
        	return aux;
    	}
	public void swap(int indexA, int indexB){
		Node nodeA = getNode(indexA);
		Node nodeB = getNode(indexB);
    		nodeA.next = nodeB.next;
    		nodeB.prev = nodeA.prev;

        if (nodeA.prev != null) {
            nodeA.prev.next = nodeB;
        }
        if (nodeB.next != null) {
            nodeB.next.prev = nodeA;
        }

        nodeB.next = nodeA;
        nodeA.prev = nodeB;

        if (head == nodeA) head = nodeB;
        if (tail == nodeB) tail = nodeA;	
	}
}
class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}
