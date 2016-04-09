package stackorqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTut {
	private static Queue<Integer> queue = new LinkedList<Integer>();
	public static void deleteElement(int index){
		
		if ( index < queue.size() && index > 0 )
			queue.remove(index);
		else 
			queue.poll();
//		On the other hand, we can use that method to delete element in head list	
//		queue.poll();
		
	}
	public static void addElement(int value){
		queue.add(value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Add many elements ");
		for (int i = 1 ; i <= 5 ; i++ )
			addElement(i);
		System.out.println(queue);
		System.out.println(" Insert a element. Queue cannot insert element in the middle.");
		System.out.println(" Delete a element ");
		deleteElement(6);
		System.out.println(queue);
	}


}
