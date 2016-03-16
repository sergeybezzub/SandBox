import java.util.Scanner;


public class FizzBuzzSolution {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		System.out.print(handleData(n));

	}

	public static String handleData(int n)
	{
		String res="";
		
		final String fizz = "Fizz";
		final String buzz = "Buzz";
		
		for(int i = 1 ; i<= n; i++)
		{
			if(i%3 ==0 && i%5 ==0 )
			{
				res+="\n"+fizz;
				res+=buzz;
			} 
			else if(i%3 ==0)
			{
				res+="\n"+fizz;
			} 
			else if(i%5 ==0)
			{
				res+="\n"+buzz;
			}
			else
			{
				res+="\n"+i;
			}
		}
		
		return res;
	}

}
