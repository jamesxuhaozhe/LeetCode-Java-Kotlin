package hashtable.employee_importance_690

import java.util.HashMap

class SolutionKt {

    fun getImportance(employees: List<Employee>, id: Int): Int {
        val map = HashMap<Int, Employee>()
        for (employee in employees) {
            map[employee.id] = employee
        }

        return getImportance(map, id)
    }

    private fun getImportance(map: Map<Int, Employee>, id: Int): Int {
        val currentEmployee = map[id]
        if (currentEmployee?.subordinates!!.isEmpty()) {
            return currentEmployee.importance
        }

        var subordinateSum = 0
        for (index in currentEmployee.subordinates!!) {
            subordinateSum += getImportance(map, index)
        }

        return currentEmployee.importance + subordinateSum
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        var id: Int = 0
        // the importance value of this employee
        var importance: Int = 0
        // the id of direct subordinates
        var subordinates: List<Int>? = null
    }
}