import java.util.Random;

class Player {

	int getGuess() {

		Random rand = new Random();
		int randomNumber = rand.nextInt(11);
		return randomNumber;
	}
}
