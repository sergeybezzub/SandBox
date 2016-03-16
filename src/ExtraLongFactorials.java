import java.math.BigInteger;
import java.util.Scanner;


public class ExtraLongFactorials 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		System.out.println(factorial(n).toString());
	}
	
	private static BigInteger factorial(int n)
	{
		return factorialInternal(BigInteger.ONE, n);
	}
	
	private static BigInteger factorialInternal(BigInteger accumulator, int n)
	{
		BigInteger bI = new BigInteger(""+n);
		if (n == 0)
        {
        	return accumulator;
        }
        else
        {
        	return factorialInternal(accumulator.multiply(bI), n - 1);
        }

	}
}
