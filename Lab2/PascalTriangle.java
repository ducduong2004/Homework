package Lab2;

public class PascalTriangle {

	
	
	// This method is used to display a Pascal triangle based 
	// on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		print(getPascalTriangle(row));
	}

	
	
	// get the nth row. 
	//For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if(n == 1)
			return new int[] {1};
		
		return generateNextRow(getPascalTriangle(n-1));
	}

	
	
	// generate the next row based on the previous row
	//Ex. prevRow = {1} ==> nextRow = {1, 1}
	//Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] row = new int[prevRow.length+1];
		row[0] = 1;
		row[prevRow.length] = 1;
		
		for(int i = 1; i < prevRow.length; i++) {
			row[i] = prevRow[i] + prevRow[i-1];
		}
		return row;
	}
	
	
	
	public static void print(int[] n) {
		for( int i : n)
			System.out.print(i + " ");
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = getPascalTriangle(5);
		print(arr);
		System.out.println();
		printPascalTriangle(5);
		
	}

}
