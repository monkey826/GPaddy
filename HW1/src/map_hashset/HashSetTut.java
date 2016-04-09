package map_hashset;

import java.util.HashSet;

public class HashSetTut {
	private static HashSet<Integer> hashSet = new HashSet<Integer>();
	public static void deleteElement(int value){
		hashSet.remove(value);
	}
	public static void addElement(int value){
		hashSet.add(value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Set can't insert element in the middle because Set manage many elements only with Key.");
		System.out.println(" And Key is just one.");
		System.out.println(" Add many elements ");
		for (int i = 1 ; i<= 5; i++ )
			addElement(i);
		addElement(-1);
		System.out.println(hashSet);
		System.out.println(" Delete a element with value = ?");
		deleteElement(5);
		System.out.println(hashSet);
	}

}
