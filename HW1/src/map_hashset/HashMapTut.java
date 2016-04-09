package map_hashset;

import java.util.HashMap;

public class HashMapTut {
	private static HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
	public static void changeValue( int key, String value){
		hashMap.put(key,value);
	}
	public static void deleteElement(int index){
		hashMap.remove(index);
	}
	public static void addElement(int key, String value){
		hashMap.put(key, value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Map can't insert element in the middle because map manage many elements only with Key.");
		System.out.println(" And Key is just one.");
		System.out.println(" Add many elements ");
		for (int i = 1 ; i<= 5; i++ )
			addElement(i, " Hello World! ");
		System.out.println(hashMap);
		System.out.println(" Change a element ");
		changeValue( 2, "My name is Tien");
		System.out.println(hashMap);
		System.out.println(" Delete a element with value = ?");
		deleteElement(5);
		System.out.println(hashMap);
	}

}
