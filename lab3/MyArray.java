package lab3;

public class MyArray {
	private int[] array;
	public MyArray(int[] array) {
		this.array = array;
	}


	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		int[] arr = this.array;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == target)
				return i + 1;
		}
		return -1;

	}
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		int count = 0;
		int result = this.recursiveLinearSearchHelper(target, count);
		return result;
	}

	public int recursiveLinearSearchHelper(int target, int currentIndex) {
		int[] arr = this.array;
		if(currentIndex > arr.length-1)
			return -1;
		if(arr[currentIndex] == target)
			return currentIndex+1;
		return recursiveLinearSearchHelper(target, currentIndex+1);
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {

		int[] arr = this.array;
		int i =  arr.length/2;
		int left = 0;
		int right = arr.length - 1;
		while(left <= right ) {
			i = ( right + left ) / 2;
			if (arr[i] == target) {
				return i+1; // Target found, return the index.
			}
			if(arr[i] < target) {

				left = i+1;
			} else {

				right = i-1;

			}

		}
		return -1;
	}

	// To find the index of the target in the sorted array. If the
	// target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		// TODO
		int[] arr = this.array;
		return recursiveBinarySearchHelper(target, 0, arr.length - 1, arr);

	}

	public int recursiveBinarySearchHelper(int target, int left, int right, int[] arr) {
		if (left <= right) {
			int currentIndex = left + (right - left) / 2; // Calculate the midpoint correctly.

			if (arr[currentIndex] == target) {
				return currentIndex+1; // Target found, return the index.
			} else if (arr[currentIndex] < target) {
				return recursiveBinarySearchHelper(target, currentIndex + 1, right, arr);
			} else {
				return recursiveBinarySearchHelper(target, left, currentIndex - 1, arr);
			}
		}

		return -1; // Target not found.
	}

	public boolean isSorted() {
		int[] arr = this.array;
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			if(arr[i] > arr[i+1])
				return false;
		}
		return true;
	}


	public int searchTarget(int target) {
		if(isSorted()) {
			System.out.println("sorted");
			return iterativeBinarySearch(target);
		}

		return iterativeLinearSearch(target);
	}



	


	public static void main(String[] args) {
		MyArray arr = new MyArray(new int[] {1,2,3,4,6,9,10,15});
		System.out.println(arr.iterativeLinearSearch(1));
		System.out.println(arr.recursiveLinearSearch(4));
		System.out.println(arr.iterativeBinarySearch(10));
		System.out.println(arr.recursiveBinarySearch(2));
		System.out.println(arr.searchTarget(5));
	}
}
