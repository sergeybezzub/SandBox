
public class NumberComplimentSolution {


	public static void main(String[] args) {

	
		System.out.println(getIntegerComplement(100));
		System.out.println(getIntegerComplement(5));
		System.out.println(getIntegerComplement(50));
	}

	static int getIntegerComplement(int n) {

		if(n == 0)
		{
			return 1;
		}
		int mask=findMask(n);
		
		return n ^ mask;
    }
	
	private static int findMask(int n)
	{
		for(int i=1; i<17; i++  )
		{
			double v = Math.pow(2, (double) i);
			if(v > n )
			{
				return (int)(v-1);
			}
		}
		
		return 1;
	}
}
