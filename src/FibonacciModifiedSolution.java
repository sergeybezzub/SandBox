import java.math.BigInteger;
import java.util.Scanner;


public class FibonacciModifiedSolution {

	private static int a = 0;
	private static int b = 1;


	
	private static BigInteger fibonacci(int n)
    {
		if( n == 0)	{
			return new BigInteger("0");
		} else if(n == 2) {
			return new BigInteger(""+b);
		}else if(n==1) {
			return new BigInteger(""+a);
		}
		BigInteger res = fibonacci(n - 1).multiply(fibonacci(n - 1));
		return res.add(fibonacci(n - 2));
    }
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		int n = in.nextInt();
		System.out.println(fibonacci(n));
	}

}
