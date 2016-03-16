package hackerrank;
import java.util.Scanner;


public class LibraryFine {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dayActual = in.nextInt();
		int monthActual = in.nextInt();
		int yearActual = in.nextInt();

		int dayExpected = in.nextInt();
		int monthExpected = in.nextInt();
		int yearExpected = in.nextInt();
	
		in.close();

		if( yearExpected < yearActual)
		{
			System.out.print(10000);
		}
		else if( yearExpected > yearActual)
		{
			System.out.print(0);			

		}
		else
		{
			if(monthExpected < monthActual)
			{
				System.out.print((monthActual - monthExpected)*500);
			}
			else if(monthExpected > monthActual)
			{
				System.out.print(0);
			}
			else
			{
				if(dayExpected < dayActual)
				{
					System.out.print((dayActual - dayExpected)*15);
				}
				else
				{
					System.out.print(0);					
				}
			}
		}
	}

}
