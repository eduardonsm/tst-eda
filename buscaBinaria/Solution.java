import java.util.Scanner;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		for(int i =0;i<numeros.length;i++){
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		int key=sc.nextInt();
		buscaBinaria(numeros,0,numeros.length-1,key);

	}
	public static int buscaBinaria(int[] v,int ini,int fim,int key){
		if(fim>=ini){
			int meio = ini+((fim-ini)/2);
			System.out.println(meio);
			if (key==v[meio]){
				return meio;
			}
			if (v[meio]>key){
				return buscaBinaria(v,ini,meio-1,key); 
			}
			if (v[meio]<key){return buscaBinaria(v,meio+1,fim,key);}
		} 
		System.out.println("-1");
		return -1;
	}
}
