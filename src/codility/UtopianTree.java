package codility;

import java.util.Scanner;


public class UtopianTree {

	public int calculateHeight(int amountOfCicles)
	{
		int treeHeight =1;
		int count=0;

		while(count < amountOfCicles)
		{
			treeHeight*=2;
			count++;
			if(count < amountOfCicles )
			{
				treeHeight+=1;
				count++;
			}
			else
			{
				break;
			}
		}

		return treeHeight;
	}

	public static void main(String[] args) 
	{

		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
	
		UtopianTree utopianTree = new UtopianTree();

		for(int i=0; i < count; i++)
		{
			System.out.println(utopianTree.calculateHeight(in.nextInt()));
			
		}
	}

}
