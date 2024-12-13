import java.util.Scanner;
import java.util.Arrays;
public class SelecSort{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		for(int i =0;i<numeros.length;i++){
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		selectionSort(numeros);

	}
	public static void selectionSort(int[] v){
		for(int j=0;j<v.length;j++){
			int indiceMenor=j;
			for (int i=j+1;i<v.length;i++){
				if(v[i]<v[indiceMenor]){
					indiceMenor=i;
				}
			}
			if (j!=indiceMenor){
				swap(j,indiceMenor,v);
				System.out.println(Arrays.toString(v));

			}
		}
	}
	public static void swap(int ini,int prox,int[] v){
		int aux=v[ini];
		v[ini]=v[prox];
		v[prox]=aux;
	}
}
