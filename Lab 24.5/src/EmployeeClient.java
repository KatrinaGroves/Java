import java.util.ArrayList;
import java.util.List;

class EmployeeClient {

	public static void main(String[] args) {

		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Employee(2567L, "Mike", "Flanning"));
		listOfEmployees.add(new Employee(2568L, "Maria", "Suarez"));
		listOfEmployees.add(new Employee(2569L, "Crystal", "Roark"));
		listOfEmployees.add(new Employee(2566L, "Mike", "Flanning"));

		Employee.employeeList(listOfEmployees).forEach(System.out::println);
		System.out.println("\r");
		EmployeeSortedList.sortEmployees(listOfEmployees).forEach(System.out::println);
	}
}
