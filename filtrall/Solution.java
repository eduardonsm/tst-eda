import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                String toRemove = sc.nextLine();
                MyLinkedList numeros = new MyLinkedList();
                for(int i =0;i<entrada.length;i++){
                        numeros.addLast(Integer.parseInt(entrada[i]));
                }
                filtraLl(numeros,Integer.parseInt(toRemove));

        }
        public static void filtraLl(MyLinkedList ll,int toRemove){
            boolean removendo = ll.removeByValue(toRemove);
            while(removendo)removendo = ll.removeByValue(toRemove);
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
}
class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}
