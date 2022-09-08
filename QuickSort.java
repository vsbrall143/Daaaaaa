import java.util.*;

public class QuickSort
{
	int arr[];
	int n;
	
	QuickSort(int n)
	{
		this.n=n;
		arr=new int[n+1];
		arr[n]=1001;
	}
	
	void readArray() 
	{
		Random rd = new Random();
		for(int i=0;i<n;i++)
		{
			arr[i]=rd.nextInt(1000);
		}
		System.out.println("Given array is");
		display();
		System.out.println();
	}
	
	void display() 
	{
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	
	void quickSort(int low , int high) 
	{
		if(low<high) 
		{
			int j=partition(low,high);
			quickSort(low,j-1);
			quickSort(j+1,high);
		}
	}
	
	int partition(int low,int high) 
	{
		int pivot=arr[low],i=low,j=high+1;
		while(i<j) 
		{
			do {
				i++;
			}while(pivot>=arr[i]);
			do {
				j--;
			}while(pivot<arr[j]);
			if(i<j) 
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[j];
		arr[j]=arr[low];
		arr[low]=temp;
		return j;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int n=sc.nextInt();
		QuickSort q = new QuickSort(n);
		q.readArray();
		long start=System.nanoTime();
		q.quickSort(0,q.n-1);
		long end = System.nanoTime();
		System.out.println("The sorted array is");
		q.display();
		System.out.println("The time taken is "+(end-start)+" ns");
	}

}
