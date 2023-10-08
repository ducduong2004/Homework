package Lab2;

public class Task1_4 {
	public static void MoveTower(int diskNum, char source, char dest, char spare) {
		// if there was only 1 disk left then move it to the destination
		
		if(diskNum == 1) {
			System.out.println("Move " + diskNum + " from "+ source + " to " + dest );
			return;
		}

		// move the upper disk of it to the spare
		MoveTower(diskNum - 1 , source, spare, dest);
		
		// move the disk to the destination
		System.out.println("Move " + (diskNum) + " from "+ source + " to " + dest );
		
		// move the upper disk which are at the spare to the destination
		MoveTower(diskNum - 1, spare, dest, source);
	}
	
	public static void main(String[] args) {
//		small disk is 1 and bigger one will be 1+1 = 2, and the bigger will be 1+1+1 = 3
//		3 pole will be named a b c
		MoveTower(3, 'a', 'b', 'c');
	}
}	

