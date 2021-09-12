import base.Employee;
import base.Item;

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
                break;
            }

            case 2: {
                computeIncome();
                break;
            }
            case 3: {
                addInventory();
                break;
            }


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
        ArrayList<Contractual> contractualList = getContractualEmployees();
        double totalContractualSalary = 0;
        for (Contractual c : contractualList) {
            totalContractualSalary += c.getSalary();

            totalContractualSalary= totalContractualSalary + c.getSalary();
        }

        ArrayList<Permanent> permanentList = getPermanentEmployees();
        double totalPermanentSalary = 0;
        for (Permanent c : permanentList) {
            totalPermanentSalary += c.getSalary();
        }

        ArrayList<Item> itemList = getInventory();
        double totalAmountSoldItem = 0;
        for (Item i : itemList) {
            totalAmountSoldItem += i.computeSales();

            System.out.println("Remaining items for " + i.getName() + " " + i.computeRemainingItem());
        }
        System.out.println("Total Income: " + (totalAmountSoldItem - (totalPermanentSalary + totalContractualSalary)));

    }

    private static void addInventory() {
        System.out.println("Name:");
        String name = input.next();
        System.out.println("Quantity:");
        int quantity = input.nextInt();
        System.out.println("Price:");
        double price = input.nextDouble();
        System.out.println("Sold:");
        int sold = input.nextInt();

        Item item = new Item();

        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setSold(sold);

        boolean isSaved = saveToFile("inventory.csv", item.toString());
        System.out.println(isSaved ? "Inventory data saved." : "An error occurred. Unable to save data");

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


    private static ArrayList<Contractual> getContractualEmployees() {

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

    private static ArrayList<Permanent> getPermanentEmployees() {

        ArrayList<Permanent> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader("permanent.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] value = line.split(";");
                Permanent p = new Permanent();
                p.setFirstName(value[0]);
                p.setLastName(value[1]);
                p.setAge(Integer.parseInt(value[2]));
                p.setSalary(Double.parseDouble(value[3]));

                list.add(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    private static ArrayList<Item> getInventory() {

        ArrayList<Item> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] value = line.split(";");
                Item i = new Item();
                i.setName(value[0]);
                i.setPrice(Double.parseDouble(value[1]));
                i.setSold(Integer.parseInt(value[2]));
                i.setQuantity(Integer.parseInt(value[3]));

                list.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}
