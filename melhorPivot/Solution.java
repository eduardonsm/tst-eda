import java.util.*;
public class Solution{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String[] entrada = sc.nextLine().split(" ");
                int[] numeros = new int[entrada.length];
                for(int i = 0;i<entrada.length;i++){
                        numeros[i] = Integer.parseInt(entrada[i]);
                }
		int i = sc.nextInt();
		int j = sc.nextInt();
                System.out.println(melhorPivot(numeros,i,j));
        }
        public static int melhorPivot(int[] v,int i, int j){
                int pivI = v[i];
		int maiorPI = 0;
		int menorPI = 0;
		int maiorPJ = 0;
		int menorPJ = 0;
                int pivJ = v[j];
                for(int k = 0;k<v.length;k++){
			if(k == i || k == j)
				continue;
			int elem = v[k];
			if (elem>pivI)
				maiorPI++;
			else
				menorPI++;
			if (elem>pivJ)
				maiorPJ++;
			else
				menorPJ++;
		}
		int difPI = maiorPI - menorPI;
		int difPJ = maiorPJ - menorPJ;
		if (difPI<0)
			difPI*=-1;
		if(difPJ<0)
			difPJ*=-1;
		if(difPI<=difPJ)
			return i;
		return j;
	}
}
