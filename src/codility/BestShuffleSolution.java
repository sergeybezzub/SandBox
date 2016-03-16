package codility;

import java.util.Arrays;


public class BestShuffleSolution {


	public static void main(String[] args) {
		BestShuffleSolution so = new BestShuffleSolution();
		
		System.out.println(so.solution(5, 3, -1, 5));
	}
	
    public int solution(int A, int B, int C, int D) {

    	int[] S = new int[4];
    	S[0]=A;
    	S[1]=B;
    	S[2]=C;
    	S[3]=D;
    	
    	int[] results = shuffle(S);
    	if( results == null || results.length == 0)
    	{
    		return 0;
    	}
    	
    	Arrays.sort(results);
    	return results[results.length -1];
    }
    
    private int[] shuffle(int[] buf)
    {
    	int[] res = new int[24];
    	
    	res[0] = Math.abs(buf[0]-buf[1]) + Math.abs(buf[1]-buf[2]) + Math.abs(buf[2]-buf[3]);
    	res[1] = Math.abs(buf[1]-buf[0]) + Math.abs(buf[0]-buf[2]) + Math.abs(buf[2]-buf[3]);
    	res[2] = Math.abs(buf[1]-buf[2]) + Math.abs(buf[2]-buf[0]) + Math.abs(buf[0]-buf[3]);
    	res[3] = Math.abs(buf[1]-buf[2]) + Math.abs(buf[2]-buf[3]) + Math.abs(buf[3]-buf[0]);
    	res[4] = Math.abs(buf[0]-buf[2]) + Math.abs(buf[2]-buf[1]) + Math.abs(buf[1]-buf[3]);
    	res[5] = Math.abs(buf[0]-buf[2]) + Math.abs(buf[2]-buf[3]) + Math.abs(buf[3]-buf[1]);
    	res[6] = Math.abs(buf[2]-buf[0]) + Math.abs(buf[0]-buf[1]) + Math.abs(buf[1]-buf[3]);
    	res[7] = Math.abs(buf[0]-buf[1]) + Math.abs(buf[1]-buf[3]) + Math.abs(buf[3]-buf[2]);
    	res[8] = Math.abs(buf[3]-buf[0]) + Math.abs(buf[0]-buf[1]) + Math.abs(buf[1]-buf[2]);
    	res[9] = Math.abs(buf[3]-buf[1]) + Math.abs(buf[1]-buf[0]) + Math.abs(buf[0]-buf[2]);
    	res[10] = Math.abs(buf[3]-buf[2]) + Math.abs(buf[2]-buf[0]) + Math.abs(buf[0]-buf[1]);
    	res[11] = Math.abs(buf[3]-buf[2]) + Math.abs(buf[2]-buf[1]) + Math.abs(buf[1]-buf[0]);
    	res[12] = Math.abs(buf[3]-buf[0]) + Math.abs(buf[0]-buf[2]) + Math.abs(buf[2]-buf[1]);
    	res[13] = Math.abs(buf[3]-buf[1]) + Math.abs(buf[1]-buf[2]) + Math.abs(buf[2]-buf[0]);
    	res[14] = Math.abs(buf[0]-buf[1]) + Math.abs(buf[1]-buf[3]) + Math.abs(buf[3]-buf[2]);
    	res[15] = Math.abs(buf[1]-buf[0]) + Math.abs(buf[0]-buf[3]) + Math.abs(buf[3]-buf[2]);
    	res[16] = Math.abs(buf[1]-buf[2]) + Math.abs(buf[2]-buf[3]) + Math.abs(buf[3]-buf[0]);
    	res[17] = Math.abs(buf[1]-buf[3]) + Math.abs(buf[3]-buf[2]) + Math.abs(buf[2]-buf[0]);
    	res[18] = Math.abs(buf[1]-buf[3]) + Math.abs(buf[3]-buf[0]) + Math.abs(buf[0]-buf[2]);
    	res[19] = Math.abs(buf[2]-buf[0]) + Math.abs(buf[0]-buf[3]) + Math.abs(buf[3]-buf[1]);
    	res[20] = Math.abs(buf[2]-buf[1]) + Math.abs(buf[1]-buf[0]) + Math.abs(buf[0]-buf[3]);
    	res[21] = Math.abs(buf[2]-buf[1]) + Math.abs(buf[1]-buf[3]) + Math.abs(buf[3]-buf[0]);
    	res[22] = Math.abs(buf[2]-buf[3]) + Math.abs(buf[3]-buf[0]) + Math.abs(buf[0]-buf[1]);
    	res[23] = Math.abs(buf[2]-buf[3]) + Math.abs(buf[3]-buf[1]) + Math.abs(buf[1]-buf[0]);
    			
    	return res;
    }

}
