package list;

import java.util.ArrayList;

public class ArrayListTut {
	private static ArrayList<String> arrayList = new ArrayList<String>();
	public static void addElement(String s){
		arrayList.add(s);
	}
	public static void insertElement(String s,int index){
		arrayList.add(index, s);
	}
	/** 
	 * Delete element with index .
	 * @param x
	 */
	public static void deleteIndexElement(int x){
		if ( x >=0 && x< arrayList.size())
			arrayList.remove(x);
		else System.out.println(" Error. ");
	}
	public static void deleteElement(String s){
		if (arrayList.indexOf(s) != -1 )
			arrayList.remove(s);
		else System.out.println(" Error. ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Add many elements ");
		for (int i = 1 ; i <= 10 ; i++ )
			addElement(Integer.toString(i));
		System.out.println(arrayList);
		
		
		System.out.println(" Insert an element ");
		insertElement("My array List", 7);
		System.out.println(arrayList);
		
		System.out.println(" Delete an element with index" );
		deleteIndexElement(30);
		System.out.println(arrayList);
		
		System.out.println(" Delete an element with value" );
		deleteElement("2");
		System.out.println(arrayList);
		ArrayList a = new ArrayList();
	}	
}
