package codility;

public class FixCodeSolution {

	// We should fix code that implements binary search algorithm
	// code should return index if element has found and return -1 if element has not found in array
	public static void main(String[] arg) {
		FixCodeSolution s = new FixCodeSolution();

		int[] A = { 1, 2, 5, 9, 19, 20 };
		System.out.println(s.solution(A, 20));
	}

	public int solution(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == X) {
				return m;
			}
			if (A[m] < X) {
				l = m + 1;
			}
			if (A[m] > X) {
				r = m - 1;
			}
		}
		return -1;
	}
}
