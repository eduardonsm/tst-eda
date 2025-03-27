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
		elementosMaiores(tree,n);
	}
	public static void elementosMaiores(BST tree, int n){
		System.out.println(Arrays.toString(tree.preOrdem().toArray()));
		int maiores = tree.elementosMaiores(n);
		System.out.println(maiores);
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
	public int elementosMaiores(int n){
		int soma=0;
		ArrayList<Integer> preOrdem = this.preOrdem();
		for(int i:preOrdem) {
			if (i>n) soma++;
		}
		return soma;
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
