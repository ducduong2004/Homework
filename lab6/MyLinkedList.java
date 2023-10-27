package lab6;

public class MyLinkedList {
	public class Node<E> {// Generic
		private E data;
		private Node<E> next;
		public Node(E data) {
			this.data = data;
		}


		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

	}




	public class SinglyLinkedList<E> {
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size;


		public SinglyLinkedList() {
			super();
		}



		// Returns the number of elements in the list.
		public int size() {
			return size;
		}

		


		// Returns true if the list is empty, and false 
		// otherwise.
		public boolean isEmpty() {
			return (size == 0);
		}

		// Returns (but does not remove) the first element in 
		// the list.
		public E first() {
			return this.head.data;
		}

		// Returns (but does not remove) the last element in 
		// the list.
		public E last() {
			return this.tail.data;
		}


		// Adds a new element to the front of the list.
		public void addFirst(E e) {
			Node<E> amongus = new Node<E>(e);
			if(size == 0) {
				head = tail = amongus;
			}
			else {
				amongus.next = head;
				this.head = amongus;
			}
			size = size + 1;
		}

		// Adds a new element to the end of the list.
		public void addLast(E e) {
			Node<E> amongus = new Node<>(e);
			if(size == 0) {
				head = tail = amongus;
			}
			Node<E> x = head;
			while (x.next != null) {
                x = x.next;
			}
			x.next = amongus;
			tail = amongus;
			size = size + 1;
		}


		// Removes and returns the first element of the list.
		public E removeFirst() {
			head = head.next;
			size--;
			return head.data;
		}

		// Removes and returns the last element of the list.
		public E removeLast() {
			Node<E> temp = this.head;
			for(int i = 1; i < size - 1; i++) {
				temp = temp.next;
			}
			E removedElement = tail.data;
			temp.next = null;
			tail = temp;
			size--;
			return removedElement;
		}



		public void print() {
			Node<E> temp = head;
			for(int i = 0; i < size; i++) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}




		public static void main(String[] args) {
			SinglyLinkedList<Integer> myList = new MyLinkedList().new SinglyLinkedList<>();

			// Test case 1: Add elements to the front of the list
			myList.addFirst(3);
			myList.addFirst(2);
			myList.addFirst(1);
			System.out.print("List after adding elements to the front: ");
			myList.print(); // Expected output: 1 2 3

			// Test case 2: Add elements to the end of the list
			myList.addLast(4);
			myList.addLast(5);
			myList.addLast(6);
			System.out.print("\nList after adding elements to the end: ");
			myList.print(); // Expected output: 1 2 3 4 5 6

			// Test case 3: Remove the first element
			myList.removeFirst();
			System.out.print("\nList after removing the first element: ");
			myList.print(); // Expected output: 2 3 4 5 6

			// Test case 4: Remove the last element
			myList.removeLast();
			System.out.print("\nList after removing the last element: ");
			myList.print(); // Expected output: 2 3 4 5

			// Test case 5: Check the size of the list
			int listSize = myList.size();
			System.out.println("\nSize of the list: " + listSize); // Expected output: 4

			// Test case 6: Check if the list is empty
			boolean isEmpty = myList.isEmpty();
			System.out.println("Is the list empty? " + isEmpty); // Expected output: false

			// Test case 7: Get the first and last elements
			int firstElement = myList.first();
			int lastElement = myList.last();
			System.out.println("First element: " + firstElement); // Expected output: 2
			System.out.println("Last element: " + lastElement);   // Expected output: 5
		}
	}














}
