package lab5;

public class Task1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		for( int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = a[i][j] + b[i][j];
			}
		}
		return a;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		for( int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = a[i][j] - b[i][j];
			}
		}
		return a;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		if( a[0].length != b.length && b[0].length != a.length)
			return a;


		int[][] result = new int[a.length][b[0].length];
		for( int i = 0; i < result.length; i++ ) {
			int value = 0;
			for( int j = 0; j < result[i].length; j++ ) {
				for(int k = 0; k < b.length; k++) {
					value = value + a[i][k] * b[k][j];
				}
				result[i][j] = value;
				value = 0;

			}
		}
		return result;
	}
	
	
	
	
	
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] result = new int[a[0].length][a.length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				result[j][i] = a[i][j];
			}
		}
		return result;
	}

	
	


	public static void print(int[][] arr) {
		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		int[][] a = {{1,2,3},{3,2,1}};
		int[][] b = {{1,2,3},{3,2,1},{1,2,1}};

		int[][] arr = multiply(a, b);
		print(arr);
		print(transpose(a));
	}
}
