import java.util.Scanner;
public class Floyd {
	int n;
	int d[][];
	int c[][];
	Floyd(int s){
		n=s;
		d=new int[n+1][n+1];
		c=new int[n+1][n+1];
	}
	void read() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the elements of cost adjacency matrix row-wise");
		for(int i=1;i<=n;i++)
		{ 
			for(int j=1;j<=n;j++)
				c[i][j]=sc.nextInt();
		}
	}
	
	void display() {
		System.out.println("The shortest paths are");
		for(int i=1;i<=n;i++) 
		{
			for (int j=1;j<=n;j++)
			{
				System.out.print(d[i][j]+"\t");
				
			}
			System.out.println();
		}
	}
	
	void floyd()
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				d[i][j]=c[i][j];
			}
		}
		
		for(int k=1;k<=n;k++)
		{
			for(int l=1;l<=n;l++)
			{
				for (int j=1;j<=n;j++)
				{
					if(d[l][j]>d[l][k]+d[k][j])
					{
						d[l][j]=d[l][k]+d[k][j];
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices ");
		int size=sc.nextInt();
		Floyd obj=new Floyd(size);
		obj.read();
		obj.floyd();
		obj.display();
		sc.close();
	}


}

/*
 0
999
3
999
2
0
999
999
999
7
0
1
6
999
999
0
 */