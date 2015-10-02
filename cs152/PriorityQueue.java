package cs152;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue<T> {



	/**
	 * A class Item that contains an element and its priority.
	 * @author Anthony Groves
	 *
	 */
	public class Item implements Comparable{
		private T element;
		private int priority;

		/**
		 * A class Item that contains an element and its priority.
		 * @param element the element T that the user enters
		 * @param priority the element's priority
		 */
		public Item(T element, int priority){
			this.priority = priority;
			this.element = element;
		}

		private int getPriority() {
			return priority;
		}

		private void setPriority(int priority) {
			this.priority = priority;
		}

		private T getElement() {
			return element;
		}

		private void setElement(T Element) {
			this.element = element;
		}


		/**
		 * This is implemented so that Collections.sort(list) can sort the list of Items
		 * based upon each element's priority (from smallest priority to largest)
		 * 
		 * @return 1 if this item's priority is higher than other's priority,
		 * 			-1 if this item's priority is lower than other's priority
		 * 			0 if both priorities are equal
		 */
		@Override
		public int compareTo(Object other) {
			if(this.priority > ((Item)other).getPriority() )
				return 1;
			else if( this.priority < ((Item)other).getPriority() )
				return -1;
			else
				return 0;
		}
	}




	private ArrayList<Item> list;

	public PriorityQueue(){
		list = new ArrayList<Item>();
	}


	public void add(T element, int priority){
		list.add(new Item(element, priority));
	}
	
	public T get(int index){
		return list.get(index).getElement();
	}

	public void sort(){
		Collections.sort(list);
	}

	/**
	 * Sorts the list of T elements, removes the element with the highest priority, and returns this element
	 * @return the T element with the highest priority that was removed
	 */
	public T remove(){
		sort();
		T highestPriority = list.get(list.size()-1).getElement();

		list.remove(list.size()-1);
		return highestPriority;
	}





	public static void main(String[] args) {
		PriorityQueue<String> q = new PriorityQueue<String>();

		q.add("X", 10);
		q.add("Y", 1);
		q.add("Z", 3);
		q.add("Hello", 12);
		q.add("Goodbye", 1);
		

		for(int i = 0; i < 5; i++)
			System.out.println(q.remove());
	}


}
