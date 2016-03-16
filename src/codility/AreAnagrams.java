package codility;

import java.util.Arrays;


public class AreAnagrams {

	public static boolean areAnagrams(String a, String b) {
		if(a == null || a.length() == 0 || b == null || b.length() == 0 || a.length() != b.length())
        {
        	return false;    
        }
        
        char[] w1 = new char[a.length()];
        char[] w2 = new char[a.length()];
        
        for(int i =0; i<a.length(); i++)
        {
            w1[i]=a.charAt(i);
            w2[i]=b.charAt(i);
        }
        
        Arrays.sort(w1);
        Arrays.sort(w2);
        
        if(new String(w1).equals(new String(w2)))
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("momdad", "dadmom"));
    }
}