package codility;

import java.util.Set;
import java.util.TreeSet;


public class BreakTheChainSolution {

	public static void main(String[] args) {

		int[] buf_0 = {1,5,2,6,7,11,12}; //9
		int[] buf_1 = {13, 10, 8, 1, 4, 11, 8}; //11
		int[] buf_2 = {13, 10, 8, 1, 6, 9, 8}; //10
		int[] buf0 = {5,2,4,6,3,7}; //5
		int[] buf1 = {7,2,4,6,3,5}; //5
		int[] buf2 = {1, 2, 3, 4, 5, 6, 7}; //6
		int[] buf3 = {8, 2, 3, 4, 5, 1, 7}; //3
		int[] buf4 = {100000000, 1000000001,1,2,3,4};  //4
		int[] buf5 = {999999999, 1000000000,1,2,3}; //1000000002
		int[] buf6 = {1,5,2,6,10,11,12}; //11		
		
		BreakTheChainSolution so = new BreakTheChainSolution();
		
		System.out.println(so.solution(buf_0));
		System.out.println(so.solution(buf_1));
		System.out.println(so.solution(buf_2));
		System.out.println(so.solution(buf0));
		System.out.println(so.solution(buf1));
		System.out.println(so.solution(buf2));
		System.out.println(so.solution(buf3));
		System.out.println(so.solution(buf4));
		System.out.println(so.solution(buf5));
		System.out.println(so.solution(buf6));
	}

    
    
    public int solution(int[] A) 
    {
    	int sum=0;
    	
    	if(A == null )
    	{
    		return sum;
    	}
    	int size = A.length;

    	if(size <5)
    	{
    		return sum;
    	}
    	
    	if(size == 5)
    	{
    		return A[1] + A[3];
    	}
    	
    	
    	int idx1 = 1;
        int idx2 = 2;
        int idx3 = 3;
        int idx4 = 4;
               
        for (int i=5; i < size-1; i++) 
        {
        	if( A[i] < A[idx1]) 
        	{ 
            	if(A[idx3] < A[idx4])
            	{
            		idx4=idx3;
            	}
            	if(A[idx2] < A[idx3])
            	{
            		idx3=idx2;
            	}
            	if(A[idx1] < A[idx2])
            	{
            		idx2=idx1; 
            	}
        		idx1=i;        		
        	}
            else if( A[i] < A[idx2]) 
            { 
            	if(A[idx3] < A[idx4])
            	{
            		idx4=idx3;
            	}
            	if(A[idx2] < A[idx3])
            	{
            		idx3=idx2;
            	}
            	idx2=i; 
            }
            else if( A[i] < A[idx3]) 
            { 
            	if(A[idx3] < A[idx4])
            	{
            		idx4=idx3;
            	}
            	idx3=i; 
            }
            else if( A[i] < A[idx4]) 
            { 
            	idx4=i; 
            }
        }
	     
        Set<Integer> sums = new TreeSet<Integer>();
        
       	if(Math.abs(idx1-idx2) > 1)
       	{
       		sums.add(A[idx1] + A[idx2]);
       	}
       	
       	if(Math.abs(idx1-idx3) > 1)
       	{
       		sums.add(A[idx1] + A[idx3]);
       	}
       	
       	if(Math.abs(idx1-idx4) > 1)
       	{
       		sums.add(A[idx1] + A[idx4]);
       	}
       	
       	if(Math.abs(idx2-idx3) > 1)
       	{
       		sums.add(A[idx2] + A[idx3]);
       	}
        
       	if(Math.abs(idx2-idx4) > 1)
       	{
       		sums.add(A[idx2] + A[idx4]);
       	}

       	if(Math.abs(idx3-idx4) > 1)
       	{
       		sums.add(A[idx3] + A[idx4]);
       	}

       	return sums.stream().findFirst().get().intValue();    
    }
}
