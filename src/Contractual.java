import base.Employee;

public class Contractual extends Employee {

    @Override
    public Double onCompute(int workingDays) {
        return (workingDays * this.getSalary());
    }


    @Override
    public String toString() {
        return this.getFirstName()+";"+this.getLastName()+";"+ this.getAge()+";"+this.getSalary();
    }

}
