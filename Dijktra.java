
import java.util.Scanner;

public class Dijktra{
	int n,source;
	int cost[][],d[],near[];
	int u=1;
	int v=1;
	
	Dijktra(int n,int source){
		this.n=n;
		this.source=source;
		cost=new int[n+1][n+1];
		d=new int[n+1];
		near=new int[n+1];
	}
	
	void readMatrix() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the elements of cost adjacency matrix row-wise");
		for(int i=1;i<=n;i++)
		{ 
			for(int j=1;j<=n;j++)
				cost[i][j]=sc.nextInt();
		}
	}
	
	void display() {
		System.out.println("The shortest paths are");
		for(int v=1;v<=n;v++) 
		{
			int i=v;
			do {
			System.out.print(i);
			System.out.print("<--");
			i=near[i];
			}while(i!=source);
			System.out.print(source);
			System.out.print("\tcost is" +d[i]);
			System.out.println();
		}
	}
	
	void dijktra() {
		int visited[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			d[i]=cost[source][i];
			near[i]=source;
			visited[i]=0;                                                      
		}
		visited [source]=1;
		for (int k=1;k<=n-2;k++)
		{
			int min=999;
			for(int i=1;i<=n;i++)
			{
				if(visited[i]==0 && d[i]<min) {
					min=d[i];
					u=i;  
				}
				visited[u]=1;
				for(v=1;v<=n;v++)
				{
					if(visited[v]==0 && d[u]+cost[u][v]<d[v])
					{
						d[v]=d[u]+cost[u][v];
						near[v]=u;
					}
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices ");
		int n=sc.nextInt();
		System.out.println("Enter the source :");
		int source=sc.nextInt();
		Dijktra obj=new Dijktra(n,source);
		obj.readMatrix();
		obj.dijktra();
		obj.display();
		sc.close();
	}

}

/*
0
3
2
999
8
999
0
999
5
4
999
999
0
1
999
999
999
999
0
2
999
999
999
999
0
*/


/*
 0
10
7
900
10
0
11
21
7
11
0
18
900
21
18
0
 */