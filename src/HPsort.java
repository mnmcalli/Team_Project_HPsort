
public class HPsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz HPquiz = new Quiz();
		HPquiz.read("questions.txt", 0);
		HPquiz.read("Ganswers.txt", 1);
		HPquiz.read("Ranswers.txt", 2);
		HPquiz.read("Hanswers.txt", 3);
		HPquiz.read("Sanswers.txt", 4);
		HPquiz.display();
		HPquiz.score();
	}
	

}
