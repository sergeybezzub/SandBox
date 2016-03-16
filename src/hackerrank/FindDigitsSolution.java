package hackerrank;
import java.util.Scanner;


public class FindDigitsSolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();

		for(int i=0; i<n; i++)
		{
			long value = in.nextLong();
			String sValue = ""+value;
			int count = 0;
			for(int j=0; j<sValue.length(); j++)
			{
				int c = sValue.charAt(j);
				if(c == 0x30)
				{
					continue;
				}
				else if( (value % (c-0x30)) == 0)
				{
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
