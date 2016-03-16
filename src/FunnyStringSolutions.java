import java.util.Scanner;


public class FunnyStringSolutions {

	public static void main(String[] args) {
		final String no = "Not Funny";
		final String yes = "Funny";
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=0; i<n; i++)
		{
			String s = in.next();
			boolean isFanny=true;
			int size = s.length();
			if(size < 2 || size > 10000)
			{
				System.out.println(no);
			}
		
			for(int j=1, k=size-1; j<size-1; j++, k--)
			{
				if(Math.abs(s.charAt(j) - s.charAt(j-1)) != Math.abs(s.charAt(k) - s.charAt(k-1)))
				{
					System.out.println(no);
					isFanny=false;
					break;
				}
			}
			if( isFanny)
			{
				System.out.println(yes);
			}
		}
	}

}
