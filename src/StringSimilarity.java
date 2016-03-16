import java.util.Scanner;


public class StringSimilarity 
{


	public static void main(String[] args) 
	{
        Scanner in = new Scanner(System.in);

		int n = in.nextInt();       
        
        for( int i=0; i<n; i++)
		{
        	
        	String s = in.next();
        	System.out.println(stringSimilarity(s));        		
		}
	}
	
	private static int calculateSimilarity(String original, int start, int size)
	{
		int i=0;
		for(int j=start; j<size;i++, j++)
		{
			if(original.charAt(i) != original.charAt(j))
			{
				break;
			}
		}
		return i;
	}
	
	private static long stringSimilarity(String a) 
	{
    	int size = a.length();
    	int res = size;
    	
    	for(int c=1; c < size; c++)
    	{
        	res+=calculateSimilarity(a, c, size);        		
    	}

        return res;
    }

}
