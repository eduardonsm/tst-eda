import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		for(int i = 0;i<entrada.length;i++){
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		int d = sc.nextInt();
		radixSort(numeros,d);
	}
	private static void radixSort(int[] v, int d){
		for(int i = 0;i<d;i++){
			countingSort(v,i);
		}
	}

	private static void countingSort(int[] v,int expo){
		int[] c = new int[9];
		for(int i=0;i<v.length;i++){
			int digit = (int )(v[i]/Math.pow(10,expo))%10;
			c[digit-1] +=1;
		}
		for(int i=1;i<c.length;i++){
			c[i] += c[i-1];
		}
		int[] b = new int[v.length];
		for(int i = v.length-1;i>=0;i--){
			int digit =(int) (v[i]/Math.pow(10,expo))%10;
			b[c[digit-1]-1] = v[i];
			c[digit-1] -= 1;
		}
		System.out.println(Arrays.toString(b));
	}
}
