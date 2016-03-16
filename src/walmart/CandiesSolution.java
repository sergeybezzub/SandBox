package walmart;

import java.util.Scanner;

public class CandiesSolution {

	static int distributeCandy(int[] score) {
		int res=0;	
		
		int[] candies= new int[score.length];

		candies[0]=1;
		
		for(int i=1 ; i< score.length; i++) {
			
			if( score[i] > score[i-1]) {
				candies[i]=(candies[i-1] + 1);
			} else {
				candies[i]=1;
			}	
		}
		
		for(int i=score.length-1 ; i>0; i--) {
			
			if( score[i-1] > score[i]) {
				candies[i-1]=Math.max(candies[i-1], candies[i]+1);
			}
		}

		for (int i = 0; i < score.length; i++)
	     {
	         res+=candies[i];
	     }		
		return res;
    }

	public static void main(String[] args) {
	   int[] score = {2,4,2,6,1,7,8,9,2,1};
	   int[] score1 = {1,2,2};
	   
	   System.out.println(distributeCandy(score));
	   System.out.println(distributeCandy(score1));
		
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int[] buf=null;
//		buf = new int[n];
//		
//		for( int i=0; i<n; i++)
//		{
//			buf[i]=in.nextInt();
//		}
//		
//		System.out.println(distributeCandy(buf));

		
	}

}
