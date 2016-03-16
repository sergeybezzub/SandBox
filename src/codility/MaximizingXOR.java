package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MaximizingXOR {

	public static int maxXor(int l, int r)
	{
		List<Integer> xors = new ArrayList<Integer>(); 

		for(int j =l; j<= r; j++)
		{		
			for(int i =j; i<= r; i++)
			{
				xors.add(i^j);
				System.out.println(j+" ^ "+i+" = "+ (i^j));
			}
		}

		Integer[] xorArrays = xors.toArray(new Integer[xors.size()]); 
		Arrays.sort(xorArrays);

		return xorArrays[xorArrays.length-1];
	}
	
	public static void main(String[] args) 
	{
	       Scanner in = new Scanner(System.in);
	        int res;
	        int _l;
	        _l = Integer.parseInt(in.nextLine());
	        
	        int _r;
	        _r = Integer.parseInt(in.nextLine());
	        
	        res = maxXor(_l, _r);
	        System.out.println(res);	
	}

}
