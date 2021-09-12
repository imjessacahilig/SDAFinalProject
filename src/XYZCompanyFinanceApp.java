import base.Employee;

import java.io.*;
import java.util.ArrayList;
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
                computeIncome();
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

    private static void computeIncome() {

    }

    private static void addEmployee() {

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
            case 1: {
                Contractual contractual = new Contractual();
                contractual.setFirstName(firstName);
                contractual.setLastName(lastName);
                contractual.setAge(age);
                contractual.setSalary(salary);
                boolean isSaved = saveToFile("contractual.csv", contractual.toString());
                System.out.println(isSaved ? "Employee data saved." : "An error occurred. Unable to save data");

                ArrayList<Contractual> list = getAllContractual();
                for (Contractual c : list) {
                    System.out.println(c.getSalary());
                }
                break;
            }
            case 2: {
                Permanent permanent = new Permanent();
                permanent.setFirstName(firstName);
                permanent.setLastName(lastName);
                permanent.setAge(age);
                permanent.setSalary(salary);
                boolean isSaved = saveToFile("permanent.csv", permanent.toString());
                System.out.println(isSaved ? "Employee data saved." : "An error occurred. Unable to save data");

                break;
            }
        }


    }

    private static boolean saveToFile(String fileName, String value) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(value + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        } finally {

            return true;
        }

    }

    // sample save object in a file
    private static boolean saveAsObject(String fileName, Object object) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            objectOut.close();
        } catch (IOException e) {

            return false;
        } finally {
            return true;
        }

    }


    private static ArrayList<Contractual> getAllContractual() {

        ArrayList<Contractual> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader("contractual.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] value = line.split(";");
                Contractual c = new Contractual();
                c.setFirstName(value[0]);
                c.setLastName(value[1]);
                c.setAge(Integer.parseInt(value[2]));
                c.setSalary(Double.parseDouble(value[3]));

                list.add(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}
