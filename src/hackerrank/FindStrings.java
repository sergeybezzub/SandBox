package hackerrank;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FindStrings {

	/* Head ends here */
	static void findStrings(String[] a, int[] query) 
	{
		Set<String> stringsSet = new TreeSet<String>();

		for(String s : a)
		{
			int size = s.length();
			for( int j=0; j<size; j++)
			{
				for( int i=j+1; i<=size; i++)
				{
					String tmp = s.substring(j, i);
					stringsSet.add(tmp);
				}
			}
		}
		String[] array =stringsSet.toArray(new String[stringsSet.size()]);

		for(int index : query)
		{
			if((index-1) < array.length)
			{
				System.out.println(array[index-1]);
			}
			else
			{
				System.out.println("INVALID");
			}
		}


	}
	
	/* Tail starts here */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
	                
		int n = in.nextInt();

		String[] strings = new String[n];

		for(int i = 0; i < n; i++) 
		{
			strings[i] = in.next();
		}
		
		int q = in.nextInt();
		int[] query = new int[q];
		for(int i = 0; i < q; i++) 
		{
			query[i] = in.nextInt();
		}
		
		findStrings(strings,query);
		
		in.close();
	}
}
