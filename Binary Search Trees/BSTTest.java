import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author AMMAR QURESHI 14318618
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
     
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     //** <p>Test {@link BST#delete(Comparable)}.</p> *//*
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         
         
         bst = new BST<Integer, Integer>();
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         				  //			8
     
       //System.out.println(bst.printKeysInOrder());
         
         bst.delete(7);
        assertEquals("deleting parent node with only right child.",
        		"(()8())",bst.printKeysInOrder());
        
    
         
     }
     
     
     
     
     @Test
     public void TestPrintKeysInOrder(){
    	 
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         
	//call with empty tree.
    //call with root
    //call with root and childs.
         
        
         assertEquals("check for empty tre","()",bst.printKeysInOrder());
         
         bst.put(1, 1);
         assertEquals("check for only root","(()1())",bst.printKeysInOrder());
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
    	 
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
     
    	 
     }
     
     
     
     @Test
     public void TestHeight(){
    	 
    	// Example 1: for an empty tree this should return -1.
    			// * Example 2: for a tree with only one node it should return 0.
    		//	 * Example 3: for the following tree it should return 2.
    	 
    	 
         BST<Integer, Integer> bst = new BST<Integer, Integer>();

         assertEquals("return -1 for empty tree.",-1,bst.height());
    	 
         bst.put(5, 5);
         assertEquals("return 0 for tree with only one node",0,bst.height());
         
         bst.put(2, 2);				
    	 bst.put(6, 6);
    	 bst.put(7, 7);
    	 
    	/* -5
    	 |-2
    	 | |-null
    	 |  -null
    	  -6
    	   |-null
    	    -7
    	     |-null
    	      -null
    	*/
    	 
         assertEquals("return 2 for following tree",2,bst.height());
         
         
         
         bst = new BST<Integer, Integer>();
         bst.put(5, 5);
         bst.put(4, 4);
         bst.put(3, 3);
         bst.put(2, 2);
         bst.put(1, 1);
         assertEquals("test for tree with only left subtree",4,bst.height());
         
         
         
         
    	 
     }
     
     
     
     @Test
     public void TestMedian(){
    	 
         BST<String, Integer> bst = new BST<String, Integer>();
         
         assertEquals("return null when tree is empty",null,bst.median());

         bst.put("7", 7);
         bst.put ("9",9);	 //       _7_
         bst.put("8", 8);   //      /     \
         bst.put("3", 3);   //    _3_     _8_
         bst.put("1", 1);   //  /     \		 \
         bst.put("2", 2);   // 1       6	  9	
         bst.put("6", 6);   //  \     /
         bst.put("4", 4);   //   2   4
         bst.put("5", 5);   //        \
                            //         5
    	 
    	 //in an array [1 2 3 4 5 6 7 8 9]->median in this array is 5
    	// System.out.println(bst.prettyPrintKeys());
         assertEquals("return key 5 when size is 9","5",bst.median());
         
         
         
         
        //  bst = new BST<String, Integer>();
         
         

    	 
     }
     
     @Test 
     public void testPut(){
    	 
         BST<String, Integer> bst = new BST<String, Integer>();

         bst.put("10",null);    	 
    	assertEquals("empty when value is null","()",bst.printKeysInOrder());
    	
    	
         BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
         
         bst2.put(7, 7);   //        _7_
         bst2.put(8, 8);   //      /     \
         bst2.put(7, 7);	 //			   8
     
        // System.out.println("here");
        // System.out.println(bst2.prettyPrintKeys());
        // System.out.println(bst2.printKeysInOrder());
         
//         (()7(()8()))
         assertEquals("enter the root again","(()7(()8()))",bst2.printKeysInOrder());
         
    	 
     }
     
     
     
     
     
     
}
