import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		BST tree = new BST();
		for (String in:entrada){
			tree.add(Integer.parseInt(in));
		}
		int n = sc.nextInt();
		valorProximo(tree,n);
	}
	public static void valorProximo(BST tree, int n){
		System.out.println(Arrays.toString(tree.preOrdem().toArray()));
		int proximo = tree.valorProximo(n);
		System.out.println(proximo);
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
	public int valorProximo(int n){
		return recValorProximo(this.root,n,this.root).value;
		
	}
	public Node recValorProximo(Node node, int n, Node menor){
		if (node==null) {
			return menor;
		}
		if (dif(node, n) < dif(menor, n)) {
			menor=node;
		}
		if (n<node.value) return recValorProximo(node.left, n, menor);
		else return recValorProximo(node.rigth, n, menor);
			
		
	}
	public int dif(Node node, int n){
		return Math.abs(node.value - n);
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
}
