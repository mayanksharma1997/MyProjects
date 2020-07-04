import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class countingSort {
	static int compCount = 0;
	static int swapCount = 0;
	
	//counting Sort
	//https://www.geeksforgeeks.org/counting-sort/
	public static int countSort(int[] arr) { 
		int max = Arrays.stream(arr).max().getAsInt(); 
		int min = Arrays.stream(arr).min().getAsInt(); 
		int range = max - min; 
		int count[] = new int[range]; 
		int output[] = new int[arr.length]; 
		for (int i = 0; i < arr.length; i++) { 
			count[arr[i] - min]++; 
			} 
		for (int i = 1; i < count.length; i++) { 
			count[i] += count[i - 1]; 
			compCount++;
			} 
		for (int i = arr.length - 1; i >= 0; i--) { 
			output[count[arr[i] - min] - 1] = arr[i]; 
			count[arr[i] - min]++; 
			compCount++;
			swapCount++;
			} 
		for (int i = 0; i < arr.length; i++){ 
			arr[i] = output[i]; 
			swapCount++;
			} 
		System.out.print(swapCount + ", ");
        return compCount;
	    } 
		
	public static int randomFill(){
		Random rand = new Random();
		int randomNum = rand.nextInt();
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
		int n = 10;		//change value of n
		int[] anArray = new int[n];
		for(int i=0;i<anArray.length;i++) {
			anArray[i] = randomFill();
			}
		int iter = 10;
		List<Double> myList = new ArrayList<Double>();
		List<Integer> comparison = new ArrayList<Integer>();
		System.out.print("number of array accesses: ");
		for(int i=0; i<iter; i++) {
			long start = System.currentTimeMillis();
			int y = countSort(anArray);		//call sort here
			if (isSorted(anArray)) {
				long end = System.currentTimeMillis();
				double x = (end-start) / 1000.0;
				myList.add(x);
				comparison.add(y);
				}
			else System.out.println("array not sorted");
			}
		System.out.print(swapCount + ", ");
		System.out.println("\n" + "# of comparison: " + comparison);
		System.out.println("Runtime: " + myList);
		}
	}
