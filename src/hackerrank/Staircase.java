package hackerrank;
import java.util.Scanner;


public class Staircase {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.close();

		for(int j=1; j<=n; j++)
		{
			for(int i=0; i<n-j; i++)
			{
				System.out.print(" ");
			}
			for(int i=0; i<j; i++)
			{
				System.out.print("#");
			}
			System.out.println("");			
		}
	}

}
