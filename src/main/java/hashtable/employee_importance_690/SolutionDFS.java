package hashtable.employee_importance_690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionDFS {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return getImportance(map, id);
    }

    private int getImportance(Map<Integer, Employee> map, int id) {
        Employee currentEmployee = map.get(id);
        if (currentEmployee.subordinates.isEmpty()) {
            return currentEmployee.importance;
        }

        int subordinateSum = 0;
        for (int index : currentEmployee.subordinates) {
            subordinateSum += getImportance(map, index);
        }

        return currentEmployee.importance + subordinateSum;
    }

    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
