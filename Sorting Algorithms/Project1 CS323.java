import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Project1_CS323 {
	
	private static void swap(int[] a, int i, int j) {
	      int temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
	   }
	
	//Bubble Sort
	//https://www.geeksforgeeks.org/bubble-sort/
	private static int bubbleSort(int arr[]) { 
        int n = arr.length; 
        int compCount = 0;
        int swapCount = 0;
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) {
            	compCount++;
                if (arr[j] > arr[j+1]) { 
                	swap(arr, j, j+1); 
                	swapCount++;
                	} 
                }
        System.out.print(swapCount + ", ");
        return compCount; 
    } 

	//Selection Sort
	//https://www.geeksforgeeks.org/selection-sort/
	public static int selectionSort(int[] arr) {
        int compCount = 0;
        int swapCount = 0;
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) {
            	compCount++;
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
            }
            swap(arr, min_idx, i);
            swapCount++;
        } 
        System.out.print(swapCount + ", ");
		return compCount;
  	}
	
	//Insertion Sort
	//https://www.geeksforgeeks.org/insertion-sort/
	private static int insertionSort(int arr[]) { 
        int n = arr.length; 
        int compCount = 0;
        int swapCount = 0;
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                compCount++;
                swapCount++;
                j = j - 1; 
                } 
            arr[j + 1] = key; 
            compCount++;
        }
        System.out.print(swapCount + ", ");
        return compCount;
    } 
	
	//https://www.geeksforgeeks.org/comb-sort/
	public static int getNextGap(int gap) { 
        // Shrink gap by Shrink factor 
        gap = (gap*10)/13; 
        if (gap < 1) 
            return 1; 
        return gap; 
    } 
	
	public static int Combsort(int arr[]) { 
		int n = arr.length; 
		int compCount = 0;
		int swapCount = 0;
        // initialize gap 
        int gap = n; 
  
        // Initialize swapped as true to make sure that 
        // loop runs 
		boolean swapped = true; 
		swapCount++;
  
        // Keep running while gap is more than 1 and last 
        // iteration caused a swap 
        while (gap != 1 || swapped == true) 
        { 
			compCount++;
            // Find next gap 
			gap = getNextGap(gap); 
		
  
            // Initialize swapped as false so that we can 
            // check if swap happened or not 
			swapped = false; 
			swapCount++;
  
            // Compare all elements with current gap 
			for (int i=0; i<n-gap; i++) 
            { 
				
				
                if (arr[i] > arr[i+gap]) 
                {
					
                    // Swap arr[i] and arr[i+gap] 
                    int temp = arr[i]; 
                    arr[i] = arr[i+gap]; 
					arr[i+gap] = temp; 
					
  
                    // Set swapped 
					swapped = true; 
					swapCount++;
                } 
            } 
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
		int n = 1000;	//change value of n
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
			int y = insertionSort(anArray);	//call the sort function here
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
