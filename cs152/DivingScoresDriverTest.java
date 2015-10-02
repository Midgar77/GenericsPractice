package cs152;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class DivingScoresDriverTest {

	@Test
	public void constructorWorksWithAppropirateArguments() {
		ArrayList<Double> list = new ArrayList<Double>();
		DivingScoresDriver driver = new DivingScoresDriver(list, 3.4);
		assert(driver != null);
		assertEquals(driver.getDifficulty(), 3.4, .01);
		assertEquals(driver.getScores(), list);
	}
	
	
	@Test
	public void trimScoresReturnsArrayListWithLowestAndHIghestScoresRemoved(){
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		list.add(3.0);
		list.add(8.5);
		list.add(2.4);
		list.add(4.5);
		list.add(2.4);
		list.add(4.5);
		
		DivingScoresDriver driver = new DivingScoresDriver(list, 3.4);
		Collections.sort(list);
		list.remove(0);
		list.remove(list.size()-1);
		
		assertEquals(driver.getScores(), list);
	}
	
	
	
	
	@Test
	public void scoreSumCorrectlySumsAllOfTheScores(){
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		list.add(3.0);
		list.add(8.5);
		list.add(2.4);
		list.add(4.5);
		list.add(2.4);
		list.add(4.5);
		DivingScoresDriver driver = new DivingScoresDriver(list, 3.4);
		
		
		assertEquals(driver.scoreSum(), 26.3, .01);
	}
	
	
	@Test
	public void calculateFinalScoreReturnsCorrectScore(){
		DivingScoresDriver driver = new DivingScoresDriver(null, 3.4);
		assertEquals(driver.calculateFinalScore(14), 28.56, .01);
	}
	
	
	@Test
	public void calculateScoreReturnsTheCorrectScore(){
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		list.add(3.0);
		list.add(8.5);
		list.add(2.4);
		list.add(4.5);
		list.add(2.4);
		list.add(4.5);
		DivingScoresDriver driver = new DivingScoresDriver(list, 3.4);
		
		assertEquals(driver.calculateScore(), 34.272, .01);
		
	}
	
	

}
