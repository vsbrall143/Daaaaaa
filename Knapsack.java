import java.util.Scanner;

public class Knapsack {
    int n, M, profit;
    int w[], p[], x[];

    Knapsack(int size, int max) {
        n = size;
        w = new int[n + 1];
        p = new int[n + 1];
        x = new int[n + 1];
        M = max;
    }

    void read() {
        Scanner c = new Scanner(System.in);
        System.out.println("enter the w array");
        for (int i = 0; i < n; i++) {
            w[i] = c.nextInt();
        }
        System.out.println("enter the p array");
        for (int i = 0; i < n; i++) {
            p[i] = c.nextInt();
        }
    }

    void knapsack() {
        int rc = M;
        profit = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] <= rc) 
            {
                x[i] = 1;
                rc = rc - w[i];
            } 
            else
            {
                x[i] = rc / w[i];
            }
            System.out.println("the solution vector is" + x[i]);
        }

        for (int i = 0; i < n; i++) {
            profit += (x[i] * p[i]);
        }
        System.out.println("the profit is: " + profit);
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("enter the size");
        int size = c.nextInt();
        System.out.println("enter the max capacity");
        int max = c.nextInt();
        Knapsack o = new Knapsack(size, max);
        o.read();
        o.knapsack();

    }
}
