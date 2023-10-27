package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of
	// elements is full
	public void growSize() {
		this.size = size*2;
		elements = Arrays.copyOf(elements, this.size);
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException 
	{
		if(i<0 || i >= size)
			throw new IndexOutOfBoundsException();
		else
			return elements[i];
	}


	// Replaces the element at index i with e, and 
	// returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i<0 || i >= size)
			throw new IndexOutOfBoundsException();
		else
			elements[i] = e;
		return e;
	}


	// It is used to append the specified element at the 
	// end of a list.
	public boolean add(E e) {
		elements = Arrays.copyOf(elements, size+1);
		elements[size] = e;
		size = size+1;
		return true;
	}

	// Inserts element e to be at index i, shifting all 
	// subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if(i<0 || i >= size)
			throw new IndexOutOfBoundsException();
		else
			elements = Arrays.copyOf(elements, size+1);
		for(int index = size; index > i; index--) {
			elements[index] = elements[index-1];
		}
		size = size + 1;
		elements[i] = e;

	}


	// Removes and returns the element at index i, 
	// shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i<0 || i >= size)
			throw new IndexOutOfBoundsException();
		else {
			E removedElement = elements[i];
			for(int index = i; index < size - 1 ; index++) {
				elements[index] = elements[index+1];
			}
		
		elements = Arrays.copyOf(elements, size-1);
		size = size - 1;
		return removedElement;
		}
	}

	// It is used to clear all elements in the list.
	public void clear() {
		elements = Arrays.copyOf(elements, 0);
		size = 0;

	}




	// It is used to return the index in this list of the 
	// last occurrence of the specified element, or -1 if the 
	// list does not contain this element.
	public int lastIndexOf(Object o) {
		int index = -1;
		for(int i = 0; i < size; i++) 
			if(elements[i].equals(o))
				index = i;
		return index;
	}

	// It is used to return an array containing all of the 
	// elements in this list in the correct order
	public E[] toArray() {
		E[] array = this.elements; // Create an array of the same type as elements
		for (int i = 0; i < size(); i++) {
			array[i] = this.get(i); // Copy elements from the list to the array
		}
		return array;
	}




	
	
	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> cloneArrayList = this;
		return cloneArrayList;
	}
	
	// It returns true if the list contains the specified 
	// element
	public boolean contains(E o) {
		for(E e : elements)
			if(e.equals(o))
				return true;
		return false;
	}

	// It is used to remove the first occurrence of the 
	// specified element.
	public boolean remove(E e) {
		for(int i = 0; i < size; i++)
			if(elements[i].equals(e)) {
				this.remove(i);
				return true;
			}
				
		return false;
	}
	
	
	
	

	// It is used to sort the elements of the list on the 
	// basis of specified comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements,0,size-1,c);
	}
	
	
	
	
	
	
	
	
	



	public void print() {
		for(E e : elements)
			System.out.print(e + " ");
		System.out.println();
	}

	public static void main(String[] args) {
	    MyArrayList<Integer> myList = new MyArrayList<>();

	    // Test adding elements
	    myList.add(5);
	    myList.add(10);
	    myList.add(15);
	    myList.add(20);

	    // Test printing the list
	    myList.print(); // Expected output: 5 10 15 20

	    // Test getting elements
	    int element = myList.get(2); // Get element at index 11 (10)
	    System.out.println("Element at index 2: " + element); // Expected output: 10

	    // Test setting an element
	    myList.set(1, 12); // Set element at index 1 to 12
	    myList.print(); // Expected output: 5 12 15 20

	    // Test adding an element at a specific index
	    myList.add(1, 8); // Insert 8 at index 1
	    myList.print(); // Expected output: 5 8 12 15 20

	    // Test removing an element at a specific index
	    int removedElement = myList.remove(3); // Remove element at index 3 (15)
	    myList.print(); // Expected output: 5 8 12 20
	    System.out.println("Removed element: " + removedElement); // Expected output: 15

	    // Test clearing the list
	    myList.clear();
	    myList.print(); // Expected output: (empty)

	    // Test checking if the list is empty
	    boolean isEmpty = myList.isEmpty();
	    System.out.println("Is the list empty? " + isEmpty); // Expected output: true

	    // Test sorting the list in ascending order
	    myList.add(5);
	    myList.add(1);
	    myList.add(4);
	    myList.add(2);
	    myList.sort(Comparator.naturalOrder());
	    myList.print(); // Expected output: 1 2 4 5

	    // Test checking if the list contains a specific element
	    boolean contains = myList.contains(4);
	    System.out.println("Does the list contain 4? " + contains); // Expected output: true

	    // Test finding the last index of a specific element
	    int lastIndex = myList.lastIndexOf(4);
	    System.out.println("Last index of 4: " + lastIndex); // Expected output: 2

	    // Test converting the list to an array
	    Object[] array = myList.toArray();
	    System.out.println("Array: " + Arrays.toString(array)); // Expected output: [1, 2, 4, 5]
	}


}