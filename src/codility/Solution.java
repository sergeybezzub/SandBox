package codility;

public class Solution {

	public static void main(String[] args) {
		System.out.println(compute("PMLPMMMLPMLPMML"));
	}

	 private static int width = 10;
	 private static int height =15;

	 private static int[] box= new int[width * height];
	 private static String[] Y= {"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};


	static String compute(String instructions)
	{
	 if(instructions == null || instructions.length() == 0)
	 {
		return "";
	 }
     		
	 int blockPositionX=0;
	 
	 for( int i=0; i< instructions.length(); i++)
	 {
		 char instruction = instructions.charAt(i);
		 switch(instruction)
		 {
		 	case 'P':
		 		blockPositionX=0;
		 	break;
		 	case 'M':
		 		blockPositionX++;	 		
		 	break;
		 	case 'L':
		 		drop(blockPositionX);
		 	break;
		 }
	 }
	 
	 return getStringResult();
	}
	
	private static void drop(int x)
	{
		if(x >= width)
		{
			return;
		}

		for(int i=0; i< height; i++ )
		{
			if( box[x+ i*width] == 0)
			{
				box[x+ i*width]=1;
				break;
			}
		}
	}
	
	private static String getStringResult()
	{
		String res="";
		
		for(int x=0; x<width; x++)
		{

			for(int y=height-1; y>=0; y--)
			{
				if(box[x+ y*width] == 1)
				{
					res+=Y[y];
					break;
				}
				
				if(y==0)
				{
					res+=0;
				}
				
			}
		}
		
		return res;
	}
}
