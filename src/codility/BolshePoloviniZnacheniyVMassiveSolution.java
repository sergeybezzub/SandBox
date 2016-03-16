package codility;

public class BolshePoloviniZnacheniyVMassiveSolution {

	public static void main(String[] args) {
		BolshePoloviniZnacheniyVMassiveSolution solution = new BolshePoloviniZnacheniyVMassiveSolution();
		int[] massiv = { 1, 2147483647, 2147483647 };
		System.out.println(solution.solution(massiv));

		int[] massiv1 = { 1 };
		System.out.println(solution.solution(massiv1));

		int[] massiv2 = { 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2 };
		System.out.println(solution.solution(massiv2));

		int[] massiv3 = { 1, 2 };
		System.out.println(solution.solution(massiv3));

	}

	int solution(int[] A) {
		int n = A != null ? A.length : 0;

		int count = 1;
		int pos = n / 2;
		int candidate = A[0];

		for (int i = 1; i < n; i++) {
			if (A[i] == candidate) {
				count++;
			} else {
				candidate = A[i];
				count = 1;
			}
		}

		if (count > pos) {
			return candidate;
		}

		return (-1);
	}

}
