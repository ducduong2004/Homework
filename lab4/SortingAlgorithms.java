package lab4;

import java.util.Random;

public class SortingAlgorithms {
	// sort by descending order
	public static void selectionSort(int[] array) {
		int max;
		int index;
		for(int i = 0 ; i < array.length - 1 ; i++) {
			max = array[i];
			index = i;
			for(int j = i + 1 ; j < array.length ; j++) {
				if(max < array[j]) {
					max = array[j];
					index = j;
				}
			}
			swap(array, index, i);
		}


		return;
	}

	//-------------------------------------------------------------------

	// recursion Selection Sort
	public static void recursionSelectionSort(int[] arr) {
		recursionSelectionSortHelper(arr, 0);
	}


	// recursion Selection Sort Helper
	public static void recursionSelectionSortHelper(int[] arr, int count) {
		if(count == arr.length) {
			return;
		}
		int i = findMaxIndex(arr, count, count, arr[count]);
		swap(arr, i, count);
		recursionSelectionSortHelper(arr, ++count);
	}

	// this method find the index of the biggest value in the array
	public static int findMaxIndex(int[] arr, int index, int count, int max) {
		if(count == arr.length)
			return index;
		if(arr[count] > max ) {
			max = arr[count];
			index = count;
		}
		return findMaxIndex(arr, index, ++count, max);
	}


	//---------------------------------------------------------



	// sort by descending order
	public static void bubbleSort(int[] array) {
		for(int i = 0 ; i < array.length; i++) {
			for(int j = 0 ; j < array.length - 1 - i; j++) {
				if(array[j] > array[j+1]) {
					swap(array, j, j+1);
				}
			}
		}
	}



	//--------------------------------------------------------

	public static void recursionBubbleSort(int[] array) {
		recursionBubbleSortHelper(array, 0);
	}

	public static void recursionBubbleSortHelper(int[] arr, int count ) {
		if(count == arr.length)
			return;
		int end = arr.length - 1 - count;
		bubbleComparator(arr, 0, end);
		recursionBubbleSortHelper(arr, ++count);
	} 

	public static void bubbleComparator(int[] arr, int count, int end) {
		if(count == end)
			return;
		if(arr[count] > arr[count+1])
			swap(arr, count, count+1);
		bubbleComparator(arr, ++count, end);
	}



	//---------------------------------------------------------

	// sort by descending order
	public static void insertionSort(int[] array) {
		for(int i = 1 ; i < array.length; i++) {
			for(int j = i; j > 0 ; j--) {
				if(array[j] < array[j-1])
					swap(array, j, j-1);
			}

		}
	}



	public static void recursionInsertionSort(int[] array) {
		recursionInsertionSortHelper(array, 1);
	}

	public static void recursionInsertionSortHelper(int[] arr, int count) {
		if(count == arr.length)
			return;
		insertionHelper(arr, count);
		recursionInsertionSortHelper(arr, ++count);
	}

	public static void insertionHelper(int[] arr, int reverseCount) {
		if(reverseCount == 0) {
			return;
		}

		if(arr[reverseCount] < arr[reverseCount-1]) 
			swap(arr, reverseCount, reverseCount-1);
		insertionHelper(arr, --reverseCount);
	}


	// ---------------------------------------------------------

	public static void mergeSort(int[] array) {
		if(array.length <= 1)
			return;

		int mid = array.length / 2;

		int[] left = new int[mid];
		int[] right = new int[array.length-mid];



		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];
		}

		
		mergeSort(left);
		mergeSort(right);
		Merge(left, right, array);


	}

	public static void Merge(int[] left, int[] right, int[] array) {
		int nL = left.length;
		int nR = right.length;
		int l = 0, r = 0, i = 0;

		while( l < nL && r < nR ) {
			if(left[l] < right[r])
				array[i++] =  left[l++];
			else
				array[i++] = right[r++];
		}
		while(l < nL)
			array[i++] = left[l++];
		while(r < nR)
			array[i++] = right[r++];

	}


	//--------------------------------------------------------
	
	public static void quickSort(int[] array) {
	    quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
	    if (low < high) {
	        // Choose a pivot element using one of the strategies
	        int pivot = getPivot_MedianOfThree(array, low, high);
	        
	        // Partition the array and get the pivot's final position
	        int pivotIndex = partition(array, low, high, pivot);
	        
	        // Recursively sort the subarrays
	        quickSort(array, low, pivotIndex - 1);
	        quickSort(array, pivotIndex + 1, high);
	    }
	}

	private static int partition(int[] array, int low, int high, int pivot) {
	    int pivotValue = array[pivot];
	    swap(array, pivot, high);
	    int i = low;
	    
	    for (int j = low; j < high; j++) {
	        if (array[j] < pivotValue) {
	            swap(array, i, j);
	            i++;
	        }
	    }
	    
	    swap(array, i, high);
	    return i;
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
	    // Choose the middle element as the pivot (median of three)
	    int middle = (low + high) / 2;
	    if (array[low] > array[middle]) {
	        swap(array, low, middle);
	    }
	    if (array[low] > array[high]) {
	        swap(array, low, high);
	    }
	    if (array[middle] > array[high]) {
	        swap(array, middle, high);
	    }
	    return middle;
	}

	private static int getPivot_First(int[] array) {
	    return 0; // Choose the first element as the pivot
	}

	private static int getPivot_Last(int[] array, int low, int high) {
	    return high; // Choose the last element as the pivot
	}

	private static int getPivot_Random(int[] array, int low, int high) {
	    Random rand = new Random();
	    return rand.nextInt(high - low + 1) + low; // Choose a random element as the pivot
	}
	
	
	
	
	
	
	
	
	
	
	

	//--------------------------------------------------------

	public static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public static void print(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void shuffleArray(int[] array) {
		Random random = new Random();

		for (int i = array.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			swap(array, i, j);
		}
	}


	public static void main(String[] args) {
		int[] arr = {12,11,5,3,6,22};
		System.out.println("The original array: ");
		print(arr);

		System.out.println("Test selection sort:");
		selectionSort(arr);
		print(arr);

		System.out.println("---------------------------------------");

		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test recursive selection sort:");
		recursionSelectionSort(arr);
		print(arr);

		System.out.println("---------------------------------------");


		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test bubble sort:");
		bubbleSort(arr);
		print(arr);

		System.out.println("---------------------------------------");


		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test recursive bubble sort:");
		recursionBubbleSort(arr);
		print(arr);

		System.out.println("---------------------------------------");


		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test insertion sort:");
		insertionSort(arr);
		print(arr);

		System.out.println("---------------------------------------");


		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test recursive selection sort:");
		recursionInsertionSort(arr);
		print(arr);

		System.out.println("---------------------------------------");


		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test merge sort:");
		mergeSort(arr);
		print(arr);
	

		System.out.println("---------------------------------------");


		System.out.println("Shuffle the array!");
		shuffleArray(arr);
		print(arr);
		System.out.println("Test quick sort:");
		quickSort(arr);
		print(arr);
	}
}
