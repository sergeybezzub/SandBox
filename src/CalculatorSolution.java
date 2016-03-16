import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorSolution {

	public int calculate(String str){
		
  		String[] parts = str.split(" ");
  		Stack<String> stack = new Stack<String>();
  		int result=0;
  		boolean isResultExist=false;
  		int firstValue=0;
		
		  for(String part : parts)
		  {
			   if( isDigitItem(part) )
			   {
				     Integer.valueOf(part);
				     stack.push(part);
			   }
			   else if( isValidOperation(part) )
			   {
				     int secondValue= Integer.valueOf((String)stack.pop());
				     if( !isResultExist )
				     {
					       firstValue= Integer.valueOf((String)stack.pop());
					       isResultExist=true;
				     }

				     result = performOperation( firstValue, secondValue, part);
				     firstValue=result;
			   }
			   else
			   {
				     throw new IllegalArgumentException("Wrong inpput string - "+str);
			   }
		 }
		
		return result;
	}

	private int performOperation(int firstValue, int secondValue, String operation) {
		  int result=0;
		  switch(operation)
		  {
		  case "+":
			  result=firstValue+secondValue;
			  break;
		  case "-":
			  result = firstValue-secondValue;
			  break;
		  case "x":
			  result = firstValue * secondValue;
			  break;
		  case "/":
			  result = firstValue / secondValue;
			  break;
		  }
		  return result;
	 }

	 private boolean isValidOperation(String part) {
		  return part.matches("[-+x/]");
	 }

	 private boolean isDigitItem(String part) {
		  return part.matches("[0-9]+");
	 }
	 
	 @Test
	 public void makeDevidePositive()
	 {
		CalculatorSolution calculator = new CalculatorSolution();
		String value = "66 3 /";
		int result=calculator.calculate(value);
			
		Assert.assertEquals(22, result);
	}

	// check if operation is valid
	@Test(expected=IllegalArgumentException.class)
	public void checkIncorectOperationNegative()
	{
		CalculatorSolution calculator = new CalculatorSolution();
		String value = "2 3 + 5 *";
		int result=calculator.calculate(value);
			
		Assert.assertEquals(25, result);
	}
}
