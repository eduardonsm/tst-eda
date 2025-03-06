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
		int pivot =v[ 0];
		int i = 0;
		for (int j = 1;j<v.length;j++){
			if (v[j] < pivot){
				i++;
				slide(v,j,i);
			}
		}
		slide(v,0,i);
		System.out.println(Arrays.toString(v));
	}

	private static void slide(int[] v,int i,int j){
		if (i < j) {
            	while (i < j) {
                	int temp = v[i];
                v[i] = v[i + 1];
                v[i + 1] = temp;
                i++;
            }
        	} else { 
            	while (i > j) {
                int temp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = temp;
                i--;
            }
        }	
	}
}
