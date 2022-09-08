import java.util.Scanner;
public class Prims{
    int Cost[][],d[],Near[],t[][];
    int n;
    int minicost;
    Prims(int size){
        n=size+1;
        Cost=new int[n][n];
        d=new int[n];
        Near=new int[n];
        t=new int[size][2];
    }

    void read(){
        System.out.println("Enter Elements of Matrix:");
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                Cost[i][j]=sc.nextInt();
            }
            System.out.println();
        }
        sc.close();
    }

    void prims(){
        int k=0;
        int l=0;
        int min=999;
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Cost[i][j]<min){
                    min=Cost[i][j];
                    k=i;
                    l=j;
                }
            }
        }
        minicost=Cost[k][l];
        //initializing Distance Matrix and Near matrix from k,l to nearest vertices
        for(int i=1;i<n;i++){                                               
            if(Cost[i][k]<Cost[i][l]){
                Near[i]=k;
            }
            else{
                Near[i]=l;
            }
            d[i]=Cost[i][Near[i]];
        }
        t[0][0]=k;
        t[0][1]=l;
        Near[k]=Near[l]=0;
        int j=0;
        for(int i=1;i<n-2;i++){
            min=999;
            for(int v=1;v<n;v++){
                if(Near[v]!=0 && d[v]<min){
                    min=d[v];
                    j=v;
                }
            }
            t[i][0]=j;
            t[i][1]=Near[j];
            minicost=minicost+d[j];
            Near[j]=0;
            for(int v=1;v<n;v++){
                if(Near[v]!=0 && d[v]>Cost[j][v]){
                    d[v]=Cost[j][v];
                    Near[v]=j;
                }
            }
        }
    }
    void display(){
        System.out.println("THe Minimum Spanning Tree Edges are:");
        for(int i=0;i<n-2;i++){
            System.out.println("("+t[i][0]+","+t[i][1]+")"+"\tCost ="+Cost[t[i][0]][t[i][1]]);
        }
        System.out.println("THe cost of Spanning Tree is "+minicost);

    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of Vertices:");
        int size=in.nextInt();
        Prims p=new Prims(size);
        p.read();
        p.prims();
        p.display();
        in.close();
        
    }
}

/*
0
1
4
999
1
0
999
2
4
999
0
3
999
2
3
0
*/