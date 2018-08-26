package assgn3;
import java.util.Scanner;
import java.util.Random;
public class Main {

	private static Scanner input;

	public static void main(String[] args) {
	input = new Scanner(System.in);
	Random random=new Random();
	System.out.print("Enter number of elements");
	int size=input.nextInt();
	System.out.println();
	int []arr=new int[size+1];
	arr[0]=size;
	System.out.print("Array before heap: ");
	for(int i=1;i<=size;i++) {
		arr[i]=random.nextInt(100);
		System.out.print(arr[i]+" ");
	}
	System.out.println();
	Heap heap=new Heap();
	int[] b=heap.heap(arr, size/2);
	System.out.print("Array After heap: ");
	for(int i=1;i<=size;i++) {
		System.out.print(b[i]+" ");
	}
	System.out.println();
	System.out.print("Array After heapSort: ");
	int[] result=heap.heapSort(b);
	for(int j=1;j<=size;j++) {
		System.out.print(result[j]+" ");
	}
	}

}
