package hackerrank;
import java.util.Scanner;

public class FindMissedElementSolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] values= new int[n];
		for( int i=0; i<n; i++)
		{
			values[i]=in.nextInt();
		}
	
		for(int i=0; i<n-2; i++)
		{
			if( values[i+1]-values[i] == values[i+2]-values[i+1] )
			{
				continue;
			}
			else if(values[i+1]-values[i] > values[i+2]-values[i+1] )
			{
				System.out.println( values[i] + values[i+2]-values[i+1]);
				break;
			}
			else
			{
				System.out.println(values[i+1] + values[i+1]-values[i]);
				break;
			}
		}
	}

}
