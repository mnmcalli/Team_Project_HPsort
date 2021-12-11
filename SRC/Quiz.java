//Team 4
// Author Mikki McAllister

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package HarryPotter;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author jessicasmither
 */
public class Quiz {
    Random rand;
    int [] score;           // 0 = G, 1 = R, 2 = H, 3 = S
    String scoreResult;
    int numberOfQs;
    Question[] questions;
     
	public Quiz(int nbOfQ) {
            rand = new Random();
            score = new int[4]; 
            numberOfQs = nbOfQ;
            questions = new Question[numberOfQs];
            scoreResult = "";
	}
        
	public void readQuestion(String questionFile, String gAnswerFile, String hAnswerFile, String rAnswerFile, String sAnswerFile) {
	

            File f = new File(questionFile);
            File g = new File(gAnswerFile);
            File h = new File(hAnswerFile);
            File r = new File(rAnswerFile);
            File s = new File(sAnswerFile);
            try {
                Question placeholder = new Question();
		Scanner scanner = new Scanner(f);
                Scanner gAns = new Scanner(g);
                Scanner hAns = new Scanner(h);
                Scanner rAns = new Scanner(r);
                Scanner sAns = new Scanner(s);
		for(int i = 0; i < numberOfQs; i++) {
                    if(scanner.hasNextLine() && gAns.hasNextLine() && hAns.hasNextLine() && rAns.hasNextLine() && sAns.hasNextLine()) {
                    //questions[i][q] = scanner.nextLine();
                    placeholder = new Question(scanner.nextLine(), gAns.nextLine(), rAns.nextLine(), hAns.nextLine(), sAns.nextLine());  //g, r, h, s
                    placeholder.randomizedAnswers();
                }
                questions[i] = placeholder;
		}
            } catch (FileNotFoundException e) {
		e.printStackTrace();
            }
	}
        
	public void updateScore(int answer, int qIdx) {
            //assumes perfect input because it might be buttons, so no try/catch
            score[questions[qIdx].getHouse(answer - 1)]++;
        }
        
	private boolean confirmTwoWay() {
		boolean confirm = false;
		if(score[0] == 4) {
			if(score[1] == 4) {
				scoreResult = "Congratulations! You're a mix between a Gryffindor and a Ravenclaw!";
				confirm = true;
			}
			else if(score[2] == 4) {
				scoreResult = "Congratulations! You're a mix between a Gryffindor and a Hufflepuff!";
				confirm = true;
			}
			else if(score[3] == 4) {
				scoreResult = "Congratulations! You're a mix between a Gryffindor and a Slytherin!";
				confirm = false;
			}
		}
		if(score[1] == 4) {	//already checked for score[0] and score[1]
			if(score[2] == 4) {
				scoreResult = "Congratulations! You're a mix between a Gryffindor and a Hufflepuff!";
				confirm = true;
			}
			else if(score[3] == 4) {
				scoreResult = "Congratulations! You're a mix between a Gryffindor and a Slytherin!";
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
	public void getScoreResult() { //with 9 questions, there's a possibility for a two or three-way tie
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
			scoreResult = "Congratulations! You're a bonafide Gryffindor!";
			message = true;
		}
		if(scoreR > scoreG && scoreR > scoreH && scoreR > scoreS) {
			scoreResult = "Congratulations! You're an intelligent Ravenclaw!";
			message = true;
		}
		if(scoreH > scoreG && scoreH > scoreR && scoreH > scoreS) {
			scoreResult = "Congratulations! You're a hardworking Hufflepuff!";
			message = true;
		}
		if(scoreS > scoreG && scoreS > scoreR && scoreS > scoreH) {
			scoreResult = "Congratulations! You're a resourceful Slytherin!";
			message = true;
		}
		if(message == false) {
			if(confirmTwoWay() == true)
				message = true;
			else {
				scoreResult = "Sorry! Your answers were so diversified that we couldn't place you in a house!";
				message = true;
                    }
            }
    }
}
