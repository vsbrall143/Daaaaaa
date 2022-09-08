
import java.util.Scanner;

public class DpKnapsack {
    int p[], w[], x[], v[][], n, M;

    DpKnapsack(int size, int M) {
        this.n = size;
        this.M = M;
        p = new int[n + 1];
        x = new int[n + 1];
        v = new int[n + 1][M + 1];
        w = new int[n + 1];
    }

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the w array");
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.println("enter the p array");
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
    }

    int max(int a, int b) {
        if (b > a) {
            return b;
        } else {
            return a;
        }
    }

    void Dpknapsack() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else {
                    if (w[i] > j)
                        v[i][j] = v[i - 1][j];

                    else
                        v[i][j] = max(v[i - 1][j], v[i - 1][j - w[i]] + p[i]);
                }
            }
        }
        int j = M;
        for (int i = 1; i <= n; i++) {
            if (v[i][j] == v[i - 1][j]) {
                x[i] = 0;
            }

            else {
                x[i] = 1;
                j = j - w[i];
            }
        }
        System.out.println("the solution vector is");
        for (int k = 1; k <= n; k++) {
            System.out.println(x[k]);
        }
        System.out.println("the profit earned is " + v[n][M]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the numbers");
        int n = sc.nextInt();
        System.out.println("enter the max: ");
        int M = sc.nextInt();
        DpKnapsack ob = new DpKnapsack(n, M);
        ob.read();
        ob.Dpknapsack();
    }
}
