import java.util.Scanner;
import java.util.Random;

public class MergeSort {
	int arr[];
	int n;
	
	MergeSort(int size){
		n=size;
		arr=new int[n];
	}
	
	void readArray()
	 {
		Random rd = new Random();
		for(int i=0;i<n;i++) {
			arr[i]=rd.nextInt(1000);
		}
		System.out.println("Given array is");
		display();
		System.out.println();
	}
	
	void display() {
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	
	void mergeSort(int low , int high) 
	{
		if(low<high) 
		{
			int mid = (low+high)/2;
			mergeSort(low,mid);
			mergeSort(mid+1,high);
			merge(low,mid,high);
		}
	}
	
	void merge(int low,int mid,int high) 
	{
		int i=low,j=mid+1,k=low;
		int temp[]=new int[high+1];
		while(i<=mid && j<=high)
		{
			if(arr[i]<=arr[j])
				temp[k++]=arr[i++];
			else
				temp[k++]=arr[j++];
		}
		while(i<=mid)
			temp[k++]=arr[i++];
		while(j<=high)
			temp[k++]=arr[j++];
		for(int l=low;l<=high;l++)
			arr[l]=temp[l];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int size=sc.nextInt();
		MergeSort m = new MergeSort(size);
		m.readArray();
		long start=System.nanoTime();
		m.mergeSort(0,m.n-1);
		long end = System.nanoTime();
		System.out.println("The sorted array is");
		m.display();
		System.out.println("The time taken is "+(end-start)+" ns");
	}

}
