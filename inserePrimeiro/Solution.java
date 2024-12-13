import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int[] numeros = new int[entrada.length];
                for(int i = 0;i<entrada.length;i++){
                        numeros[i] = Integer.parseInt(entrada[i]);
                }
                inserePrimeiro(numeros);
        }
        public static void inserePrimeiro(int[] v){
                int i = 0;
                while(i<v.length-1&&v[i]>v[i+1]){
                        swap(i,i+1,v);
                        i++;
                }
                System.out.println(Arrays.toString(v));
        }
	//https://docs.oracle.com/en/java/javase/22/docs/api/index.html
        public static void swap(int i,int j, int[] v){
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
        }
}
