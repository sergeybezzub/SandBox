import java.util.Scanner;


public class PlusMinus {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

		int n = in.nextInt();       
        double positiveCount=0;
        double negativeCount=0;
        double zeroCount=0;
        
		for(int i=0; i<n; i++)
		{
			int c=in.nextInt();
			if(c>0)
			{
				positiveCount++;
			}
			else if(c<0)
			{
				negativeCount++;
			}
			else
			{
				zeroCount++;
			}
		}
		
		in.close();
		

		System.out.printf("%.3f\n", positiveCount/n);
		System.out.printf("%.3f\n", negativeCount/n);
		System.out.printf("%.3f\n", zeroCount/n);
	}

}
