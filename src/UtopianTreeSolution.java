import java.util.Scanner;


public class UtopianTreeSolution {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

		int n = in.nextInt();
        
        
        for( int i=0; i<n; i++)
		{
        	int height = 1;
        	int cycle = in.nextInt();
            for(int j=1; j<=cycle; j++)
            {
                if( j%2 == 0)
                {
                	height+=1;
                }
                else
                {
                	height*=2;
                }
            }
            System.out.println(height);
		}	
     }

}
