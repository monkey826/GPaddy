package stackorqueue;

import java.util.Stack;

public class StackTut {
	private static Stack<Integer> stack = new Stack<Integer>();
	public static void insertElement(int index, int value){
		stack.insertElementAt(value, index);
	}
	public static void deleteElement(int index){
		if ( index == stack.size() - 1 )
			stack.pop();
		else {
			stack.removeElementAt(index);
		}
	}
	public static void addElement(int value){
		stack.push(value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" Add many elements ");
		for (int i = 1 ; i <= 5 ; i++ )
			addElement(i);
		System.out.println(stack);
		System.out.println(" Insert a element ");
		insertElement(2,44 );
		System.out.println(stack);
		System.out.println(" Delete a element ");
		deleteElement(3);
		System.out.println(stack);
	}

}
