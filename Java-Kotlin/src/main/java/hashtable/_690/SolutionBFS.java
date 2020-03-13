package hashtable._690;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionBFS {

    public int getImportance(List<Employee> employees, int id) {
        //dump all the employee info into a map which is a helpful look up data structure
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        // building a query queue
        Queue<Integer> employeeIdQueue = new PriorityQueue<>();
        employeeIdQueue.add(id);

        int importanceSum = 0;
        while (!employeeIdQueue.isEmpty()) {
            Employee employee = map.get(employeeIdQueue.poll());
            importanceSum += employee.importance;
            for (Integer employeeId : employee.subordinates) {
                Employee curEmployee = map.get(employeeId);
                importanceSum += curEmployee.importance;
                employeeIdQueue.addAll(curEmployee.subordinates);
            }
        }

        return importanceSum;
    }

    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        int id;
        // the importance value of this employee
        int importance;
        // the id of direct subordinates
        List<Integer> subordinates;

        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee employee2 = new Employee(2, 3, Arrays.asList(4));
        Employee employee3 = new Employee(3, 4, Collections.emptyList());
        Employee employee4 = new Employee(4, 1, Collections.emptyList());

        List<Employee> list = Arrays.asList(employee1, employee2, employee3, employee4);
        System.out.println(new SolutionBFS().getImportance(list, 1));
    }

}
