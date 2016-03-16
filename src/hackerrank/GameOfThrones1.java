package hackerrank;
import java.util.Arrays;
import java.util.Scanner;


public class GameOfThrones1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();

		char[] chars = new char[s.length()];
		
		for(int i=0; i< chars.length; i++)
		{
			chars[i]=s.charAt(i);
		}
		
		Arrays.sort(chars);
		
		int count=1;
		char ch = chars[0];
		int oddCount=0;
		for(int i=1; i< chars.length; i++)
		{
			if(ch == chars[i])
			{
				count++;
			}
			else
			{
				if(count%2 > 0 )
				{
					if( count == 1 && i != chars.length -1)
					{
						System.out.println("NO");
						return;
					}
					else if( count > 1)
					{
						oddCount++;
						if(oddCount > 1)
						{
							System.out.println("NO");
							return;							
						}
					}
				}
				count=1;
				ch=chars[i];
			}
		}
		System.out.println("YES");	
	}

}
