import java.util.Scanner;


public class IsertionSortFixRequired {

	   public static void insertionSort(int[] ar)
	    {       

		   for(int i=1; i< ar.length; i++)
		   {
			   ar = insertIntoSorted(ar, i);
		   }
		   printArray(ar);

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


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
    
}
