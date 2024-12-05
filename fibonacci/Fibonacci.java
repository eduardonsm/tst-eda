import java.util.Scanner;
public class Fibonacci{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int nmr = sc.nextInt();
        System.out.println(fibonacci(nmr));
    }
    public static int fibonacci(int nmr){
        if(nmr == 0){
            return 0;
        }
        if (nmr == 1){
            return 1;
        }
        return fibonacci(nmr-1)+fibonacci(nmr-2);
        
    }
}

