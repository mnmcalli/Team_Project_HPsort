import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;

public class Quiz {
	Random rand = new Random();
	int [] score = new int[4]; //0 = G, 1 = R,  2 = H, 3 = S
	int numberOfQs = 9;
	String[][] questions = new String[numberOfQs][5];
	public Quiz() {
		
	}
	public void read(String fileName, int q) {
		File f = new File(fileName);
		try {
			Scanner scanner = new Scanner(f);
			for(int i = 0; i < questions.length; i++) {
				if(scanner.hasNextLine()) {
					questions[i][q] = scanner.nextLine();
					//System.out.println(questions[i][q]);		//used for debugging
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void display() {
		for(int i = 0; i < numberOfQs; i++) {
			System.out.println(questions[i][0]);
			for(int q = 1; q < 5; q++) {
				System.out.println((q) + ": " + questions[i][q]);
			}
			Scanner scan = new Scanner(System.in);
			int answer = scan.nextInt();
			//assumes perfect input because it might be buttons, so no try/catch
			score[(answer - 1)]++;
		}
	}
	private boolean confirmTwoWay() {
		boolean confirm = false;
		if(score[0] == 4) {
			if(score[1] == 4) {
				System.out.println("Congratulations! You're a mix between a Gryffindor and a Ravenclaw!");
				confirm = true;
			}
			else if(score[2] == 4) {
				System.out.println("Congratulations! You're a mix between a Gryffindor and a Hufflepuff!");
				confirm = true;
			}
			else if(score[3] == 4) {
				System.out.println("Congratulations! You're a mix between a Gryffindor and a Slytherin!");
				confirm = false;
			}
		}
		if(score[1] == 4) {	//already checked for score[0] and score[1]
			if(score[2] == 4) {
				System.out.println("Congratulations! You're a mix between a Gryffindor and a Hufflepuff!");
				confirm = true;
			}
			else if(score[3] == 4) {
				System.out.println("Congratulations! You're a mix between a Gryffindor and a Slytherin!");
				confirm = false;
			}
		}
		
		if(score[2] == 4) {//already checked 2 & 1, 2 & 0
			if(score[3] == 4) {
				System.out.println("Congratulations! You're a mix between a Gryffindor and a Slytherin!");
				confirm = false;
			}
		}
		return confirm;
	}
	public void score() { //with 9 questions, there's a possibility for a two or three-way tie
		//There will never be a four way tie.
		//Possibilities: 2223, 3330, 4410
		//If it's a three-way tie, all three scores will be = 3 (one will be zero)
		//If it's a two-way tie, two scores will be 4, and one will be one, one will be zero
		int scoreG = score[0];
		int scoreR = score[1];
		int scoreH = score[2];
		int scoreS = score[3];
		boolean message = false;
		if(scoreG > scoreR && scoreG > scoreH && scoreG > scoreS) {
			System.out.println("Congratulations! You're a bonafide Gryffindor!");
			message = true;
		}
		if(scoreR > scoreG && scoreR > scoreH && scoreR > scoreS) {
			System.out.println("Congratulations! You're an intelligent Ravenclaw!");
			message = true;
		}
		if(scoreH > scoreG && scoreH > scoreR && scoreH > scoreS) {
			System.out.println("Congratulations! You're a hardworking Hufflepuff!");
			message = true;
		}
		if(scoreH > scoreG && scoreH > scoreR && scoreH > scoreS) {
			System.out.println("Congratulations! You're a resourceful Slytherin!");
			message = true;
		}
		if(message == false) {
			if(confirmTwoWay() == true)
				message = true;
			else {
				System.out.println("Sorry! Your answers were so diversified that we couldn't place you in a house!");
				message = true;
			}
		}
	}
}
