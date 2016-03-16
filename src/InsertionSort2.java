import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InsertionSort2 {

	   public static void insertionSortPart2(int[] ar)
	    {       

		   for(int i=1; i< ar.length; i++)
		   {
			   ar = insertIntoSorted(ar, i);
			   printArray(ar);
		   }
	    }  
	    
	   public static int[] insertIntoSorted(int[] ar, int size) {
	    	if( ar == null || ar.length ==0 )
	    	{
	    		return null;
	    	}
	    	
	    	int value = ar[size];
	   		for(int i=size-1; i>=0; i--)
	   		{
	   			if(value<=ar[i])
	   			{
	   				ar[i+1]=ar[i];
	   	   			if(i==0)
	   	   			{
	   	   				ar[i]=value;
	   	   	   			break;   	   				
	   	   			}
	   			}
	   			else
	   			{
	   				ar[i+1]=value;
	   	   			break;
	   			}
	   		}
	   		
	   		return ar;
	     }	    
	      
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	       int s = in.nextInt();
	       int[] ar = new int[s];
	       for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	       }
	       insertionSortPart2(ar);    
	                    
	    }    
	    private static void printArray(int[] ar) {
	      for(int n: ar){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }
}
