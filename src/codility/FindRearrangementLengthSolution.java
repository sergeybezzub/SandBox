package codility;

public class FindRearrangementLengthSolution {

	public FindRearrangementLengthSolution() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		int[] A = {1,2,5,6,5,8,9};
		
		FindRearrangementLengthSolution s = new FindRearrangementLengthSolution();
		System.out.println(s.solution(A));
	}
	
    public int solution(int[] A) {
    	int count=0;
    	int size = A.length;
    	   	
    	for(int i = 0; i< size; i++) {
    		if(i == size -1) {
    			break;
    		}
    		
    		if(A[i]>A[i+1]) {
    			int count1 = calculateRearrangementLength(A, A[i], i+1);
    			count1++;
    			
    			if(count == 0) {
    				count = count1;
    			} else if(count1 < count) {
    				count = count1;
    			}
    		}
    	}
    	return count;
    }
    
    public int calculateRearrangementLength(int[] A, int value, int start) {
    	int count=1;
    	for(int i = start; i < A.length; i++) {
    		if( start == A.length-1) {
    			break;
    		}
    		
    		if(A[i+1] < value) {
    			count++;
    		} else {
    			break;
    		}
    	}
    	
    	return count;
    }

}
