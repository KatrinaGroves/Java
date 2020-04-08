import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

class InsertGenericVacationHere {

	public static void main(String[] args) {

		ArrayList bestVacations = new ArrayList();
		bestVacations.add("Japan");
		bestVacations.add("Canada");
		bestVacations.add("Europe");
		bestVacations.add("Italy");
		bestVacations.add("Germany");
		Iterator it = bestVacations.listIterator();
		while(it.hasNext()) {
			Object vacation = it.next();
			System.out.println(vacation);
		}
		
		System.out.println("\r");
		
		ArrayList<String> worstVacations = new ArrayList<String>();
		worstVacations.add("Mexico");
		worstVacations.add("Egypt");
		worstVacations.add("Australia");
		worstVacations.add("China");
		worstVacations.add("Ohio");
		for(String vacation : worstVacations) {
			System.out.println(vacation);
		}
	}
}
