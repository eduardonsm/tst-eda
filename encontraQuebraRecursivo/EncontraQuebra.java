import java.util.Scanner;
public class EncontraQuebra{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int[] numeros = new int[seq.length];
        for (int i =0;i<seq.length;i++){
            numeros[i] = Integer.parseInt(seq[i]);
        }
        System.out.println(encontraQuebra(numeros,0));
    }
    public static int encontraQuebra(int[] v,int index){
        if (index==v.length || v.length==1){
            return -1;
        }
        if(index>0){
            if(v[index]<v[index-1]){
                return index;
            }

        }   
        return encontraQuebra(v,index+1);
        
    }
}
