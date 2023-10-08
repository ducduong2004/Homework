package Lab2;

public class DrawPyramid {
	public static void drawPyramid(int n) {
		drawPyramidHelper(n, 1);

	}

	public static void drawPyramidHelper(int n, int count){
		if(n == count)
			for (int k = 1; k <= 2 * count - 1; k++) {
				System.out.print("X");
			}
		else if(n > count) {
			for (int j = 1; j <= n - count; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * count - 1; k++) {
				System.out.print("X");
			}
			System.out.println();
			drawPyramidHelper(n, count+1);
			
		}
	
	}


	public static void main(String[] args) {
		drawPyramid(5);
	}

}
