package visit;

public class HRDepartment extends Department {
    @Override
    public void visit(FulltimeEmployee employee) {
        System.out.println("HRDepartment handle FulltimeEmployee" + employee.getName());
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        System.out.println("HRDepartment handle ParttimeEmployee" + employee.getName());
    }
}
