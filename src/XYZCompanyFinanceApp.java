public class XYZCompanyFinanceApp {

    public static void main(String[] args) {

        System.out.println("[1] - Add Employee\n" + "[2] - Compute Company income\n" + "[3] - Inventory");
        Pencil pencil = new Pencil();
        pencil.setName("ABC");
        pencil.setPrice(10);
        pencil.setQuantity(100);
        pencil.setSold(50);

        Contractual contractual = new Contractual();
        contractual.setFirstName("Juan");
        contractual.setLastName("De la Cruz");
        contractual.setSalary(450.0);
        contractual.setAge(25);

    }
}
