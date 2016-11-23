/******************************************************************************
 *  Compilation:  javac SeparateChainingLiteHashST.java
 *  Execution:    java SeparateChainingLiteHashST
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A symbol table implemented with a separate-chaining hash table.
 *
 *  Note 1: does not support delete().
 *  Note 2: does not do resizing.
 * 
 *  % java SeparateChainingLiteHashST < tinyTale.txt
 *
 ******************************************************************************/


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class HashTable<Key, Value> {

	private int N;       // number of key-value pairs
	private int M;       // hash table size
	private LinkedList<Value>[] st;   // array of linked-list symbol tables

	// create separate chaining hash table with M lists
	@SuppressWarnings("unchecked")
	public HashTable(int M) {
		this.M = M;

		st = new LinkedList[M];		
	} 


	// hash value between 0 and M-1
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	} 



	// return value associated with key, null if no such key
	public String[]  get(Key key) {
		int i = hash(key);
		
		String[] strArray = {};
		
		if(st[i]!=null){
		 strArray = st[i].toArray(new String[st[i].size()]);
		}
		
		return strArray;
	}

	// insert key-value pair into the table
	public void put(Key key, Value val) {

		int i = hash(key);


		if(st[i] == null)
		{
			st[i] = new LinkedList<Value>();
		}


		N++;

		st[i].add(val);

	}


}