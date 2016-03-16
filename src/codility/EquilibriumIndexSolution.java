package codility;

public class EquilibriumIndexSolution {

	public static void main(String[] args) {

		int[]a ={ -1, 3,-4, 5, 1,-6,2,1};
		int[]a1 ={ 3, 2,3};
		
		EquilibriumIndexSolution s = new EquilibriumIndexSolution();
		System.out.println(s.solution(a1));
		System.out.println(s.solution(a));
	}

	public int solution(int[] A) {
	    
		if( A==null || A.length == 0 ) {
			return -1;
		}
		
		for( int i=0; i<A.length; i++)
		{
			if( sum(0,i-1, A) == sum(i+1, A.length-1, A )) {
				return i;
			}
		}
		return -1;
	}
	
	public long sum(int start, int finish, int[] a) {
		long sum=0;

		if(start == 0 && finish <0) {
			return 0;
		}
		
		if(finish == a.length-1 && start > a.length-1 ) {
			return 0;
		}
			
		for(int i=start; i<=finish; i++){
			sum+=a[i];
		}
		return sum;
	}
}
