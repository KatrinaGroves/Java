import java.util.Comparator;
import java.util.List;

class Employee implements Comparable {

	private long empID;
	private String firstName;
	private String lastName;

	public Employee(long empID, String firstName, String lastName) {
		this.setEmpID(empID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public long getEmpID() {
		return empID;
	}

	public void setEmpID(long empIDIn) {
		empID = empIDIn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstNameIn) {
		firstName = firstNameIn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastNameIn) {
		lastName = lastNameIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + empID);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Employee other = (Employee) obj;
		if (empID == other.empID && lastName.equals(other.lastName)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Employee ID:" + empID + ", First Name:" + firstName + ", Last Name:" + lastName;
	}

	static List<Employee> employeeList(List<Employee> listOfEmployees) {
		listOfEmployees.sort(Comparator.comparing(Employee::getLastName));
		return listOfEmployees;
	}

	@Override
	public int compareTo(Object arg0In) {
		return 0;
	}

}
