package hackerrank;
import java.util.Scanner;


public class MatrixRotation 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		//Input data
		int m = in.nextInt();
		int n = in.nextInt();
		int size = m*n;

		int r = in.nextInt();
	
		int[] matrix = new int[size];
        
		for(int j=0; j<m; j++)
		{
			for(int i=0; i<n; i++)
			{
				matrix[i+j*n]=in.nextInt();
			}
		}

		float rowsMiddle = m/2;
		float columnsMiddle = n/2;
		int[] rotatedMatrix = new int[size];
        
		//Rotate
		for(int i=0; i <r; i++)
		{
			matrix = rotate(m, n, matrix, rotatedMatrix, rowsMiddle, columnsMiddle);
		}
	
		//Output data
		for(int j=0; j<m; j++)
		{
			for(int i=0; i<n; i++)
			{
				System.out.print(matrix[i+j*n]);					
				
				if(i< n-1)
				{
					System.out.print(" ");										
				}
			}
			System.out.print("\n");

		}
	}

	private static int[] rotate(int m, int n, int[] matrix, int[] rotatedMatrix, float rowsMiddle, float columnsMiddle )		
	{

		for(int j=0; j<m; j++)
		{
			for(int i=0; i<n; i++)
			{
				int rotatedValue=matrix[i+j*n];
				
				if(isMoveDown(j, i, rowsMiddle, columnsMiddle, m, n))
				{
					rotatedMatrix[i+(j+1)*n] = rotatedValue;
				}
				else if(isMoveLeft(j, i, rowsMiddle, columnsMiddle, m, n))
				{
					rotatedMatrix[(i-1)+j*n] = rotatedValue;				
				}
				else if(isMoveRight(j, i, rowsMiddle, columnsMiddle, m, n))
				{
					rotatedMatrix[(i+1)+j*n] = rotatedValue;					
				}
				else if(isMoveUp(j, i, rowsMiddle, columnsMiddle, m, n))
				{
					rotatedMatrix[i+(j-1)*n] = rotatedValue;					
				}
			}
		}
        
        return rotatedMatrix.clone();
	}
	
	private static boolean isMoveLeft(int row, int column, float rowsMiddle, float columnsMiddle, int rowsCount, int columnsCount)
	{
		if(column > row  && row < rowsMiddle && column < columnsCount - row )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static boolean isMoveRight(int row, int column, float rowsMiddle, float columnsMiddle, int rowsCount, int columnsCount)
	{
		if(row >= rowsMiddle && rowsCount - row < columnsCount - column && rowsCount - row != columnsCount - column)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static boolean isMoveUp(int row, int column, float rowsMiddle, float columnsMiddle, int rowsCount, int columnsCount)
	{
		if(column >= columnsMiddle)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static boolean isMoveDown(int row, int column, float rowsMiddle, float columnsMiddle, int rowsCount, int columnsCount)
	{
		
		if(column <= row  && column < columnsMiddle &&  rowsCount - row -1 > column && row < rowsCount -1 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

