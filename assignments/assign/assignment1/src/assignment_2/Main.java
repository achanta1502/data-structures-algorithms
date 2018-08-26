package assignment_2;
public class Main {

	public static void main(String[] args) {
		int[] arr= {50,45,34,33,31,30,27,25,22,21,19,16,14,11,10,8,5,3,2,1};
		int val=26;
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i]+" ");
		int output=terinarySearch(arr, 0, arr.length-1, val);
		System.out.println();
		if(output==-1) {
			System.out.print("The value you are searching is not in the array");
		}else {
			System.out.print("The index of the value is "+output);
		}
		
	}
public static int terinarySearch(int arr[],int min,int max,int val) {
	
	if(min>max) {
		return -1;
	}
	int pos=min+(max-min)/3;
	int pos2=min+2*(max-min)/3;
	if(arr[pos]==val) {
		return pos;
	}else if(arr[pos2]==val) {
		return pos2;
	}else
	if(arr[pos]<val) {
		return terinarySearch(arr,min,pos-1,val);
	}else
		if(arr[pos2]>val ) {
			return terinarySearch(arr, pos2+1, max, val);
			
		}else
		{
			return terinarySearch(arr, pos, pos2, val);
		}
	
	
}
}

