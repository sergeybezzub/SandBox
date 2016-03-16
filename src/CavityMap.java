import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] buf = new int[n * n];

		for (int j = 0; j < n; j++) {
			String value = in.next();

			if(n <3)
			{
				System.out.println(value);
			}
			
			int[] tmpRow = buildRow(value, n);

			for (int i = n-1, c=tmpRow.length-1; i >=0; i--, c--) {
				buf[i + j * n] = tmpRow[c];
			}

		}

		in.close();

		if(n < 3)
		{
			return;
		}
		
		for (int j = 0; j < n; j++) {
			for( int i = 0; i< n; i++) {
				int current=buf[i + j*n];
				if(i == 0 || i == n-1 || j==0 || j == n-1)
				{
					System.out.print(current);
				}
				else
				{
					int adjacentLeft=buf[(i-1) + j*n];
					int adjacentRight=buf[(i+1) + j*n];
					int adjacentTop=buf[i + (j-1)*n];
					int adjacentBottom=buf[i + (j+1)*n];
					if(current > adjacentLeft && current > adjacentRight && current > adjacentTop && current > adjacentBottom)
					{
						System.out.print("X");
					}
					else
					{
						System.out.print(current);					
					}
				}
			}
			System.out.print("\n");
		}

	}

	private static int[] buildRow(String s, int length) {
		int size = s.length();
		int count = length > size ? length : size;

		int[] row = new int[count];

		if( length > size )
		{
			for(int i=0; i< length-size; i++)
			{
				s= "0"+s;
			}
		}
		for(int i=0; i<count;i++)
		{
			row[i]=s.charAt(i)-0x30;
		}

		return row;
	}

}
