package list;

import java.util.LinkedList;

public class LinkedListTut {
	private static LinkedList<String> linkedList = new LinkedList<String>();
	public static void addFirstElement(String s){

		linkedList.addFirst(s);
	
	}
	public static void addElement(String s){
		int c = 0;
		if ( c == 0 ){
			linkedList.add(s);
			c = 1 - c;
		}
		else if ( c == 1 ){
			linkedList.push(s);
			c = 1 - c;
		}
	}
	public static void insertElement(String s,int index){
		linkedList.add(index, s);
	}
	/** 
	 * Delete element with index .
	 * @param x
	 */
	public static void deleteIndexElement(int x){
		if ( x >=0 && x < linkedList.size())
			linkedList.remove(x);
		else System.out.println(" Error. ");
	}
	public static void deleteElement(String s){
		if (linkedList.indexOf(s) != -1 )
			linkedList.remove(s);
		else System.out.println(" Error. ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Add many elements ");
		for (int i = 1 ; i <= 10 ; i++ )
			addElement(Integer.toString(i));
		System.out.println(linkedList);
		
		System.out.println(" Add an element in first index ");
		addFirstElement("Hello");
		System.out.println(linkedList);
		
		System.out.println(" Insert an element ");
		insertElement("My Array List", 7);
		System.out.println(linkedList);
		
		System.out.println(" Delete an element with index" );
		deleteIndexElement(30);
		System.out.println(linkedList);
			
		System.out.println(" Delete an element with value" );
		deleteElement("2");
		System.out.println(linkedList);
			
	}	
}

