package codility;

import java.math.BigInteger;
import java.util.Scanner;


public class Fibo {

	public final static String FIBONACCI ="IsFibo";
	public final static String NOT_FIBONACCI ="IsNotFibo";

	public static boolean isFibonacci(long value)
	{
		long[] currentValue = {0,1};
		
		if(value == currentValue[0] || value == currentValue[1])
		{
			return true;
		}
		
		BigInteger bigIntValue = BigInteger.valueOf(value);
		BigInteger bigInt1 = new BigInteger("1");
		BigInteger bigInt2 = new BigInteger("1");

		do
		{
			if(bigInt1.compareTo(bigIntValue) == 0 || bigInt2.compareTo(bigIntValue) == 0)
			{
				return true;
			}

			BigInteger bigIntTmp = bigInt1;
			bigInt1 = bigInt2;
			bigInt2 = bigIntTmp.add(bigInt2);
			
		}while(bigInt2.compareTo(bigIntValue) <= 0);
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int count = Integer.parseInt(in.nextLine());
	        
		for(int i=0; i<count; i++)
		{
            try
            {
                if(	isFibonacci( Long.parseLong(in.nextLine()) ) )
			    {
				     System.out.println(FIBONACCI);
			    }
			    else
			    {
			 	     System.out.println(NOT_FIBONACCI);		  		
			   }
            }
            catch(Exception e)
            {
			 	     System.out.println(NOT_FIBONACCI);		  		                
            }
		}
	}

}
