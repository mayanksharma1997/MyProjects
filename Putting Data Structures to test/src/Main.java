
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		String searchTerm = "sunshine";
		String name1 = "GERALDINE";
		String name2 = "JESSICA";
		String name3 = "ROSELYN";
		String dickens1 = "sunshine";
		String dickens2 = "kirkland";
		String dickens3 = "costco";
		PrintWriter out = new PrintWriter("outDickens4.7MItems.txt");
		File f = new File("dickens.txt");
		Scanner in = new Scanner(f);

		RedBlackBST<String, String> rbbst = new RedBlackBST();
		AVLTree<String> avltree = new AVLTree<>();
		HashTable hash = new HashTable(40000);
		TrieTree tree = new TrieTree();
		BinarySearchTree bst = new BinarySearchTree();

		ArrayList<String> small = new ArrayList<String>( Arrays.asList("Saad", "Sharma", "Estaban", "Brian", "Danish", "Austin", "Akhil", "Mike", "Chewy","Auyon","Johnny") );
		/*
		for(int i = 0; i < small.size(); i++){
			avltree.add(small.get(i));
			rbbst.put(small.get(i), small.get(i));
			hash.insert(small.get(i), i);
			tree.insertWord(small.get(i));
			bst.insert(small.get(i));
		}

		 */
		



		/*
		ArrayList<String> names = new ArrayList<String>();
		reader(names);
		//loading up big data set
		for(int i = 0; i < names.size() && i < 10000; i++) {
			avltree.add(names.get(i));
			rbbst.put(names.get(i), names.get(i));
			hash.insert(names.get(i), i);
			tree.insertWord(names.get(i));
			bst.insert(names.get(i));

		}

		 */


		//loading All names from csv to arraylist

		//Trie


		int i = 0;
		while(in.hasNext() ){
			String tok = in.next();
			rbbst.put(tok, tok);
			avltree.add(tok);
			hash.insert(tok, i);
			i++;
			tree.insertWord(tok);
			bst.insert(tok);
		}



		Boolean ff = tree.findWord(searchTerm);
		out.println("The trie took this many nano-seconds to search ->" +tree.timeComplete + " and returned " + ff + " for " + searchTerm);
		out.println("There are " + tree.numOfComparisonsToInsert + " comparisons needed to insert into the trie");
		out.println("There are " + tree.searchComparisons + " comparisons needed to search for the word ");
		out.println();
		

		int faf = hash.get(searchTerm);
		out.println("The HashTable took this many nano-seconds to search ->" + hash.timeComplete + " and returned " + faf + " for" + searchTerm);
		out.println("The hashtable took this many comparisons to search: "+hash.comparisons);
		out.println("The hashtable took this many comparisons to insert: "+ hash.insertComparisons);
		out.println();

		//BST 

		/*
		for(String w : names) {
			bst.insert(w);
		}
		*/

		Boolean hh = bst.search(searchTerm);
		out.println("The BST took this many nano-seconds to search ->" +bst.timeComplete + " and returned " + hh + " for " + searchTerm );
		//System.out.println(bst.search(names.get(4)));
		out.println("There were this many comparisons to insert in the BST ---->" +  bst.numOfComparisonsToInsert);
		out.println("There were this many comparisons in the BST ----> " + bst.searchComparisons);
		//	bst.preorder();
		out.println();

		// Data set is the entire works of Charles Dickens. Source from website for Algorithms by Sedgewick & Wayne URL: https://introcs.cs.princeton.edu/java/data/



		// adds data to AVL and RBBST

		// STOPWATCH code from the website for Algorithms by Sedgewick & Wayne URL: https://algs4.cs.princeton.edu/code/
		// modified to use nanoseconds.
		Stopwatch sw = new Stopwatch();
		// AVL SEARCH 1
		if( avltree.contains(searchTerm)){
			long timeElapsed = sw.elapsedTime();
			out.println("AVL Tree contains the data '"+searchTerm+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+avltree.countComparisons+" comparisons.");
		}else{
			long timeElapsed = sw.elapsedTime();
			out.println("AVL Tree doesn't contain the data '"+searchTerm+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+avltree.countComparisons+" comparisons.");
		}
		out.println();
		/*
		sw = new Stopwatch();
		// AVL Search 2
		if( avltree.contains(name1)){
			long timeElapsed = sw.elapsedTime();
			out.println("AVL Tree contains the data '"+name1+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+avltree.countComparisons+" comparisons.");
		}else{
			long timeElapsed = sw.elapsedTime();
			out.println("AVL Tree doesn't contain the data '"+name1+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+avltree.countComparisons+" comparisons.");
		}
		out.println();
		*/

		// adds data to Red Black BST

		//	        while(in.hasNext()){
		//	            String tok = in.next();
		//	            rbbst.put(tok, tok);
		//	        }

		// RED BLACK SEARCH 1
		sw = new Stopwatch();
		if( rbbst.contains(searchTerm)){
			long timeElapsed = sw.elapsedTime();
			out.println("Red Black BST contains the data '"+searchTerm+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+rbbst.comparisonCount+" comparisons.");
		}else{
			long timeElapsed = sw.elapsedTime();
			out.println("Red Black BST doesn't contain the data '"+searchTerm+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+rbbst.comparisonCount+" comparisons.");
		}
		out.println();
		/*
		// RED BLACK SEARCH 2
		sw = new Stopwatch();
		if( rbbst.contains(name1)){
			long timeElapsed = sw.elapsedTime();
			out.println("Red Black BST contains the data '"+name1+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+rbbst.comparisonCount+" comparisons.");
		}else{
			long timeElapsed = sw.elapsedTime();
			out.println("Red Black BST doesn't contain the data '"+name1+"'.");
			out.println("Search operation took "+timeElapsed+" nanoSeconds.");
			out.println("Search operation did "+rbbst.comparisonCount+" comparisons.");
		}

		 */


		in.close();
		out.close();
	}

	public static void reader(ArrayList<String> names) throws IOException {
		File file = new File("Popular_Baby_Names.csv"); 
		String[] filelines=new String[]{};
		List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8); 
		int x = 0;
		for (String line : lines) { 
			String[] array = line.split(","); 
			//System.out.println(array[3]);
			names.add(array[3]);
		}
		names.remove(0);
	}
}

