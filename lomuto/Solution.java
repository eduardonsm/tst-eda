import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int[] numeros = new int[entrada.length];
                for(int i =0;i<numeros.length;i++){
                        numeros[i] = Integer.parseInt(entrada[i]);
                }
             
                particionamento(numeros);

        }
        public static void particionamento(int[] v){
		int pivot = v[0];
		int i = 0;
		for(int j=1;j<v.length;j++){
			if(v[j] <= pivot){
				i++;
				swap(v,j,i);		
				System.out.println(Arrays.toString(v));              
			}
		}
		
		swap(v,0,i);

		System.out.println(Arrays.toString(v));              
		System.out.println(Arrays.toString(v));              
	}
	private static void swap(int[]v,int i,int j){
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}
