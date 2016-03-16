package codility;

public class MultiplyMoreThanSumSolution {

	public static void main(String[] args) {
		MultiplyMoreThanSumSolution solution = new MultiplyMoreThanSumSolution();
		long[] a = { 0, 1, 2, 2, 3, 5 };
		long[] b = { 500000, 500000, 0, 0, 0, 20000 };

		long[] a1 = { 1, 3 };
		long[] b1 = { 400000, 500000 };

		System.out.println(solution.solution(a, b));
		System.out.println(solution.solution(a1, b1));

	}


	public int solution(long[] A, long[] B) {

		if (A == null || B == null || A.length == 0 || B.length == 0
				|| A.length != B.length) {
			return 0;
		}

		long[] C = new long[A.length];

		for (int i = 0; i < A.length; i++) {
			C[i] = A[i] * 1000000 + B[i];
		}

		int pairCount = 0;
		int i = 0;
		int j = C.length - 1;

		while (i < j) {
			if (C[j] * C[i] >= (C[j] + C[i]) * 1000000) {
				pairCount+= j - i;
				j--;
				if (pairCount == 1000000000l) {
					return 1000000000;
				}
			} else {
				i++;
			}
		}

		return pairCount;
	}

}
