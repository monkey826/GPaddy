package map_hashset;
import java.util.Hashtable;
public class HashTableTut {
	private static Hashtable<Integer,String> hashTable = new Hashtable<Integer,String>();
	public static void changeValue( int key, String value){
		hashTable.replace(key, value);
//		hashTable.put(2, "432432");
	}
	public static void deleteElement(int index){
		hashTable.remove(index);
	}
	public static void addElement(int key, String value){
		hashTable.put(key, value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Map can't insert element in the middle because map manage many elements only with Key.");
		System.out.println(" And Key is just one.");
		System.out.println(" Add many elements ");
		for (int i = 1 ; i<= 5; i++ )
			addElement(i, " Hello World! ");
		System.out.println(hashTable);
		System.out.println(" Change a element ");
		changeValue( 2, " My name is Tien");
		System.out.println(hashTable);
		System.out.println(" Delete a element with value = ?");
		deleteElement(5);
		System.out.println(hashTable);
	}

}
