import java.util.Scanner;

public class RaiseException {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values of a and b");
		int a=sc.nextInt();
		int b=sc.nextInt();
		try {
			System.out.println("The value of a/b is "+a/b);
		}
		catch(ArithmeticException e){
			System.out.println("division  by zero is not possible "+e);
		}
	}

}

