import java.util.Scanner;
public class Student {
	String nm,sn,bh,ph;
	
	Student(String name,String usn,String branch,String phnNumber){
		nm=name;
		sn=usn;
		bh=branch;
		ph=phnNumber;
	}
	
	void display() {
		System.out.println(nm+"\t"+sn+"\t"+bh+"\t\t"+ph);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of students");
		int n=sc.nextInt();
		Student s[]=new Student[n];
		sc.nextLine();
		for(int i=0;i<n;i++) {
			System.out.println("Enter the name usn branch and phone number of the student "+(i+1));
			String name=sc.nextLine();
			String usn=sc.nextLine();
			String branch=sc.nextLine();
			String phnNumber=sc.nextLine();
			s[i]= new Student(name,usn,branch,phnNumber);
		}
		System.out.println("Name \t\t USN \t\t Branch \t Phone Number  ");
		System.out.println("---------------------------------------------------------------------------");
		for(int i=0;i<n;i++) 
			s[i].display();		
	}
}
