package composite.demo2;

import java.util.ArrayList;
import java.util.List;

public class Department implements HumanResource {
    private List<HumanResource> humanResources = new ArrayList<>();

    @Override
    public double countSalary() {
        int count = 0;
        for (HumanResource humanResource : humanResources) {
            count += humanResource.countSalary();
        }
        return count;
    }

    void add(HumanResource humanResource) {
        humanResources.add(humanResource);
    }
}
