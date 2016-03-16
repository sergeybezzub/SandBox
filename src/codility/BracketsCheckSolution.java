package codility;

import java.util.Stack;

public class BracketsCheckSolution {


	public static void main(String[] args) {

		Solution s = new Solution();
		
		System.out.println(s.check("{[()]}"));
		System.out.println(s.check("[(]"));
		System.out.println(s.check("[({)]"));
		System.out.println(s.check("[{(}]"));
		System.out.println(s.check("{[()]"));
		System.out.println(s.check("{}"));
	}

	public boolean check(String str)
	{
		Stack<String> stack = new Stack<String>();

		for(int i=0; i< str.length(); i++)
		{
			if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
			{
				stack.push(""+str.charAt(i));
			}
			else if(str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}')
			{
				if(stack.isEmpty())
				{
					return false;
				}
				String c = stack.pop();
				switch(c) 
				{
					case "(" :
						if(str.charAt(i) != ')')
						{
							return false;
						}
						break;
					case "{" :
						if(str.charAt(i) != '}')
						{
							return false;
						}

						break;
					case "[" :
						if(str.charAt(i) != ']')
						{
							return false;
						}
						break;
				}
			}
		}

		if(stack.isEmpty())
		{
			return true;
		}
		else
		{
			return false;			
		}
	}

}
