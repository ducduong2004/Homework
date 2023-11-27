package lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<E>();
		for(E e : array ) {
			stack.push(e);
		}
		int i = 0;
		while(!stack.isEmpty()) {
			array[i] = stack.pop();
			i++;
		}


	}

	// This method checks the correctness of the 
	// given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> 
	// false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = input.toCharArray();

		//if(input.isEmpty()) return true;


		for(char c : arr) {
			switch (c) {
			case '{':{
				stack.push('}');
				break;
			}
			case '[':{
				stack.push(']');
				break;
			}
			case '(':{
				stack.push(')');
				break;
			}
			default:
				// điều kiện theo đúng thứ tự vì nếu không thì input = "()" "[]" "{}" sẽ sai
				// vì stack.pop trước thì stack sẽ empty => điều kiện luôn đúng
				if( stack.isEmpty() || c != stack.pop()  ) return false;
			}
		}

		return stack.isEmpty();
	}
	
	

	// method stutter that accepts a queue of integers as 
	// a parameter and replaces
	// every element of the queue with two copies of that 
	// element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back

	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		while(size > 0) {
			E temp = input.poll();
			input.add(temp);
			input.add(temp);
			size--;
		}
	}
	// Method mirror that accepts a queue of strings as a 
	// parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();
		
		int size = input.size();
		
		while (size > 0) {
			E e = input.poll();
			input.add(e);
			stack.add(e);
			size--;
	    }
		
		while(!stack.isEmpty()) {
			input.add(stack.pop());
		}
	    
	}


	public static void main(String[] args) {
		Integer[] array1 = {1, 2, 3, 4, 5};
		System.out.println("Original Array: " + Arrays.toString(array1));
		MyLIFO_App.reserve(array1);
		System.out.println("Reversed Array: " + Arrays.toString(array1));

		String[] array2 = {"apple", "banana", "orange", "grape"};
		System.out.println("Original Array: " + Arrays.toString(array2));
		MyLIFO_App.reserve(array2);
		System.out.println("Reversed Array: " + Arrays.toString(array2));
		
		String input1 = "()()()";
		System.out.println("Is input1 correct? " + MyLIFO_App.isCorrect(input1));

		String input2 = "({[]})";
		System.out.println("Is input2 correct? " + MyLIFO_App.isCorrect(input2));

		String input3 = "{[}]";
		System.out.println("Is input3 correct? " + MyLIFO_App.isCorrect(input3));

		
		Queue<Integer> queue1 = new LinkedList<>(Arrays.asList(1, 2, 3));
		System.out.println("Original Queue: " + queue1);
		MyLIFO_App.stutter(queue1);
		System.out.println("Stuttered Queue: " + queue1);

		Queue<String> queue2 = new LinkedList<>(Arrays.asList("a", "b", "c"));
		System.out.println("Original Queue: " + queue2);
		MyLIFO_App.stutter(queue2);
		System.out.println("Stuttered Queue: " + queue2);

		Queue<String> queue3 = new LinkedList<>(Arrays.asList("a", "b", "c"));
		System.out.println("Original Queue: " + queue3);
		MyLIFO_App.mirror(queue3);
		System.out.println("Mirrored Queue: " + queue3);

		Queue<Character> queue4 = new LinkedList<>(Arrays.asList('x', 'y', 'z'));
		System.out.println("Original Queue: " + queue4);
		MyLIFO_App.mirror(queue4);
		System.out.println("Mirrored Queue: " + queue4);

		

	}


}
