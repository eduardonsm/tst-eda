import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		BST tree = new BST();
		for (String in:entrada){
			tree.add(Integer.parseInt(in));
		}
		String[] listaRemocao = sc.nextLine().split(" ");
		int[] toRemove = new int[listaRemocao.length];
		for (int i = 0; i < toRemove.length; i++) {
			toRemove[i] = Integer.parseInt(listaRemocao[i]);
		}
		listRemove(tree,toRemove);
		}
	
	public static void listRemove(BST tree, int[] toRemove){
		
		for (int i = 0; i<toRemove.length; i++) {
			if (tree.search(toRemove[i])) {
				tree.remove(toRemove[i]);
			}
			if (tree.preOrdem().isEmpty()) System.out.println("null");
			else System.out.println(Arrays.toString(tree.preOrdem().toArray()));
		}
	}
}
class BST{
	private Node root;
	public BST(){
		this.root = null;
	}
	public boolean isEmpty() {return this.root==null;}
	public void add(int v){
		if (isEmpty()) {
			this.root=new Node(v);
		}else{
			recAdd(this.root,v);
		}
	}
	private void recAdd(Node node,int elem){
		if (elem>node.value) {
			if (node.rigth==null) {
				Node newNode = new Node(elem);
				node.rigth = newNode;
				newNode.parent = node;
				return;
			} 
			recAdd(node.rigth, elem);
		}
		else if (elem<node.value) {
			if (node.left==null) {
				Node newNode = new Node(elem);
				node.left = newNode;
				newNode.parent = node;
				return;
			} 
			recAdd(node.left, elem);
		}
	}

	public Node getNode(int v){
		return recGetNode(this.root,v);
	}
	private Node recGetNode(Node node, int v){
		if (node == null) {
			return null;
		}
		if (node.value == v) {
			return node;
		}
		if (v<node.value) return recGetNode(node.left, v);
		else return recGetNode(node.rigth, v);
	}
	public boolean search(int v){
		return recSeach(this.root,v);
	}
	private boolean recSeach(Node node, int v){
		if (node == null) {
			return false;
		}
		if (node.value == v) {
			return true;
		}
		if (v<node.value) return recSeach(node.left, v);
		else return recSeach(node.rigth, v);
	}
	public void remove(int value) {
        Node node = getNode(value);
        if (node != null) {
            remove(node);
        }
        
    }
	public void remove(Node node){
		
		if(node.isLeaf()){
			if(node==this.root) this.root = null;
			else {
				if (node.value<node.parent.value) node.parent.left=null;
				else node.parent.rigth=null;
			}
		}
		else if(node.onlyChieldLeft()){
			if (node == this.root) {
				this.root = node.left;
				this.root.parent = null;
			}else{
				node.left.parent = node.parent;
				if (node.value<node.parent.value) node.parent.left=node.left;
				else node.parent.rigth=node.left;
			}
		}
		else if(node.onlyChieldRigth()){
			if (node == this.root) {
				this.root = node.rigth;
				this.root.parent = null;
			}else{
				node.rigth.parent = node.parent;
				if (node.value<node.parent.value) node.parent.left=node.rigth;
				else node.parent.rigth=node.rigth;
			}
		} else {
			Node sucessor = this.sucessor(node);
			node.value = sucessor.value;
			remove(sucessor);
		}
	}
	private Node sucessor(Node node){
		if (node == null) return null;
        
        if (node.rigth != null)
            return min(node.rigth);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value < node.value)
                aux = aux.parent;
            
            return aux;
        }
		
	}
	public Node min(Node node){
		if (node.left == null) return node;
        else return min(node.left);
		
	}
	public ArrayList<Integer> preOrdem(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		recPreordem(this.root,lista);
		return lista;
	}
	public void recPreordem(Node node,ArrayList<Integer> lista){
		if (node!=null) {
			lista.add(node.value);
			recPreordem(node.left,lista);
			recPreordem(node.rigth,lista);
		}
	}

}
class Node{
	public Node parent;
	public Node rigth;
	public Node left;
	public int value;
	public Node(int v){
		this.value = v;
		this.left = null;
		this.rigth = null;
		this.parent = null;
	}
	public boolean isLeaf(){
		return rigth==null && left==null;
	}
	public boolean onlyChieldLeft(){
		return rigth==null && left!=null;
	}
	public boolean onlyChieldRigth(){
		return rigth!=null && left==null;
	}
	
}
