import java.util.EmptyStackException;
import java.util.Stack;


public class BracketsSolution {

	public static void main(String[] args) {
		
		System.out.println(braces("{(["));
		System.out.println(braces("{([))}"));
		System.out.println(braces("{([])}"));
	}

	static String braces(String value){
		final String NO = "NO";
		final String YES = "YES";
		Stack<String> stack = new Stack<String>();
		
		if(value == null || value.length() <2)
		{
			return NO;
		}
		
		for(int i=0; i< value.length(); i++)
		{
			String ch = "" + value.charAt(i);
			if( "(".equals(ch) || "{".equals(ch) || "[".equals(ch) )
			{
				stack.push(ch);
			}
			else if(")".equals(ch) || "}".equals(ch) || "]".equals(ch))
			{
				String s = null;
				try
				{
					s = stack.pop();
				}
				catch(EmptyStackException e)
				{
					return NO;
				}
				
				switch(ch)
				{
				case ")":
					if(!"(".equals(s))
					{
						return NO;
					}
					break;
				case "}":
					if(!"{".equals(s))
					{
						return NO;
					}
					break;
				case "]":
					if(!"[".equals(s))
					{
						return NO;
					}
					break;
				}
			}
		}
		if(stack.isEmpty())
		{
			return YES;
		}
		else
		{
			return NO;
		}
	}

}
