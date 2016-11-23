

import java.util.ArrayList;
import java.util.Arrays;

public class HTAnagram extends AnagramFinder {
	HashTable<String, String> st;

//create a hash table with key and value as strings.
	public HTAnagram(){
		st = new HashTable<String, String>(400000);

	}

	@Override
	public void add(String word) {
		if(word!= null){
			String baseWord = sort(word);
			st.put(baseWord, word);
		}

		else throw new RuntimeException("value is null");
		return;
	}

	
	@Override
	public String[] search(String word) {

		//sorted word will be the key to get the values associated with it.
		return st.get(sort(word));

	}


// sorting word
	public String sort(String str){

		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		String sorted = new String(chars);
		return sorted;
	}




}
