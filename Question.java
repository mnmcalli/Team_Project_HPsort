/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author jessicasmither
 */
public class Question {
    
    String text;        //question
    String[] answers;   //all answers
    int[] randOrder;
    
    public Question(String q, String gA, String rA, String hA, String sA){
        
        text = q;
        answers = new String[4];
        answers[0] = gA;
        answers[1] = rA;
        answers[2] = hA;
        answers[3] = sA;
        //randOrder = new int[4];
    }
    public Question(){
        
    }
    
    // returns the answers in a random order
    public String[] randomizedAnswers(){
       String[] res = new String[answers.length]; 
       if(randOrder == null) {
            randOrder = Permutations.generateRandom(answers.length);
            for(int i = 0; i < randOrder.length; i++) {
                res[i] = answers[randOrder[i]]; 
            }
        }
       return res;
    }
    
    // Returns the corresponding house from the chosen answer
    public int getHouse(int choosenAnswer ) {
        return randOrder[choosenAnswer];
    }
}
