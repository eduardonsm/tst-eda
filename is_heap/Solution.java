import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
        int[] heap = new int[entrada.length];
		for (int i = 0; i < heap.length; i++) {
            heap[i] = Integer.parseInt(entrada[i]);
        }
		System.out.println(isHeap(heap));
	}
	public static boolean isHeap(int[] heap){
		for (int i = heap.length-1; i>=1; i--) {
            if (heap[i]>heap[parent(i)]) {
                return false;
            }
        }
        return true;
	}

    public static int parent(int i){
    if (i<=0) {
        return -1;
    }
    int index = (i-1)/2;
    return index;
}
}

