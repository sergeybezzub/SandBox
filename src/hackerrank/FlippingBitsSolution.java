package hackerrank;
import java.util.Scanner;


public class FlippingBitsSolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n=0;
        try
        {
            n = in.nextInt();
        }
        catch(Exception e){}
        
		for(int i=0; i<n; i++)
		{
            try
            {
                long value = in.nextLong();
                if(value < 4294967296l)
                {
                    int ivalue = (int)value;
                    ivalue^= 0xffffffff;
                    //Java 8 only!
                    System.out.println(Integer.toUnsignedString(ivalue));
                }
            }
            catch(Exception e){}
		}	
	}
}
