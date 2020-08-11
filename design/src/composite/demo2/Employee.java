package composite.demo2;

public class Employee implements HumanResource {
    double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    @Override
    public double countSalary() {
        return salary;
    }
}
