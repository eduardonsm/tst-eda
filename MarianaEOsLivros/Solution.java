import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(",");
                insertionSort(entrada);
        }
        public static void insertionSort(String[] v){
                for(int i = 0;i<v.length;i++){
                int j=i;
                while(j>0 && v[j].compareTo(v[j-1])<0){
                        swap(j,j-1,v);
                        j--;
                }
                printaLista(v);

                }
                }
        public static void swap(int i,int j, String[] v){
                String aux = v[i];
                v[i] = v[j];
                v[j] = aux;
        }
public static void printaLista(String[] lista){
                String out =lista[0];
                for(int i=1;i<lista.length;i++){
                        out+=", "+lista[i];
                }
                System.out.println(out);
        }

}
