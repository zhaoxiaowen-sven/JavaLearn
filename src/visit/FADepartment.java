package visit;

public class FADepartment extends Department {


    @Override
    public void visit(FulltimeEmployee employee) {
        System.out.println("FADepartment handle FulltimeEmployee" + employee.getName());
    }

    @Override
    public void visit(ParttimeEmployee employee) {
        System.out.println("FADepartment handle ParttimeEmployee" + employee.getName());

    }
}
