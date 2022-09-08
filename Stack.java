import java.util.Scanner;

public class Stack {
    int max = 5;
    int top = -1;
    int s[] = new int[max];

    void push(int ele) {
        if (top == max - 1) {
            System.out.println("overflow");
        } else {
            s[++top] = ele;
        }

    }

    void pop() {
        if (top == -1) {
            System.out.println("empty");
        } else {
            int ele = s[top--];
            System.out.println("poped element is: " + ele);
        }
    }

    void display() 
    {
        if (top == -1)
            System.out.println("empty");
        else 
        {
            System.out.println("the elements of stack are: ");
            for (int i=top;i>-1;i--) 
            {
                System.out.println(s[i] + " ");
            }
        }
    }

    public static void main(String args[]) 
    {
        int q = 1;
        Stack m= new Stack();
        Scanner sc = new Scanner(System.in);
        while (q != 0) 
        {
            System.out.println("1. push 2.pop 3. display 4.Exit");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            switch (ch) 
            {
                case 1:
                    System.out.println("enter the element to be pushed");
                    int ele = sc.nextInt();
                    m.push(ele);
                    break;
                case 2:
                    m.pop();
                    break;
                case 3:
                    m.display();
                    break;
                case 4:
                    q = 0;
            }
        }
    }
}
