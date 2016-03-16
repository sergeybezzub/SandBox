import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class LonelyIntegerSolution {

	static int lonelyinteger(int[] a) {
		Set<Integer> numbers = new HashSet<Integer>();
		List<Integer> results = new ArrayList<Integer>();
		for(int i=0; i<a.length; i++)
		{
			Integer c = new Integer( a[i] );
			if(	numbers.add(c) )
			{
				results.add(c);
			}
			else
			{
				results.remove(c);
			}
		}
		
		return results.size()>0 ?results.get(0) : 0;
	}
	public static void main(String[] args) {

	       Scanner in = new Scanner(System.in);
	        int res;
	        
	        int _a_size = Integer.parseInt(in.nextLine());
	        int[] _a = new int[_a_size];
	        int _a_item;
	        String next = in.nextLine();
	        String[] next_split = next.split(" ");
	        
	        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
	            _a_item = Integer.parseInt(next_split[_a_i]);
	            _a[_a_i] = _a_item;
	        }
	        
	        res = lonelyinteger(_a);
	        System.out.println(res);
	        
	}

}
