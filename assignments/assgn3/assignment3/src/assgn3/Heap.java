package assgn3;

public class Heap {
protected int[] heap(int[] arr,int pos) {
	int left=pos*2;
	int right=pos*2+1;
	int max=0;
	if(pos<1) {
		return arr;
	}else
	{
		if(left<arr.length) {
			if(right>arr.length-1) {
				max=left;
			}else {
				max=(arr[left]>arr[right])?left:right;
			}
			if(arr[pos]<arr[max]) {
				
					int temp=arr[pos];
					arr[pos]=arr[max];
					arr[max]=temp;
			perculateDown(arr,max);
			return heap(arr,pos-1);
			
		}else {return heap(arr,pos-1);}
		
	
		}	
	}
	
return arr;}
private void perculateDown(int[] a,int max) {
	int c1=max*2;
	int c2=max*2+1;
	int pos=0;
	if(c1>a[0] && c2>a[0]) {
		return;
	}if(c2>a[0]) {pos=c1;}else {
	pos=(a[c1]>a[c2])?c1:c2;}
	if(a[pos]>a[max]) {
		{int temp=a[pos];
		a[pos]=a[max];
		a[max]=temp;}
		perculateDown(a, pos);
	}else return;
	
}
protected int[] heapSort(int[] arr) {
	if(arr[0]<1) {
		return arr;
	}else {
		int temp=arr[arr[0]];
		arr[arr[0]]=arr[1];
		arr[1]=temp; 
		arr[0]--;
		perculateDown(arr,1);
		
		return heapSort(arr);
	}
	
}
}
