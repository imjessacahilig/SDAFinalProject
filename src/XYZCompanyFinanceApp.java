import java.util.Scanner;

public class XYZCompanyFinanceApp {

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("[1] - Add Employee\n" + "[2] - Compute Company income\n" + "[3] - Inventory");
        int num = input.nextInt();
        switch (num) {
            case 1: {
                addEmployee();
            }
            break;
            case 2: {
            }
            break;

        }
     /*   Pencil pencil = new Pencil();
        pencil.setName("ABC");
        pencil.setPrice(10);
        pencil.setQuantity(100);
        pencil.setSold(50);

        Contractual contractual = new Contractual();
        contractual.setFirstName("Juan");
        contractual.setLastName("De la Cruz");
        contractual.setSalary(450.0);
        contractual.setAge(25);*/

    }

    private static void addEmployee(){

        System.out.println("First name:");
        String firstName = input.next();
        System.out.println("Last name:");
        String lastName = input.next();
        System.out.println("Age:");
        int age = input.nextInt();
        System.out.println("Salary:");
        double salary = input.nextDouble();

        System.out.println("(1) Contractual ; (2) Permanent");
        int status = input.nextInt();
        switch (status) {
            case 1:{
                Contractual contractual = new Contractual();
                contractual.setFirstName(firstName);
                contractual.setLastName(lastName);
                contractual.setAge(age);
                contractual.setSalary(salary);
                break;
            }
            case 2: {
                Permanent permanent = new Permanent();
                permanent.setFirstName(firstName);
                permanent.setLastName(lastName);
                permanent.setAge(age);
                permanent.setSalary(salary);
                break;
            }
        }
    }
}
