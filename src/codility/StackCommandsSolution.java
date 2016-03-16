package codility;

import java.util.Stack;


public class StackCommandsSolution {

	private static final int ERROR_VALUE = -1;

	public StackCommandsSolution() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		StackCommandsSolution s = new StackCommandsSolution();
		System.out.println(s.solution("13 DUP 4 POP 5 DUP + DUP + -"));
		System.out.println(s.solution("3 DUP 5 - -"));
		System.out.println(s.solution("5 6 + -"));
		
	}

    public int solution(String S) {
    	
    	if(S == null || S.length() ==0 ) {
    		return ERROR_VALUE;
    	}
    	
    	String[] commands = S.split(" ");
    	Stack<Integer> stack = new Stack<Integer>();
    	Integer v1=null;
		Integer v2=null;
    	
    	for( String command : commands) {
    		switch (command) {
    			case "DUP":
    				if(stack.empty()) {
    					return ERROR_VALUE; 
    				}
    				Integer v = stack.peek();
    				stack.push(v);
    				
    			break;
    			case "POP":
    				if(stack.empty()) {
    					return ERROR_VALUE; 
    				}
    				stack.pop();
    			break;
    			case "+":
    				if(stack.size() < 2) {
    					return ERROR_VALUE; 
    				}
    				v1 = stack.pop();
    				v2 = stack.pop();
    				
    				if(v1.intValue()+v2.intValue() > 1048575 || v1.intValue()+v2.intValue() < 0) {
    					return ERROR_VALUE;
    				}
    				stack.push(v1.intValue()+v2.intValue());
    				
    			break;
    			case "-":
    				if(stack.size() < 2) {
    					return ERROR_VALUE; 
    				}
    				v1 = stack.pop();
    				v2 = stack.pop();
    				
    				if(v1.intValue()-v2.intValue() > 1048575 || v1.intValue()-v2.intValue() < 0) {
    					return ERROR_VALUE;
    				}
    				stack.push(v1.intValue()-v2.intValue());    				
    			break;
    			default:
    				try {
    					v1 = Integer.valueOf(command);
        				if(v1 > 1048575 || v1 < 0) {
        					return ERROR_VALUE;
        				}

    					stack.push(v1);
    				} catch (NumberFormatException e) {
    					return ERROR_VALUE;
    				}    				
    		}
    	}
    	
    	if(stack.isEmpty()) {
    		return ERROR_VALUE;
    	} else {    		
    		Integer v =stack.pop();
    		return v.intValue();
    	}

    }
}
