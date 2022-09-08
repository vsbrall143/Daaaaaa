
import java.util.Scanner;
import java.util.StringTokenizer;

public class Customer {
	String name,dob;
	
	Customer(String name,String dob){
		this.name=name;
		this.dob=dob;
	}
	
	String modifyString() {
		String value=name;
		StringTokenizer tokenizer=new StringTokenizer(dob,"/");
		while(tokenizer.hasMoreTokens()) {
			value=value + ","+tokenizer.nextToken();
		}
		return value;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name and date of birth(dd/mm/yyyy) of the customer");
		String name=sc.nextLine();
		String dob = sc.nextLine();
		Customer obj = new Customer(name,dob);
		System.out.println("The customer details are "+obj.modifyString());
	}
}
