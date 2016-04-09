package list;

import java.util.Vector;

public class VectorTut {
	private static Vector<String> vector = new Vector<String>();
	public static void addElement(String s){
		vector.add(s);
	}
	public static void insertElement(String s,int index){
		vector.add(index, s);
	}
	/** 
	 * Delete element with index .
	 * @param x
	 */
	public static void deleteIndexElement(int x){
		if ( x >=0 && x< vector.size())
			vector.remove(x);
		else System.out.println(" Error. ");
	}
	public static void deleteElement(String s){
		if (vector.indexOf(s) != -1 )
			vector.remove(s);
		else System.out.println(" Error. ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Add many elements ");
		for (int i = 1 ; i <= 10 ; i++ )
			addElement(Integer.toString(i));
		System.out.println(vector);
		
		System.out.println(" Insert an element ");
		insertElement("My vector", 7);
		System.out.println(vector);
		
		System.out.println(" Delete an element with index" );
		deleteIndexElement(3);
		System.out.println(vector);
		
		
		System.out.println(" Delete an element with value" );
		deleteElement("2");
		System.out.println(vector);
		
	}	

}
