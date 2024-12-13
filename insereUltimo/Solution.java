import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		for(int i = 0;i<entrada.length;i++){
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		insereUltimo(numeros);
	}
	public static void insereUltimo(int[] v){
		int i = v.length-1;
		while(i>0&&v[i]<v[i-1]){
			swap(i,i-1,v);
			i--;
		}
		System.out.println(Arrays.toString(v));
	}
	public static void swap(int i,int j, int[] v){
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}
