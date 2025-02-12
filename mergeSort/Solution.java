import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		for(int i = 0;i<entrada.length;i++){
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		mergeSort(numeros,0,numeros.length-1);
	}
	public static void mergeSort(int[] v, int ini, int fim){
		if (ini<fim){
			int meio = (ini+fim)/2;
			mergeSort(v,ini,meio);
			mergeSort(v,meio+1,fim);
			merge(v,ini,meio,fim);
		System.out.println(Arrays.toString(v));
		}
		
	}
	public static void merge(int[] v, int ini, int meio, int fim){
		int[] helper = new int[v.length];
		for (int i =ini;i<=fim;i++)
			helper[i] = v[i];
		int i = ini;
		int j = meio+1;
		int k = ini;
		while(i<=meio&&j<=fim){
			if(helper[i] <= helper[j])
				v[k++] = helper[i++];
			else
				v[k++] = helper[j++];
		}
		while(i<=meio)
			v[k++] = helper[i++];
	}
}
