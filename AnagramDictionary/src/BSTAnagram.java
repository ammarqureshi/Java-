

import java.util.ArrayList;
import java.util.Arrays;

public class BSTAnagram extends AnagramFinder {

	BST<String,String> bst= new BST<>();



	@Override
	public void add(String word) {
		if(word==null){throw new RuntimeException("message is null");}
		
		ArrayList<String> al = new ArrayList<>();
		bst.put(sort(word),word,al);

	}

	@Override
	public String[] search(String word) {
	

		ArrayList<String> anagramList = new ArrayList<>();
		anagramList = bst.get(sort(word));


		String[] stringArray = {};

		if(anagramList !=null){
			Object[] objectArray =  anagramList.toArray();	
			stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);

		}
		return stringArray;



	}


	public String sort(String str){

		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		String sorted = new String(chars);
		return sorted;
	}


}
