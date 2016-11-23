//package algorithmslab2;


//package Lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 12/10/15 20:43:36
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new DoublyLinkedList<Integer>();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the insertBefore works
	 */
	@Test
	public void testInsertBefore()
	{
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);

		testDLL.insertBefore(0,4);
		assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
		testDLL.insertBefore(1,5);
		assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
		testDLL.insertBefore(2,6);       
		assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );

		testDLL.insertBefore(-1,7);        
		assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );

		testDLL.insertBefore(7,8);        
		assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
		testDLL.insertBefore(700,9);        
		assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

		// test empty list
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);        
		assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(10,1);        
		assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(-10,1);        
		assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
	}

	// TODO: add more tests here. Each line of code in DoublyLinkedList.java should
	// be executed at least once from at least one test.



	@Test
	public void get(){
		//test a non-empty list of Strings.
		DoublyLinkedList<String> testDLL = new DoublyLinkedList<String>();
		testDLL.insertBefore(0,"hello");
		testDLL.insertBefore(1,"how");
		testDLL.insertBefore(2,"are");
		assertEquals("check  get if element added at a position is the same as element obtained at that position","hello",testDLL.get(0));
		assertEquals("check  get if element added at a position is the same as element obtained at that position","how",testDLL.get(1));
		assertEquals("check  get if element added at a position is the same as element obtained at that position","are",testDLL.get(2));

		//test on an empty list.        
		testDLL = new DoublyLinkedList<String>();
		assertEquals("check if getting an element from an empty list returns null",null,testDLL.get(0));

		//test on a non-empty list of Integers.   	
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();
		DLL.insertBefore(0, 100);
		assertEquals("100",DLL.get(0).toString());
		
		
		DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
	testDLL2.push(10);
	testDLL2.push(20);
		assertEquals(null,testDLL2.get(-1));
		assertEquals(null,testDLL2.get(10));
	
		
		

	}


	@Test
	public void deleteAt(){
		//test with an empty list.
		DoublyLinkedList<String> testDLL = new DoublyLinkedList<String>();
		assertEquals("check if element obtained is null when list is empty",false,testDLL.deleteAt(0));

		DoublyLinkedList<Integer> DLLint = new DoublyLinkedList<Integer>();
		assertEquals(false,DLLint.deleteAt(10));
		assertEquals(false,DLLint.deleteAt(-1));
		testDLL = new DoublyLinkedList<String>();
		//test with a non-empty list of strings and integers.
		testDLL.insertBefore(0,"hello");
		testDLL.insertBefore(1,"how");
		testDLL.insertBefore(2,"are");
		testDLL.insertBefore(3,"you");
		assertEquals(true,testDLL.deleteAt(0));
		assertEquals("how",testDLL.get(0));
		assertEquals(true,testDLL.deleteAt(1));
		assertEquals("you",testDLL.get(1));
		assertEquals(true,testDLL.deleteAt(1));
		assertEquals(false,testDLL.deleteAt(2));
		assertEquals(false,testDLL.deleteAt(-10));
		
		
		DoublyLinkedList<Integer> dllTest = new DoublyLinkedList<Integer>();
		dllTest.insertBefore(0, 10);
		assertEquals(false,dllTest.deleteAt(1));
		
		
		
		DoublyLinkedList<Integer> dllTest2 = new DoublyLinkedList<Integer>();
		dllTest2.insertBefore(0, 10);
		assertEquals(false,dllTest2.deleteAt(1));
		dllTest2.insertBefore(1, 20);
		assertEquals(true,dllTest2.deleteAt(1));
		
		
		dllTest2 = new DoublyLinkedList<Integer>();
		dllTest2.insertBefore(0, 100);
		dllTest2.insertBefore(1, 200);
		assertEquals(2,dllTest2.size());
		assertEquals("200",dllTest2.get(1).toString());
		assertEquals(true,dllTest2.deleteAt(1));
		assertEquals(null,dllTest2.get(1));
		assertEquals("100",dllTest2.get(0).toString());
		assertEquals(true,dllTest2.deleteAt(0));
		assertEquals(null,dllTest2.get(0));
		assertEquals(true,dllTest2.isEmpty());


	}

	@Test
	public void empty(){

		DoublyLinkedList<String> testDLL = new DoublyLinkedList<String>();

		//test with empty doubly linked list.

		assertEquals(true,testDLL.isEmpty());

		//test with non-empty doubly linked list
		testDLL.insertBefore(0,"hello");

		assertEquals(false,testDLL.isEmpty());

		//test after an elements has been deleted from the linked. list.	
		testDLL.deleteAt(0);
		assertEquals(true,testDLL.isEmpty());


	}

	@Test
	public void push(){
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();
		//test if it is a LIFO strucure.
		DLL.push(10);
		DLL.push(20);
		assertEquals("10",DLL.get(1).toString());
		assertEquals("20",DLL.get(0).toString());


	}


	@Test
	public void pop(){
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();

		DLL.push(10);
		DLL.pop();
		assertEquals(true,DLL.isEmpty());
		//DLL.pop();
		assertEquals(null,DLL.pop());
		DLL.push(100);
		DLL.push(500);
		DLL.push(200);
		 Integer value = DLL.pop();
		assertEquals("200",value.toString().toString());
		Integer value2 = DLL.pop();
		assertEquals("500",value2.toString().toString());
		Integer value3 = DLL.pop();
		assertEquals("100",value3.toString().toString());
		
	
	}


	@Test 

	public void dequeue(){
		//testing if is FIFO structure. 
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();
		//no elements in the queue at the start.
		assertEquals(true,DLL.isEmpty());
		DLL.enqueue(10);
		DLL.enqueue(20);
		assertEquals(false,DLL.isEmpty());	//implies there are elements in the queue.


		assertEquals("10",DLL.dequeue().toString());
		assertEquals("20",DLL.dequeue().toString());
		assertEquals(null,DLL.dequeue());
		assertEquals(true,DLL.isEmpty());

	}

	@Test
	public void enqueue(){
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();
		DLL.enqueue(10);
		DLL.enqueue(20);
		assertEquals("10",DLL.get(0).toString());
		assertEquals("20",DLL.get(1).toString());


	}


	@Test
	public void insertFirst(){

		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();
		DLL.insertFirst(100);
		assertEquals(false,DLL.isEmpty());
		assertEquals("100",DLL.get(0).toString());
		DLL.insertFirst(200);
		assertEquals("200",DLL.get(0).toString());
		assertEquals("check whether the element that was first before has moved to the right to accomodate for the next ","100",DLL.get(1).toString());


	}



	@Test
	public void insertLast(){
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<Integer>();
		DLL.insertLast(100);
		assertEquals("100",DLL.get(0).toString());

		//see if the new last elements has been added to position = size -1
		DLL.insertLast(200);
		assertEquals("200",DLL.get(DLL.size()-1).toString());


	}





}
