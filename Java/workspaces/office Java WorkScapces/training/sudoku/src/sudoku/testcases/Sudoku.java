package sudoku.testcases;

public class Sudoku {
	static int Matrix[]=new int[4]; 

	public static void main(String[] args) {
		
	}
	public boolean isSafeToPalce(int r) {
		boolean safe = true;
		for (int c = 0; c < r; c++) {
			if (Matrix[c] == Matrix[r] || ((Math.abs(Matrix[c] - Matrix[r])) == (Math.abs(c - r)))) {
				safe = false;
				return safe;
			}
		}
		return safe;
	}
	
}
