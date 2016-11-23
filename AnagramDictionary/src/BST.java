
import java.util.ArrayList;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;             // root of BST

	private class Node {
		private Key key;           // sorted by key
		private Value val;         // associated data
		private Node left, right;  // left and right subtrees
		private int N;             // number of nodes in subtree
		private ArrayList<Value> al;
		public Node(Key key, Value val, int N, ArrayList<Value> al) {
			this.key = key;
			this.al = al;
			this.al = new ArrayList<Value>();
			this.val = val;
			this.al.add(this.val);
			this.N = N;
		}
	}

	/**
	 * Initializes an empty symbol table.
	 */
	public BST() {

	}


	/**
	 * Returns the value associated with the given key.
	 *
	 * @param  key the key
	 * @return the value associated with the given key if the key is in the symbol table
	 */
	public ArrayList<Value> get(Key key) {
		return get(root, key);
	}

	private ArrayList<Value> get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return  x.al;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old 
	 * value with the new value if the symbol table already contains the specified key.
	 * Deletes the specified key (and its associated value) from this symbol table
	 * if the specified value is <tt>null</tt>.
	
	 */
	public void put(Key key, Value val, ArrayList<Value> al) {
		root = put(root, key, val ,al);
	}


	private Node put(Node x, Key key, Value val, ArrayList<Value> al) {
		if (x == null) return new Node(key, val, 1 ,al);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val ,al);
		else if (cmp > 0) x.right = put(x.right, key, val,al);
		else      x.al.add(val); 

		return x;
	}




}