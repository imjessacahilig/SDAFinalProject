import base.Employee;

public class Permanent extends Employee {

    private final Double sss= 100.0;
    private final Double pagibig = 100.0;
    private final Double philhealth = 100.0;

    @Override
    public Double onCompute(int workingDays) {

        double netSalary= this.getSalary()*0.25;
        return (workingDays * netSalary - (sss+ pagibig+philhealth));

    }

    @Override
    public String toString() {
        return this.getFirstName()+";"+this.getLastName()+";"+ this.getAge()+";"+this.getSalary()+";P";
    }
}
