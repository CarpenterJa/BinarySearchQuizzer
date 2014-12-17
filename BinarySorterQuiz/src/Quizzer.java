import java.util.*;
import java.util.Collections;

public class Quizzer {
	static int questionNumber = 0;
	static int correctAwnsers = 0;
	public static int Start() {
		System.out
				.println("Input any number of ints between 1 and 20 and when you are done filling the Array enter -1.");
		Scanner file = new Scanner(System.in);
		ArrayList bob = new ArrayList();
		int boby;

		do {
			boby = file.nextInt();
			if (boby < 21 && boby > 0) {
				bob.add(boby);
			} else if (boby == -1) {
				break;
			} else {
				System.out.println("That is not a valid number");
			}
		} while (true);

		Collections.sort(bob);

		System.out.println("Here is the new sorted numbers");

		for (Object i : bob) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
		int target = (int) (Math.random() * (bob.size()));
		int a = (int)bob.get(target);
		System.out.println("Your target is " + a);

		

		int left = 0;
		int right = (int) bob.size() - 1;

		while (left <= right) {
			questionNumber++;
			int middle = (left + right) / 2;
			System.out.println(questionNumber + ") What is the left index?");
			boby = file.nextInt();
			questionNumber++;
			if (boby == left) {
				correctAwnsers++;
				System.out.println("Correct!");
			} else {
				System.out.println("No it is at index " + left);
			}
			System.out.println(questionNumber + ") What is the right index?");
			boby = file.nextInt();
			questionNumber++;
			if (boby == right) {
				correctAwnsers++;
				System.out.println("Correct!");
			} else {
				System.out.println("No it is at index " + right);
			}
			System.out.println(questionNumber + ") What is the middle index?");
			boby = file.nextInt();
			questionNumber++;
			if (boby == middle) {
				correctAwnsers++;
				System.out.println("Correct!");
			} else {
				System.out.println("No it is at index " + middle);
			}
			System.out.println(questionNumber + ") What number is at index "
					+ middle);
			boby = file.nextInt();
			if (boby == (int) bob.get(middle)) {
				correctAwnsers++;
				System.out.println("Correct!");
			}else{
				System.out.println("No the number is " + bob.get(middle));
			}
			if (a < (int) bob.get(middle)) {
				right = middle - 1;
			} else if (a > (int) bob.get(middle)) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;

	}
	public static void Results()
	{
		System.out.println("You got " + correctAwnsers + " out of " + questionNumber + " questions correct!" );
		System.out.println("That is a " + ((double)correctAwnsers/(double)questionNumber)*100 + " percent!");
	}

}