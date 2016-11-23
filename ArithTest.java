//package algoBonus;


import static org.junit.Assert.*;

import org.junit.Test;

public class ArithTest {

	@Test
	public void validatePostfixOrder(){
		
		String[] array = {"1","2","+","3","*","6","+","2","3","+","/"};
		 String [] arr = {"7", "8","3","*","28", "+","+"};
		 String[] a = {"-","+","7","8"};
		assertEquals(true,Arith.validatePostfixOrder(array));
		assertEquals(true,Arith.validatePostfixOrder(arr));
		assertEquals(false,Arith.validatePostfixOrder(a));
	}
	
	
	@Test
	public void validatePrefixOrder(){
		//(* A (+ B (/ C D) ) )---> * A + B / C D
		String[] array = {"*","1","+","2","/","3","4"};
		assertEquals(true,Arith.validatePrefixOrder(array));
		//(/ (* A (+ B C) ) D)	-->	/ * A + B C D
		String[] array2 = {"/","*","1","+","2","3","4"};
		assertEquals(true,Arith.validatePrefixOrder(array2));
		
		String[] array3 = {"/","*","-","1","+","2","3","4"};
		assertEquals(false,Arith.validatePrefixOrder(array3));
		
		
		String[] array4 = {"+","2","3","-","4"};
		assertEquals(false,Arith.validatePrefixOrder(array4));

		String[] array5 = {"-","1","/","2","/","*","3","4","5"};
		assertEquals(true,Arith.validatePrefixOrder(array5));


	}
	

	@Test
	public void evaluatePrefixOrder(){
		Arith arith = new Arith();
		
				String[] array2 ={"-","+","*","2","3","*","5","4","9"};
				assertEquals("evaluate prefix order",17,Arith.evaluatePrefixOrder(array2));
				
				String[] array = {"/","10","5"};
				assertEquals("evaluate division",2,Arith.evaluatePrefixOrder(array));

				String[] arr = {"*","3","-","2","6"};
				assertEquals("evaluate prefix order",-12,Arith.evaluatePrefixOrder(arr));
				
		
				
				
	
	}
	
	@Test
	public void evaluatePostfixOrder(){
		
		//String[] array= {"4","5","+","3","*","7"};
		//assertEquals(20,Arith.evaluatePostfixOrder(array));
		String[] array = {"2","10","+","9","6","-","/"};
		assertEquals(4,Arith.evaluatePostfixOrder(array));
		
		
		String[] array2 = {"4","5","+","7","2","-","*"};
		assertEquals(45,Arith.evaluatePostfixOrder(array2));

	}
	
	@Test
	public void convertPrefixtoPostfix(){
		String[] prefix = {"*","+","1","2","-","3","4"};
		String[]postfix = {"1","2","+","3","4","-","*"};
		assertArrayEquals("convert prefix to postfix",postfix,Arith.convertPrefixToPostfix(prefix));
			
		System.out.println("prefix length"+prefix.length);
		System.out.println("postfix length" + postfix.length);
		
		
		
		String[] prefix2 = {"+","*","1","2","/","3","4"};
		String[] postfix2 = {"1","2","*","3","4","/","+"};
		assertArrayEquals("convert prefix to postfix",postfix2,Arith.convertPrefixToPostfix(prefix2));
		assertEquals(postfix2.length,Arith.convertPrefixToPostfix(prefix2).length);
	}
	
	
	@Test
	public void convertPostfixtoPrefix(){
		
		String[] postfix2 = {"1","2","+","3","4","+","*"};
		String[] prefix2 = {"*","+","1","2","+","3","4"};
		assertArrayEquals("convert postfix to prefix",prefix2,Arith.convertPostfixToPrefix(postfix2));
		System.out.println("prefix length"+prefix2.length);
		System.out.println("postfix length" + postfix2.length);
		assertEquals(postfix2.length,Arith.convertPostfixToPrefix(postfix2).length);
	}
	
	
	@Test
	public void PrefixtoInfix(){
		
		String[] infix = { "(","(" ,"1" ,"*" ,"2",")" ,"+","(","3" ,"/" ,"4",")",")"};
		String[] prefix = {"+","*","1","2","/","3","4"};
		assertArrayEquals(infix,Arith.convertPrefixToInfix(prefix));
		
		String[] prefix4={ "+", "*", "-", "1", "2", "3", "-","10", "+", "3", "/", "6","3" }; 
		String[] infix4= { "(","(","(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10", "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")", ")"} ;
		
		assertArrayEquals(infix4,Arith.convertPrefixToInfix(prefix4));
		
		String[] prefix2 = {"*","1","+","2","/","3","4"};
		String[] infix2 = {"(","1", "*","(","2" ,"+" ,"(" ,"3" ,"/","4" ,")" ,")" ,")"	};
		assertArrayEquals(infix2,Arith.convertPrefixToInfix(prefix2));
		
		String[] prefix3 = {"/","-","1","2","+","-","3","4","5"};
		String[] infix3 = {"(","(","1","-","2",")","/","(","(","3","-","4",")","+","5",")",")"};
		assertArrayEquals(infix3,Arith.convertPrefixToInfix(prefix3));
			
		
	}
	
	@Test
	public void PostfixtoInfix(){
		
		String[] infix = {"(","(" ,"1" ,"*" ,"2",")" ,"+","(","3" ,"/" ,"4",")",")"};
		String[] postfix3= {"1", "2", "*" ,"3" ,"4", "/" ,"+"};		
		assertArrayEquals(infix,Arith.convertPostfixToInfix(postfix3));
		System.out.println("length"+infix.length);
		
		assertEquals(infix.length,Arith.convertPostfixToInfix(postfix3).length);
		
	}
	

}
