import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int[] numeros = new int[entrada.length];
                for(int i =0;i<numeros.length;i++){
                        numeros[i] = Integer.parseInt(entrada[i]);
                }
		int k = sc.nextInt();
                coutingSort(numeros,k);

        }
        public static void coutingSort(int[] v,int k){
        	int[] c = new int[k+1];
		for(int i =0;i<v.length;i++){
			c[v[i]] +=1;
		System.out.println(Arrays.toString(c));
		}
		for(int i =1;i<c.length;i++){
			c[i] += c[i-1];
		}
		System.out.println("Cumulativa do vetor de contagem - "+Arrays.toString(c));
		int[] b = new int[v.length];
		for(int i=v.length-1;i>=0;i--){
			b[c[v[i]]-1] = v[i];
			c[v[i]] -= 1;
		}
		
		System.out.println(Arrays.toString(b));
        }
}
