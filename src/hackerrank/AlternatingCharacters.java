package hackerrank;
import java.util.Scanner;


public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] s = new String[n];
		
		for(int i=0; i<n; i++)
		{
			s[i] = in.next();
		}
		in.close();

		for(int i=0; i<n; i++)
		{
			int removeCount=0;
			char ch=s[i].charAt(0);
			for(int c=1; c<s[i].length(); c++)
			{
				if(ch == s[i].charAt(c))
				{
					removeCount++;
				}
				else
				{
					ch=s[i].charAt(c);
				}
			}
			System.out.println(removeCount);
		}
	}

}
