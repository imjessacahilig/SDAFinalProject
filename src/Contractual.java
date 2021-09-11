import base.Employee;

public class Contractual extends Employee {

    @Override
    public Double onCompute(int workingDays) {
        return (workingDays * this.getSalary());
    }
}
