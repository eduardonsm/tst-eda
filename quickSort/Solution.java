import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int[] numeros = new int[entrada.length];
                for(int i =0;i<numeros.length;i++){
                        numeros[i] = Integer.parseInt(entrada[i]);
                }
             
                quickSort(numeros,0,numeros.length-1);
		System.out.println(Arrays.toString(numeros));

        }
	private static void quickSort(int[] v,int left, int rigth){
		if(left<=rigth){
			int pivot = particionamento(v,left,rigth);
			quickSort(v,left,pivot-1);
			quickSort(v,pivot+1,rigth);
		}
	}
        public static int particionamento(int[] v, int left, int rigth){
	 	int pivot = v[left];
                int i = left;
                for(int j=left+1;j<=rigth;j++){
                        if(v[j] <= pivot){
                                i++;
                                swap(v,j,i);
                        }
                }

                swap(v,left,i);	
		return i;
	}
	private static void swap(int[]v,int i,int j){
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}
