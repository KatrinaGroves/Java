import java.util.Comparator;
import java.util.List;

class EmployeeSortedList implements Comparator {

	static List<Employee> sortEmployees(List<Employee> listOfEmployees) {
		listOfEmployees.sort(
				Comparator.comparing(Employee::getLastName).thenComparing(Comparator.comparing(Employee::getEmpID)));
		return listOfEmployees;
	}

	@Override
	public int compare(Object o1In, Object o2In) {
		return 0;
	}

}
