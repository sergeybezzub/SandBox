package array;

public class SortUtil {
	
	  public static void quickSort(int[] buf )
	  {
		  quickSort( buf, 0, buf.length-1);	  
	  }
	  
	  private static void quickSort(int[] buf, int low, int high)
	  {
		  int l = low;
		  int r = high;
		  int m = buf[(l+r)/2];

		  do
		  {
			  while(buf[l]<m)
			  {
				  l++;
			  }
	
			  while(buf[r]>m)
			  {
				  r--;
			  }
	
			  if(l<r)
			  {
				  int tmp=buf[l];
				  buf[l]=buf[r];
				  buf[r]=tmp;
			  }
			  else//if(l==r)
			  {
				  l++;
				  r--;
			  }
		  }while(l<r);
		  
		  if( low < r)
		  {
			  quickSort(buf, low, r);
		  }

		  if(  l < high)
		  {
			  quickSort(buf, l, high);
		  }
	  
	  }

	  public static void mergeSort(int[] buf )
	  {
		  mergeSort( buf, 0, buf.length-1);	  
	  }
	  
	  private static void mergeSort(int[] buf, int start, int finish)
	  {
		  int m = (start + finish) / 2;

		  if(start < finish)
		  {
			  mergeSort( buf, start, m);
			  mergeSort( buf, m+1, finish);		  
		  }

		  merge(buf, start, m, finish);

	  }
	  
	  private static void merge(int[] buf, int start, int middle, int finish)
	  {
		  int s1=start;
		  int e1=middle;
		  int s2=middle+1;
		  int e2=finish;
		  
		  System.out.println("\n--B1:");

		  for(int i=s1; i<= e1; i++) {
			  if(i > s1) {
				  System.out.print(",");
			  }
			  System.out.print(buf[i]);
		  }

		  System.out.println("\n--B2:");

		  for(int i=s2; i<= e2; i++) {
			  if(i > s2) {
				  System.out.print(",");
			  }
			  System.out.print(buf[i]);
		  }

		  if(s1 == e1)
		  {
			  if(buf[s1] > buf[s2])
			  {
				  swap(buf, s1, s2);
			  }
			  s1++;
			  s2++;			  
		  }
		  else
		  {
			  while(s1 < e1)
			  {
				  if(buf[s1] > buf[s2])
				  {
					  swap(buf, s1, s2);
				  }
				  s1++;
				  s2++;
			  }
		  }
		  System.out.println("\n--A1:");

		  for(int i=s1; i<= e1; i++) {
			  if(i > s1) {
				  System.out.print(",");
			  }
			  System.out.print(buf[i]);
		  }
	  
		  System.out.println("\n--A2:");

		  for(int i=s2; i<= e2; i++) {
			  if(i > s2) {
				  System.out.print(",");
			  }
			  System.out.print(buf[i]);
		  }

	  }
	  
	  private static void swap( int[] buff, int s, int e)
	  {
		  int tmp = buff[s];
		  buff[s] = buff[e];
		  buff[e] = tmp;
	  }
	  
	  public static void main(String[] argv) {
		  
		  int[] buff = {100,25,5,38,88,22,44,77,55,2, 15, 28, 31,48, 33, 58, 72, 68,10, 12 };	  
		  int[] buff1 = {100,25,5,38,88,22,44,77,55,2, 15, 28, 31,48, 33, 58, 72, 68,10, 12 };	  

		  System.out.println("Before:");
		  int i=0;
		  for(int c : buff) {
			  if(i > 0) {
				  System.out.print(",");
			  }
			  System.out.print(c);
			  i++;
		  }
		  
		  quickSort( buff );
		  
		  System.out.println("\nAfter:");
		  i=0;
		  for(int c : buff) {
			  if(i > 0) {
				  System.out.print(",");
			  }
			  System.out.print(c);
			  i++;
		  }
	  
		  System.out.println("\nBefore:");
		  i=0;
		  for(int c : buff1) {
			  if(i > 0) {
				  System.out.print(",");
			  }
			  System.out.print(c);
			  i++;
		  }
		  
		  mergeSort( buff1 );
		  
		  System.out.println("\nAfter:");
		  i=0;
		  for(int c : buff1) {
			  if(i > 0) {
				  System.out.print(",");
			  }
			  System.out.print(c);
			  i++;
		  }

	  }
}
