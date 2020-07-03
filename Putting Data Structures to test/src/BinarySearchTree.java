

import java.util.LinkedList;
import java.util.Queue;

//import java.math.*;


class BstNode{
    String value = "";
    BstNode left = null;
    BstNode right = null;
    BstNode(String w){
        value = w;
    }
}

public class BinarySearchTree {
    BstNode root = null;
    int numOfComparisonsToInsert = 0;
	int searchComparisons = 0;
	long timeComplete = 0;
    BinarySearchTree(){
        root = null;
    }
    public void insert(String word) {
        if(root == null) {
            root = new BstNode(word);
            return;
        }
        BstNode temp = root;
        while (true) {
            if (word.compareTo(temp.value) < 0) { 
               numOfComparisonsToInsert++;
               if (temp.left != null) {
            	   temp = temp.left;
            	   numOfComparisonsToInsert++;
               }
               else { 
            	   temp.left = new BstNode(word); 
            	   numOfComparisonsToInsert++;
            	   break;
            	   
            	}
            }
            else if (word.compareTo(temp.value) > 0) { 
               numOfComparisonsToInsert++;
               if (temp.right != null) {
            	   temp = temp.right;
            	   numOfComparisonsToInsert++;
               }
               else { 
            	   temp.right = new BstNode(word);
            	   numOfComparisonsToInsert++;
            	   break;
               }
            }
            else {
            	numOfComparisonsToInsert+=2;//to get here you made two comparisons.
            	return;
            }
        }
    }
    public Boolean search( String word) {
    	long startTime = System.nanoTime();
        if(root == null) {
        	long endTime = System.nanoTime();
        	timeComplete = endTime - startTime;
        	return false;
        }
        BstNode temp = root;
        while (true) {
            if (word.compareTo(temp.value) < 0) { 
               searchComparisons+=2;
               if (temp.left != null) temp = temp.left;
               else {
               	   long endTime = System.nanoTime();
               	   timeComplete = endTime - startTime;
            	   return false;
               }
            }
            else if (word.compareTo(temp.value) > 0) {
               searchComparisons+=2;
               if (temp.right != null) temp = temp.right;
               else { 
            	   long endTime = System.nanoTime();
            	   timeComplete = endTime - startTime;
            	   return false;
               }
            }
            else {
            	searchComparisons+=2;
            	long endTime = System.nanoTime();
            	timeComplete = endTime - startTime;
            	return true;
            }
        }
    }
    
    public void preorder() {
    	BstNode temp = root;
    	preorder(temp);
    }
    public void preorder(BstNode temp) {
    	if(temp==null)return;
    	preorder(temp.left);
    	System.out.print(temp.value);
    	preorder(temp.right);
    }
    public void levelorder() {
        BstNode temp = root;
        levelorder(temp);
    }
    public void levelorder(BstNode temp) {
    	Queue<BstNode> q = new LinkedList<BstNode>();
        q.add(temp);
        while(q.isEmpty()==false){
            BstNode c = q.poll();
            System.out.println(c.value);
            if(c.left!=null)
            	q.add(c.left);
            if(c.right!=null)
            	q.add(c.right);
            
        }
    }
}

//					rapper
//				race		macbook
//			iMac	windows	linux	windows
//		macbook	macbook 
