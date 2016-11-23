//package algoBonus;
import static org.junit.Assert.assertArrayEquals;

import java.util.Stack;
// -------------------------------------------------------------------------
/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for prefix and postfix arithmetic expressions.
 *
 *  @author  
 *  @version 1/12/15 13:03:48
 */

public class Arith 
{

	//~ Validation methods ..........................................................


	/**
	 * Validation method for prefix notation.
	 *
	 * @param prefixLiterals : an array containing the string literals hopefully in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return true if the parameter is indeed in prefix notation, and false otherwise.
	 * 
	 * 
	 *time complexity:theta(n) since n * theta(1) = theta(n) where n is the number of elements.
	 * each element takes constant time to execute,
	 * push and pop and doOperation method also take theta(1) contant time.
	 * Since there are n literlas to execute, the algorithm would take thehta(n) time.
	 * As the size of the input increases, the time complexity increases aswell.
	 * 
	 * 
	 * space complexity:theta(1)	fixed amount of declarations even when size of N increases.
	 * independent on N
	 * 
	 **/
	public static boolean validatePrefixOrder(String prefixLiterals[])
	{
		int count =0;

		for(int i=prefixLiterals.length-1;i>=0;i--){

			String currentStr =prefixLiterals[i];

			if(isOperand(currentStr)) count++;
			else count--;

			if(count<=0) return false;
		}

		//.return true;
		return(count==1);
	}

	public static boolean isOperator(String op){
		if(op.equals("+") ||op.equals("-")||op.equals("*")||op.equals("/"))
			return true;

		else return false;
	}

	public static boolean isOperand(String op){

		for(char c:op.toCharArray())
		{

			if(c<'0' || c>'9'){
				return false;
			} 

		}

		return true;
	}

	/**
	 * Validation method for postfix notation.
	 *
	 * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return true if the parameter is indeed in postfix notation, and false otherwise.
	 * 
	 *time complexity:theta(n) since n * theta(1) = theta(n) where n is the number of elements.
	 * each element takes constant time to execute,
	 * push and pop and doOperation method also take theta(1) contant time.
	 * Since there are n literlas to execute, the algorithm would take thehta(n) time.
	 * As the size of the input increases, the time complexity increases aswell.
	 * 
	 * space complexity:theta(1)	fixed amount of declarations even when size of N increases.
	 * independent on size of input,N. In this case size of postfixLiterals.
	 **/
	public static boolean validatePostfixOrder(String postfixLiterals[])
	{
		int count =0;

		for(int i=0;i<postfixLiterals.length;i++){

			String currentStr =postfixLiterals[i];

			if(isOperator(currentStr)) count--;			//add one for number
			else count++;

			if(count<0) return false;						//too many operators.
		}

		
		//if(count == 1) return true;
		//else	return false;
		
		return(count==1);
	}


	//~ Evaluation  methods ..........................................................


