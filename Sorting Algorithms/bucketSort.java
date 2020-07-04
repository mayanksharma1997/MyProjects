import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class bucketSort {
	static int compCount = 0;
	static int swapCount = 0;
	
	public static int bucketSort(int[] input) {
		  //get hash codes
		  final int[] code = hash(input);
		  //create and initialize buckets to ArrayList: O(n)
		  List<Integer>[] buckets = new List[code[1]];
		  for (int i = 0; i < code[1]; i++) {
			  buckets[i] = new ArrayList<Integer>();
			  compCount++;
			  }
		  //distribute data into buckets: O(n)
		  for (int i : input) {
			  buckets[hash(i, code)].add(i);
			  }
		  
		  for (List bucket : buckets) {
		      Collections.sort(bucket);
		      }
		  int ndx = 0;
		  //merge the buckets: O(n)
		  for (int b = 0; b < buckets.length; b++) {
			  for (int v : buckets[b]) {
			  compCount++;
			  swapCount++;
		      input[ndx++] = v;
		      }
			  }
		  System.out.print(swapCount + ", ");
		  return compCount;
		  }
		 
	private static int[] hash(int[] input) {
		int m = input[0];
		for (int i = 1; i < input.length; i++) {
			if (m < input[i]) {
		    m = input[i];
		    }
			}
		return new int[]{m, (int) Math.sqrt(input.length)};
		}
		 
	private static int hash(int i, int[] code) {
		return (int) ((double) i / code[0] * (code[1] - 1));
		}
		 
	public static int randomFill(){
		Random rand = new Random();
		int randomNum = rand.nextInt(100000);
		return randomNum;
		}
		   
	public static boolean isSorted(int[] data){
		for(int i = 1; i < data.length; i++){
			if(data[i-1] > data[i]){
				return false;
				}
			}
		return true;
		}
		   
	public static void main(String[] args) {
		int n = 100000;			//change value of n
		int[] anArray = new int[n];
		for(int i=0;i<anArray.length;i++) {
			anArray[i] = randomFill();
			}
		int iter = 10;
		List<Double> myList = new ArrayList<Double>();
		List<Integer> comparison = new ArrayList<Integer>();
		System.out.print("Number of Array Accesses: ");
		for(int i=0; i<iter; i++) {
			long start = System.currentTimeMillis();
			int y = bucketSort(anArray);	//call the sort here
			if (isSorted(anArray)) {
				long end = System.currentTimeMillis();
				double x = (end-start) / 1000.0;
				myList.add(x);
				comparison.add(y);
			  	}
			else System.out.println("array not sorted");
			}  
		System.out.println("\n" + "# of comparison: " + comparison);
		System.out.println("Runtime: " + myList);
		}
	}

