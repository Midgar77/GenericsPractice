package cs152;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cs152.PriorityQueue.Item;

public class PriorityQueueTest {

	@Test
	public void testPriorityQueueCOnstructorWorks() {
		PriorityQueue<String> q = new PriorityQueue<String>();
		assert(q == new PriorityQueue<String>());
		
	}
	
	
	@Test
	public void testPriorityQueueProperlyAddsElement(){
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("Anthony", 7);
		q.add("Annie", 10);
		
		assertEquals(q.get(0), "Anthony");
		assertEquals(q.get(1), "Annie");
	}
	
	
	
	@Test
	public void sortProperlySortsElements(){
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("Anthony", 7);
		q.add("Annie", 10);
		q.add("X", 5);
		
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("X");
		stringList.add("Anthony");
		stringList.add("Annie");
		
		q.sort();
		
		assertEquals(q.get(0), stringList.get(0));
		assertEquals(q.get(1), stringList.get(1));
		assertEquals(q.get(2), stringList.get(2));
	}

	
	@Test
	public void testIfRemoveCorrectlyRemovesAndReturnsHighestPriority(){
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("Anthony", 7);
		q.add("Annie", 10);
		q.add("X", 5);
		q.add("Y", 3);
		q.add("Z", 20);
		
		assertEquals(q.remove(), "Z");
		assertEquals(q.remove(), "Annie");
		assertEquals(q.remove(), "Anthony");
		assertEquals(q.remove(), "X");
		
		//At this point, everything should be removed from the list but the String "Y"
		assertEquals(q.get(0), "Y");
		assertEquals(q.remove(), "Y");
		
		
	}
	
}
