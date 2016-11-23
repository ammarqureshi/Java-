/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author Ammar Qureshi
 *
 *************************************************************************/

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;             // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key;           // sorted by key
		private Value val;         // associated data
		private Node left, right;  // left and right subtrees
		private int N;             // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() { return size() == 0; }

	// return number of key-value pairs in BST
	public int size() { return size(root); }

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	/**
	 *  Search BST for given key.
	 *  Does there exist a key-value pair with given key?
	 *
	 *  @param key the search key
	 *  @return true if key is found and false otherwise
	 */



	/**
	 *  Insert key-value pair into BST.
	 *  If key already exists, update with new value.
	 *
	 *  @param key the key to insert
	 *  @param val the value associated with key
	 */
	public void put(Key key, Value val) {
		if (val == null) { delete(key); return; }
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Tree height.
	 *
	 * Asymptotic worst-case running time using Theta notation: 
	 * thetha(n) where n is the number of keys.
	 *because if the tree is a linear chain of n keys.
	 *
	 * @return the number of links from the root to the deepest leaf.
	 *
	 * Example 1: for an empty tree this should return -1.
	 * Example 2: for a tree with only one node it should return 0.
	 * Example 3: for the following tree it should return 2.
	 *   B
	 *  / \
	 * A   C
	 *      \
	 *       D
	 */
	public int height() {
		if(isEmpty())return -1;

		return height(root);
	}

	private int height(Node node){
		//if no child
		if(node.left == null && node.right == null){
			return 0;

		}
		//if 1 child
		if(node.left == null){
			return 1 + height(node.right);	
		}
		else if(node.right == null){
			return 1 + height(node.left);
		}
		//if 2 child
		else{
			return 1 + Math.max(height(node.left),height(node.right));

		}
	}


	/**
	 * Median key.
	 * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
	 * is the element at position (N+1)/2 (where "/" here is integer division)
	 *
	 * @return the median key, or null if the tree is empty.
	 */
	//TODO fill in the correct implementation. The running time should be Theta(h), where h is the height of the tree.

	public Key median() {
		if (isEmpty()) return null;

		Node x = median(root);
		return x.key;

	}

	private Node median(Node node){
		int medianKey =(size()-1)/2;

		//	select(medianKey);

		return select(node,medianKey);
	}



	private Node select(Node node, int n){

		//	if(node== null) return null;

		int size = size(node.left);
		//in left subtree of root
		if(size>n)	return select(node.left,n);
		//right subtree of root
		else if(size<n) return select(node.right,n - size -1);
		//root == n
		else{
			return node;
		}

	}



	/**
	 * Print all keys of the tree in a sequence, in-order.
	 * That is, for each node, the keys in the left subtree should appear before the key in the node.
	 * Also, for each node, the keys in the right subtree should appear before the key in the node.
	 * For each subtree, its keys should appear within a parenthesis.
	 *
	 * Example 1: Empty tree -- output: "()"
	 * Example 2: Tree containing only "A" -- output: "(()A())"
	 * Example 3: Tree:
	 *   B
	 *  / \
	 * A   C
	 *      \
	 *       D
	 *
	 * output: "((()A())B(()C(()D())))"
	 *
	 * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 *
	 * @return a String with all keys in the tree, in order, parenthesized.
	 */
	public String printKeysInOrder() {
		StringBuilder str = new StringBuilder();
		String multiString;

		if (isEmpty()){
			return multiString="()";
		}

		else{
			StringBuilder str2 = new StringBuilder();

			str.append("(");

			str=printKeysInOrder(root.left,str);
			//str.append(root.left);

			str.append(root.key);

			str2 = printKeysInOrder(root.right,str2);
			//str.append(root.right);

			str2.append(")");
			str.append(str2);
			multiString = str.toString();
			return multiString;


		}

	}

	private StringBuilder printKeysInOrder(Node node,StringBuilder string){

		if(node == null){

			string.append("()");
			return string;
		}

		string.append("(");

		printKeysInOrder(node.left,string);
		string.append(node.key);

		printKeysInOrder(node.right,string);
		return string.append(")");

	}

	/**
	 * Pretty Printing the tree. Each node is on one line -- see assignment for details.
	 *
	 * @return a multi-line string with the pretty ascii picture of the tree.
	 */
	public String prettyPrintKeys() {
		String multiString;

		if(root==null){
			multiString =  "-null\n";
			return multiString;
		}
		StringBuffer concat = new StringBuffer();
		StringBuffer prefix = new StringBuffer();
		concat.append("-" + root.key + "\n");
		//get all the left.
		StringBuffer store = new StringBuffer();
		prefix.append(" " + "|");
		store = prettyPrintKeys(root.left,prefix,store);		//return a string buffer.
		//get all the right.
		StringBuffer prefix2 = new StringBuffer();
		prefix2.append(" " + " " );
		StringBuffer store2 = new StringBuffer();

		store2 =prettyPrintKeys(root.right,prefix2,store2);

		//concatenate the root left and right subtree.	
		concat.append(store);
		concat.append(store2);

		multiString = concat.toString();

		return multiString;

	}

	private StringBuffer prettyPrintKeys(Node node,StringBuffer prefix,StringBuffer store){
		StringBuffer p = new StringBuffer();
		if(node==null){
			//System.out.print(prefix + "-"+"null" + "\n");
			store.append(prefix + "-"+"null" + "\n");
			return store;		//return when no more childs to traverse.
		}
		//System.out.print(prefix + "-" + node.key + "\n");		//add it to store
		store.append(prefix + "-" + node.key + "\n");

		StringBuffer prefix2 = new StringBuffer(prefix);
		prefix2.append(" " +"|" );
		prettyPrintKeys(node.left,prefix2,store);

		prefix2.deleteCharAt(prefix2.length()-1);
		prefix2.append(" ");

		return prettyPrintKeys(node.right,prefix2,store);


	}


	/**
	 * Deteles a key from a tree (if the key is in the tree).
	 * Note that this method works symmetrically from the Hibbard deletion:
	 * If the node to be deleted has two child nodes, then it needs to be
	 * replaced with its predecessor (not its successor) node.
	 *
	 * @param key the key to delete
	 */
	public void delete(Key key) {

		root = delete(root,key);
	}
	private Node delete(Node x, Key key){

		if(x==null) return null;
		int cmp = key.compareTo(x.key);

		if(cmp<0) {x.left = delete(x.left,key);}

		else if(cmp>0){x.right = delete(x.right,key);}

		else{

			if(x.right == null){return x.left;}
			if(x.left == null ){return x.right;}

			Node t = x;
			x = max(t.left);			//find max
			x.left = deleteMax(t.left);
			x.right = t.right;}

		x.N = 1 + size(x.left) + size(x.right);

		return x;

	}


	//
	//	public Key max() {
	//		return max(root).key;
	//	} 

	private Node max(Node x) {
		if (x.right == null) 
			return x; 

		else                 
			return max(x.right); 
	} 



	private Node deleteMax(Node x){

		if(x.right == null) return x.left;

		x.right = deleteMax(x.right);
		x.N = 1 + size(x.left) + size(x.right);
		return x;

	}





}