	/**
	 * Evaluation method for prefix notation.
	 *
	 * @param prefixLiterals : an array containing the string literals in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 * 
	 * 
	 * time complexity:thetha(n) since each literal's running time is constant as 
	 * isOperand,pop and push take constant time to execute.
	 * 
	 * time complexity:theta(n) since n * theta(1) = theta(n) where n is the number of elements.
	 * each element takes constant time to execute,
	 * push and pop and doOperation method also take theta(1) contant time.
	 * Since there are n literlas to execute, the algorithm would take thehta(n) time.
	 * As the size of the input increases, the time complexity increases aswell.
	 * 
	 * 
	 * 
	 * space complexity:theta(k) where k is the number of operands in the literal array
	 *  and k<N where N is the total number of elements in the literal array.
	 * Since we are only storing operands onto the stack and not all the literals, we 
	 * are using k spaces in memmory for the stack.
	 * The rest of the variables takes constanct space regardless of size of N ie digit,num1 and num2.
	 * 
	 **/
	public static int evaluatePrefixOrder(String prefixLiterals[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		int result,num1,num2;
		//go from right to left as operands succeed operator.
		for(int i=(prefixLiterals.length-1);i>=0;i--){

			if(isOperand(prefixLiterals[i])){
				int digit = Integer.parseInt(prefixLiterals[i]);
				stack.push(digit);	
			}

			else{			//an operator

				num1= stack.pop();
				num2 =stack.pop();
				result = doOperation(num1,num2,prefixLiterals[i]);
				stack.push(result);
			}


		}

		result = stack.pop();
		return result;

	}


	/**
	 * Evaluation method for postfix notation.
	 *
	 * @param postfixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 * 
	 * time complexity:thetha(n) since each literal's running time is constant as are
	 * isOperand,pop and push take constant time to execute.
	 * 
	 * each literal takes constant running time.
	 * theta(n) since n * theta(1) = theta(n) where n is the number of elements.
	 * 
	 * each element takes constant time to execute as push and pop and simple calculations(such as +,*..)
	 * take constant time
	 * 
	 * space complexity:theta(k) where k is the number of operands in the literal array
	 *  and k<N where N is the total number of elements in the literal array.
	 * Since we are only storing operands onto the stack and not all the literals, we 
	 * are using k spaces in memmory for the stack.
	 * The rest of the variables takes constanct space regardless of size of N ie digit,num1 and num2.
	 * 
	 * 
	 **/
	public static int evaluatePostfixOrder(String postfixLiterals[])
	{

		Stack<Integer> stack = new Stack<Integer>();
		int result;
		for(int i=0;i<postfixLiterals.length;i++){
			String currentStr =postfixLiterals[i];
			int num1=0;
			int num2=0;
			if(!isOperator(currentStr)){				//if not operator then is an operand.

				int digit= Integer.parseInt(currentStr);
				stack.push(digit);

			} 
			//take 2 most recent elements from stacks.
			else{		
				num2 = stack.pop();
				num1 = stack.pop();
				
				result = doOperation(num1,num2,currentStr);
				stack.push(result);

			}


		}

		//if done correcly only one element shall be in the stack>which will be the result.
		result = stack.pop();
		return result;

	}

	private static int doOperation(int num1, int num2, String currentStr) {

		int result;
		switch(currentStr){

		case "+":
			return result = num1+num2;

		case "-":
			return result = num1-num2;

		case "*":
			return result = num1*num2;

			
		default:
			return result = num1/num2;

		}

	}




	//~ Conversion  methods ..........................................................




	/**
	 * Converts prefix to postfix.
	 *
	 * @param prefixLiterals : an array containing the string literals in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in postfix order.
	 * 
	 * 
	 * time complexity:theta(n) where n is the number of elements in prefixLiterals
	 * each element takes constant time to execute as there are constant numbers of operations and 
	 * no inner loops inside the for loop so theta(1).
	 * the for loop iterates through n elements therefore n*theta(1) = theta(n)
	 * 
	 * space complexity(k) where k is number of elements stored in the stack,
	 *  k<N where N is the total number of elements in the literal array.
	 *  the amount of space that stack uses can never exceed N spaces, where N is the number of
	 *  literals in the array.
	 *  
	 * stack stores the operands and concatentates the top two elements on the stack when 
	 * an operator is found.
	 * The rest of the variables takes constant space regardless of size of N such as str1,str2 and res;
	 * 
	 **/
	public static String[] convertPrefixToPostfix(String prefixLiterals[])
	{
		Stack<String> stack = new Stack<String>();
		String str1,str2,res = null;		
		String str;
		for(int i=(prefixLiterals.length-1);i>=0;i--){
			str = prefixLiterals[i];			//String str

			if(isOperand(str)){
				stack.push(str);
			}


			else{		
				str1 = stack.pop();
				str2 = stack.pop();
				res=new String(str1+" ");
				res = res.concat(str2+" ");
				res = res.concat(str);
				stack.push(res);
			}



		}


		String result = stack.pop();

		String[] resultArray = result.split(" ");


		for(int j=0;j<resultArray.length;j++){
			resultArray[j] = resultArray[j].trim();

		}

		return resultArray;


	}


	/**
	 * Converts postfix to prefix.
	 *
	 * @param prefixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in prefix order.
	 * 
	 *  time complexity:theta(n) where n is the number of elements in postfixLiterals
	 * each element takes constant time to execute, theta(1)
	 * the for loop iterates through n elements therefore n*theta(1) = theta(n)
	 * 
 	 *	space complexity(k) where k is number of elements stored in the stack,
	 *  k<N where N is the total number of elements in the literal array.
	 *  the amount of space that stack uses can never exceed N spaces, where N is the number of
	 *  literals in the array.
	 *  
	 * stack stores the operands and concatentates the top two elements on the stack when 
	 * an operator is found.
	 * The rest of the variables takes constant space regardless of size of N such as str1,str2 and res;
	 * 

	 * 
	 **/
	public static String[] convertPostfixToPrefix(String postfixLiterals[])
	{
		Stack<String> stack = new Stack<String>();
		String str1,str2,res = null;

		for(int i=0;i<postfixLiterals.length;i++){

			String str = postfixLiterals[i];

			if(isOperand(str)){

				stack.push(str);

			}


			else{		//is an operator.

				str1 = stack.pop();
				str2 = stack.pop();

				res=new String(str+" ");
				res = res.concat(str2+" ");
				res = res.concat(str1);

				stack.push(res);
			}


		}

		String result = stack.pop();

		String[] resultArray = result.split(" ");

		return resultArray;


	}

	/**
	 * Converts prefix to infix.
	 *
	 * @param infixLiterals : an array containing the string literals in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 * 
	 * 
	 * time complexity:theta(n) where n is the number of elements in the array Literals.
	 * each element takes constant time to execute, theta(1)
	 * the for loop iterates through n elements therefore n*theta(1) = theta(n)
	 * 
	  space complexity(k) where k is number of elements stored in the stack,
	 *  k<N where N is the number of elements in the array.
	 * stack stores the operands and concatentates the top two elements on the stack when 
	 * an operator is found.
	 * The rest of the variables takes constant space regardless of size of N such as str1,str2,res and literal;

	 * 
	 **/
	public static String[] convertPrefixToInfix(String prefixLiterals[])
	{

		Stack<String> operands = new Stack<String>();
		String str1,str2,res,literal = null;

		//(((1-2)*3)+(10-(3+(6/3))))
		for(int i= prefixLiterals.length-1;i>=0;i--){
			literal = prefixLiterals[i];

			if(!isOperator(literal)){

				operands.push(literal);		
			}

			else{			//and operatorss

				str1 = operands.pop();
				str2 = operands.pop();
				res=new String("("+ " ");
				res = res.concat(str1+" ");
				res = res.concat(literal+" ");
				res = res.concat(str2+" ");
				res = res.concat(")");

				operands.push(res);

			}

		}


		String result = operands.pop();
		String[] restultArr = result.split(" ");

		return restultArr;

	}

	/**
	 * Converts postfix to infix.
	 *
	 * @param infixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 * 
	 *  * time complexity:theta(n) where n is the number of elements in the array Literals.
	 * each element takes constant time to execute, theta(1)
	 * the for loop iterates through n elements therefore n*theta(1) = theta(n)
	 * 
	  space complexity:	theta(k) where k is number of elements stored in the stack,
	 *  k<N where N is the number of elements.
	 *  
	 * stack stores the operands and concatentates the top two elements on the stack when 
	 * an operator is found. The program only takes k spaces and the stack will never exceed 
	 * N spaces in the stack since whenever we find an operator we immediately pop the two most
	 * recent elements from the stack and cocatenate them and push them onto the stack as one.
	 * The rest of the variables takes constant space regardless of size of N such as str1,str2,res and literal;
	 * 
	 **/
	public static String[] convertPostfixToInfix(String postfixLiterals[])
	{
		Stack<String> operands = new Stack<String>();
		String str1,str2,res,literal = null;

		for(int i=0;i<postfixLiterals.length;i++){
			literal = postfixLiterals[i];

			if(!isOperator(literal)){

				operands.push(literal);		
			}

			else{			//an operator

				str2 = operands.pop();
				str1 = operands.pop();
				res=new String("("+" ");
				res = res.concat(str1+" ");
				res = res.concat(literal+" ");
				res = res.concat(str2+" ");
				res = res.concat(")");

				operands.push(res);

			}
		}

		String result = operands.pop();
		String[] restultArr = result.split(" ");

		return restultArr;

	}



	/**
	 * ------------------LIST OF DATA STRUCTURES USED----------------------------------------
	 * 1) Stack
	 *	methods of stack used:
	 *	1)push
	 *	running time:theta(1) takes constant time to push the element onto the top of the stack.
	 *	2)pop
	 *	running time:thetha(1) takes constant time to retrieve the top element as it is a LIFO stucure
	 **/


}
