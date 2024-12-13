import java.util.Scanner;
import java.util.Arrays;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int[] numeros = new int[entrada.length];
                for(int i =0;i<numeros.length;i++){
                        numeros[i] = Integer.parseInt(entrada[i]);
                }
                insertionSort(numeros,1);

        }
        public static int[] insertionSort(int[] v,int ini){
                if (ini==v.length)
                        return v;
		int i = ini;
                while(i>0&&v[i]<v[i-1]){
		        swap(i,i-1,v);
			i-=1;
		}
                	System.out.println(Arrays.toString(v));
                       return insertionSort(v,ini+1);
                }
        public static void swap(int ini,int prox,int[] v){
                int aux=v[ini];
                v[ini]=v[prox];
                v[prox]=aux;
        }
}
