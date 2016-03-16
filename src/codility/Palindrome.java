package codility;

public class Palindrome {
	public static boolean isPalindrome(String str) {

		int count=0;
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(	Character.isAlphabetic(c))
			{
				count++;
			}
		}
		int half = count / 2;

		for(int i=0,j=str.length()-1, c=0; c<half; )
		{
			char c1;
			char c2;
			do
			{
				c1 = str.charAt(i++);
				if(Character.isAlphabetic(c1))
				{
					c++;
				}
			}while(!Character.isAlphabetic(c1));

			do
			{
				c2 = str.charAt(j--);
			}while(!Character.isAlphabetic(c2));
			
			if(Character.toLowerCase(c1) != Character.toLowerCase(c2))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("Noel sees Leon."));
		System.out.println(isPalindrome("Noel seis Leon."));
	}

	private boolean isAlpha(String s) {
	    return s.matches("[a-zA-Z]+");
	}
}
