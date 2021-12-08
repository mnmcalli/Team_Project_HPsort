/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

public class HPsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz HPquiz = new Quiz();       //Question(String q, String gA, String rA, String hA, String sA)
		HPquiz.readQuestion("questions.txt", "gAnswers.txt", "hAnswers.txt", "rAnswers.txt", "sAnswers.txt");
		HPquiz.display();
		HPquiz.score();
	}
	

}
