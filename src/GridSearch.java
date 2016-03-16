import java.util.Scanner;


public class GridSearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testsAmount = in.nextInt();

		// Test case processing
		for (int t = 0; t < testsAmount; t++) {
			//Grid
			int gridRows = in.nextInt();
			int gridColumns = in.nextInt();

			int[] mainGrid = populateGrid(gridRows, gridColumns, in);

			//Pattern
			int patternRows = in.nextInt();
			int patternColumns = in.nextInt();

			int[] pattern = populateGrid(patternRows, patternColumns, in);
			
			//Search
			boolean bResult=false;
			for(int j=0; j < gridRows - patternRows; j++)
			{
				for(int i=0 ; i< gridColumns - patternColumns; i++)
				{
					if(hasPatternFound(j, i, mainGrid, pattern, gridColumns, patternRows, patternColumns))
					{
						j=gridRows - patternRows;
						bResult=true;
						break;
					}
				}
			}
			
			if(bResult)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}

		in.close();
	}
	
	private static boolean hasPatternFound(int startY, int startX, int[] grid, int[] p, int gridWidth, int maxY, int maxX)
	{
		for(int j=0; j< maxY; j++)
		{
			for(int i=0; i< maxX;i++)
			{
				if( grid[startX+i+(startY+j)*gridWidth] != p[i+j*maxX])
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static int[] populateGrid(int rows, int columns, Scanner in)
	{
		int[] grid = new int[rows * columns];

		for (int r = 0; r < rows; r++) {
			String value = in.next();
			
			int[] tmpRow = buildRow(value);

			for (int i = 0; i < columns; i++) {
				grid[i + r * columns] = tmpRow[i];
			}
		}
		
		return grid;
	}
	
	private static int[] buildRow(String s) {
		int size = s.length();

		int[] row = new int[size];

		for(int i=0; i<size;i++)
		{
			row[i]=s.charAt(i)-0x30;
		}

		return row;
	}


}
