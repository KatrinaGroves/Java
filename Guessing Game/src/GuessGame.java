import java.util.Random;

class GuessGame {

	void startGame() throws InterruptedException {

		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();

		Random rand = new Random();
		int randomGuess = rand.nextInt(11);
		System.out.println("I'm thinking of a number between 1 and 10");
		Thread.sleep(2000);

		int guess1 = player1.getGuess();
		System.out.println("Player 1 guessed " + guess1);
		int guess2 = player2.getGuess();
		System.out.println("Player 2 guessed " + guess2);
		int guess3 = player3.getGuess();
		System.out.println("Player 3 guessed " + guess3);
		Thread.sleep(1000);

		boolean p1IsRight = false;
		boolean p2IsRight = false;
		boolean p3IsRight = false;

		if (randomGuess == guess1) {
			p1IsRight = true;
			System.out.println("Player 1 is correct");
		}
		if (randomGuess == guess2) {
			p2IsRight = true;
			System.out.println("Player 2 is correct");
		}
		if (randomGuess == guess3) {
			p3IsRight = true;
			System.out.println("Player 3 is correct");
		}
		if (p1IsRight != true && p2IsRight != true && p3IsRight != true) {
			System.out.println("Try again");
		}
		System.out.println("The number you needed to guess was " + randomGuess);

	}
}
