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
                selectionSort(numeros,0);

        }
        public static int[] selectionSort(int[] v,int ini){
                if (ini==v.length-1)
			return v;	
		int indiceMenor=ini;
                        for (int i=ini+1;i<v.length;i++){
                                if(v[i]<v[indiceMenor]){
                                        indiceMenor=i;
                                }
                        }
                                swap(ini,indiceMenor,v);
                                System.out.println(Arrays.toString(v));
			return selectionSort(v,ini+1);
                }
        public static void swap(int ini,int prox,int[] v){
                int aux=v[ini];
                v[ini]=v[prox];
                v[prox]=aux;
        }
}
