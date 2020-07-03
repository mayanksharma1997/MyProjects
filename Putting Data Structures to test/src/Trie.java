
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Trie data structure implemented like a search engine so if you enter a prefix the functions inside the tree
return all the words in the tree that contain that prefix. If you have Go, it will return google.*/

class TrieNode{
	String prefix;//contains the word up to this far in the tree so if your at node c but c's parents are a and b then the prefix should be abc.
	boolean isWord;//want to know if the current node is a word
	String actualWord="";
	HashMap<Character,TrieNode> children;
	TrieNode(String prefix){
		children = new HashMap<>();
		this.prefix = prefix;
	}
}
class TrieTree{
	TrieNode trie;
	TrieTree(){
		trie = new TrieNode("");
	}
	int numOfComparisonsToInsert = 0;
	int searchComparisons = 0;
	long timeComplete = 0;
	public void insertWord(String s){
		TrieNode temp = trie;
		for(int i =0; i < s.length();i++){
			if(!temp.children.containsKey(s.charAt(i))){
				numOfComparisonsToInsert++;
				TrieNode start = new TrieNode(s.substring(0,i+1));
				if(i==s.length()-1) {
					start.isWord = true;
				}
				temp.children.put(s.charAt(i),start);
				temp = start;
			}else{
				numOfComparisonsToInsert++;
				temp = temp.children.get(s.charAt(i));
				if(i==s.length()-1) {
					temp.isWord = true;
					temp.actualWord = s;
				}
			}
		}
	}
	

	public Boolean findWord(String word) {

		TrieNode temp = trie;

		long startTime = System.nanoTime();
		for(int i = 0; i < word.length();i++){
			System.out.print(temp.actualWord);
			searchComparisons++;
			if(temp.children.containsKey(word.charAt(i))) {
				temp = temp.children.get(word.charAt(i));
			}else if(temp.actualWord.equals(word)) {
				long endTime = System.nanoTime();
				timeComplete = endTime - startTime;

				return true;
			}else {
				long endTime = System.nanoTime();
				timeComplete = endTime - startTime;
				return false;
			}
		}
		long endTime = System.nanoTime();
		timeComplete = endTime - startTime;
		return true;

	}
	public List<String> getWordsForPrefix(String pre){
		TrieNode temp = trie;
		List<String> list = new ArrayList<>();
		for(int i = 0; i < pre.length();i++){
			if(temp.children.containsKey(pre.charAt(i))) {
				temp = temp.children.get(pre.charAt(i));
			}else {
				return list;
			}
			searchComparisons++;
		}
		toGetChildWords(list,temp);
		return list;
	}
	private void toGetChildWords(List<String> list, TrieNode curr){
		if(curr.isWord) list.add(curr.prefix);//if our word is peter and there is pet inside of our tree we want to make sure we dont add oet to the list but pettergriffin would be okay to add because we want to hint to the user if they want to type petergriffin like google search.
		searchComparisons++;
		for(Character c : curr.children.keySet()){
			//if(n.isWord) list.add(n.prefix);
			toGetChildWords(list,curr.children.get(c));
		}
	}	
}