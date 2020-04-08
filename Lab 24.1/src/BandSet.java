import java.util.HashSet;
import java.util.Set;

class BandSet {

	public static void main(String[] args) {

		Set<String> bandList = new HashSet<>();
		bandList.add("Letlive");
		bandList.add("Lemon Demon");
		bandList.add("He Is We");
		bandList.add("Lemon Demon");
		for (String band : bandList) {
			System.out.println(band);
		}
		bandList.remove("Letlive");
		boolean b = bandList.add("Letlive");
		System.out.println(b);
	}
}