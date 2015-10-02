package cs152;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DivingScoresDriver {
	private ArrayList<Double> scores;
	private double difficulty;
	
	public DivingScoresDriver(ArrayList<Double> scores, double difficulty){
		this.scores = scores;
		this.difficulty = difficulty;
	}
	
	
	public ArrayList<Double> getScores(){
		return scores;
	}
	
	public double getDifficulty(){
		return difficulty;
	}
	
	
	public double calculateScore(){
		trimScores();
		double sum = scoreSum();
		return calculateFinalScore(sum);
	}
	
	public void trimScores(){
		Collections.sort(scores);
		scores.remove(0);
		scores.remove(scores.size()-1);
		
	}
	
	
	public double calculateFinalScore(double scoreSum){
		return scoreSum * difficulty * 0.6;
	}
	
	
	public double scoreSum(){
		double score = 0;
		for(int i = 0; i < scores.size(); i++){
			score += scores.get(i);
		}
		
		return score;
	}
	

	public static void main(String[] args) {

		ArrayList<Double> scores = new ArrayList<Double>();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is the degree of difficulty of the dive?");
		double difficulty = keyboard.nextDouble();
		
		System.out.println("Please input the score of:");
		for(int i = 0; i < 7; i++){
			int place = i+1;
			System.out.print("Judge " + place + " : ");
			scores.add(keyboard.nextDouble());
			System.out.println();
		}
		
		DivingScoresDriver driver = new DivingScoresDriver(scores, difficulty);
		
		System.out.printf("The score of this dive is: %.3f", driver.calculateScore());
		
	}
}
