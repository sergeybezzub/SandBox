import java.util.Scanner;


public class Encryption {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();

		int l = s.length();
		
		int rows = (int) Math.sqrt((double)l);	
		int columns = rows;
		int i=0;
		
		while(columns*rows < l)
		{
			if(i%2 == 0)
			{
				columns++;
			}
			else
			{
				rows++;
			}
			i++;
		}

		String[] results = new String[columns];
		for(i=0; i< columns; i++)
		{
			results[i]="";
		}
		
		for(int c=0, j=0; c<l; c++)
		{
			char ch = s.charAt(c);
			results[j]+=ch;
			j++;
			if(j >= columns )
			{
				j=0;
			}
		}
		
		for(i=0; i<columns; i++)
		{
			if(i !=0)
			{
				System.out.print(" ");
			}
			System.out.print(results[i]);
		}
		System.out.print("\n");

	}

}
