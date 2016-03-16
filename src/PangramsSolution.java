import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class PangramsSolution {


	public static void main(String[] args) {

		final String PANGRAM = "pangram";
		final String NOPANGRAM = "not pangram";
		final int A = 0x61;
		final int Z = 0x7a;
		
		Set<Integer> symbols = new HashSet<Integer>();

		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		
		if(s==null || s.length() == 0)
		{
			System.out.println(NOPANGRAM);
		}

		s = s.toLowerCase();
		for(int i=0; i<s.length(); i++)
		{
			Integer charakter = new Integer(s.charAt(i)); 
			if(charakter.intValue() >= A && charakter.intValue() <= Z )
			{
				symbols.add(charakter);
			}
		}
		
		if(symbols.size() < 26)
		{
			System.out.println(NOPANGRAM);			
		}
		else
		{
			System.out.println(PANGRAM);						
		}
	}

}
