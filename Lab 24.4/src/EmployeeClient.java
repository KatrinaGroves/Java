import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class EmployeeClient {

	public static void main(String[] args) {
		
		Map<Long, Employee> employees = new HashMap<>();
		Employee employee1 = new Employee(2567L, "Mike", "Flanning");
		Employee employee2 = new Employee(2568L, "Maria", "Suarez");
		Employee employee3 = new Employee(2569L, "Crystal", "Roark");
		employees.put(employee1.getEmpID(), employee1);
		employees.put(employee2.getEmpID(), employee2);
		employees.put(employee3.getEmpID(), employee3);
		
		Employee nextEmployee = employees.get(2568L);
		System.out.println(nextEmployee);
		
		System.out.println(2568L == nextEmployee.getEmpID());
		System.out.println(nextEmployee.equals(employee1));
		
		System.out.println(employees.containsKey(2567L));
		System.out.println(employees.containsKey(2569L));
		
		Iterator it = employees.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry me = (Entry)it.next();
			System.out.println(me.getValue().toString());
		}
		
		Employee p1 = new Employee(2973, "Ed", "Lance");
		Employee p2 = new Employee(2974, "Morgan", "Lance");
		Employee p3 = new Employee(2972, "Morgan", "Lance");
		Employee p4 = new Employee(2973, "Ed", "Lance");
		
		System.out.println("Employee 1 is Employee 2\n" + p1.equals(p2));
		System.out.println("Employee 1 is Employee 4\n" + p1.equals(p4));
		System.out.println("Employee 2 is Employee 3\n" + p2.equals(p3));
	}
}
