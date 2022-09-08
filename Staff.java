import java.util.Scanner;
public class Staff {
    Scanner sc=new Scanner(System.in);
    int salary,StaffId;
    String name,phone;
    void read(){
       
        System.out.println("enter the staffid,name,salary,phone");
        StaffId=sc.nextInt();
        name=sc.next();
        salary=sc.nextInt();
        phone=sc.next();
    }
    void display(){
        System.out.println("StaffId\t\tname\t\tsalary\t\tphone\t\t");
        System.out.println(StaffId+"\t\t"+name+"\t\t"+salary+"\t\t"+phone+"\t\t");
    sc.close();}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no of the staff members");
        int n=sc.nextInt();
        Teaching a[]=new Teaching[n];
        technical b[]=new technical[n];
        contractor c[]= new contractor[n];
        for(int i=0;i<n;i++){
            a[i]=new Teaching();
            a[i].readt();
            b[i]=new technical();
            b[i].reads();
            c[i]=new contractor();
            c[i].readp();
        }
        for(int i=0;i<n;i++){
            a[i].displayt();
            b[i].displays();
            c[i].displayp();
        }
        sc.close();
    }



    }


class Teaching extends Staff{
    String domain,publication;
void readt(){
    System.out.println("enter the details of the teching staff");
    super.read();
    System.out.println("enter the domain and publication");
    domain=sc.next();
    publication=sc.next();
}
void displayt(){
super.display();
System.out.println("domain\t\tpublication");
System.out.println(domain+"\t\t"+publication);
}



}
class technical extends Staff{
    String skill;
    void reads(){
        System.out.println("the details of the technical staff");
        super.read();
        System.out.println("enter the skill");
        skill=sc.next();
}
void displays()
{
    System.out.println(" the details of the technical staff");
    super.display();
   System.out.println("skill");
    System.out.println(skill);
}
}
class contractor extends Staff{
    String period;
    void readp(){
        System.out.println("enter the details of the contract staff");
        super.read();
        System.out.println("enter the period");
        period=sc.next();
    }
    void displayp(){
        System.out.println("the details of the contract staff");
    super.display();
System.out.println("period");
System.out.println(period);
}

}