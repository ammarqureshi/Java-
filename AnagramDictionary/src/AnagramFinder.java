
public abstract class AnagramFinder {

    public abstract void add(String word);

    public abstract String[] search(String word);

    public void createDictionary(String[] words) {
        for(String s : words){
            add(s);
        }
    }

   
}
