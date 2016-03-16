package array;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

	//Note: Array should be sorted
	
	public static boolean search(int[] data, int key) 
	{
		int low = 0;
		int high = data.length - 1;
	          
		while(high >= low) {
			int middle = (low + high) / 2;
	       if(data[middle] == key) {
	    	   return true;
	       }
	       if(data[middle] < key) {
	            low = middle + 1;
	        }
	       if(data[middle] > key) {
	    	   high = middle - 1;
	        }
		}
		return false;
	}

	@Test
	public void binarySearchPositive()
	{
		int[] massive ={0,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20};
		
		Assert.assertTrue(BinarySearch.search( massive, 20));
		Assert.assertTrue(BinarySearch.search( massive, 2));
		Assert.assertTrue(BinarySearch.search( massive, 0));
	}


	@Test
	public void binarySearchNegative()
	{
		int[] massive ={0,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20};
		
		Assert.assertFalse(BinarySearch.search( massive, 10));
		Assert.assertFalse(BinarySearch.search( massive, 21));
		Assert.assertFalse(BinarySearch.search( massive, 22));
		
	}

}
