package composite.demo2;

public class CompositeTest {
    public static void test() {
        Department department = new Department();
        HumanResource humanResource = new Employee(1);
        HumanResource humanResource2 = new Employee(2);
        department.add(humanResource);
        department.add(humanResource2);
        System.out.println(department.countSalary());
    }
}
