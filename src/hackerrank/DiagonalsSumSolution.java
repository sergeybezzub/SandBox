package hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalsSumSolution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int size=n*n;
		int[] values = new int[size];
		
		for( int i=0; i<size; i++)
		{
			values[i]=in.nextInt();
		}

		
		long sum=values[0];
		
		for( int i=1; i<n;  i++)
		{
			sum+=values[i+i*n];
		}

		long sum2=values[(n-1)*n];
		
		for( int i=1, j=n-2; i<n;  i++, j--)
		{
			sum2+=values[i+j*n];
		}
		
		System.out.println(sum > sum2 ? sum-sum2 : sum2-sum);
    }
}