package array;

public class MergeSort {
	
	/**
	 * Merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	 * @param a - array to sort
	 * @param aux - tmp array
	 * @param lo - low index
	 * @param mid - middle index 
	 * @param hi - high index
	 */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) 
        {
            if(i > mid) 
            {
            	a[k] = aux[j++];   // this copying is unnecessary
            }
            else if (j > hi) 
            {
            	a[k] = aux[i++];
            }
            else if (aux[j] < aux[i]) 
            {
            	a[k] = aux[j++];
            }
            else 
            {
            	a[k] = aux[i++];
            }
        }

    }

    /**
     * Sort a[lo..hi] using auxiliary array aux[lo..hi]
     * @param a
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sort(int[] a, int[] aux, int lo, int hi) 
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) 
    {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }
        

    // print array to standard output
    private static void show(int[] a) 
    {
        for (int i = 0; i < a.length; i++) 
        {
            System.out.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) 
    {
        int[] a = {1,11,22,5,124,12,44,29,2,7,18,99};
        MergeSort.sort(a);
        show(a);
    }

}
