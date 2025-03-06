import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		for(int i = 0;i<entrada.length;i++){
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		particiona(numeros);
	}
	private static void particiona(int[] v){
			int i = 1;
	int j = v.length-1;
	int pivot = v[0];

	while (i <= j) {

		// andando com i para frente. pára quando encontrar um valor maior que o pivot
		while (i <= j && v[i] <= pivot)
			i++;

		// andando com j para trás. pára quando encontrar um valor menor ou igual ao pivot
		while(i <= j && v[j] > pivot)
                j = j - 1;
         
        // se i não encontrou j, troca
        if (i < j)
        	swap(v, i, j);

	}

	swap(v, 0, j);
	System.out.println(Arrays.toString(v));
		
	}

	private static void swap(int[] v,int i, int j){
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;	
	}
}
