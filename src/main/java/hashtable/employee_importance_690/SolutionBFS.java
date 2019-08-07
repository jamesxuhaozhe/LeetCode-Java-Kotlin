package hashtable.employee_importance_690;

import java.util.*;

public class SolutionBFS {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Integer> employeeIdQueue = new PriorityQueue<>();
        employeeIdQueue.addAll(map.get(id).subordinates);
        if (employeeIdQueue.isEmpty()) {
            return map.get(id).importance;
        }

        int importanceSum = map.get(id).importance;
        while (!employeeIdQueue.isEmpty()) {
            Employee employee = map.get(employeeIdQueue.poll());
            importanceSum += employee.importance;
            for (Integer employeeId : employee.subordinates) {
                employeeIdQueue.addAll(map.get(employeeId).subordinates);
            }
        }

        return importanceSum;
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

    public static void main(String[] args) {

    }

}
