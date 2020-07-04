import java.io.*; 
import java.util.*; 
import java.io.*; 
import java.util.*; 
  
public class radixSort { 
    static int compCount = 0;
    static int swapCount = 0;
    // A utility function to get maximum value in arr[] 
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
            compCount++;
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
          
            
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
            compCount++;
            swapCount++;

    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static int radixSort(int arr[]) 
    { 
        // Find the maximum number to know number of digits 
    	int n = arr.length;
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
            compCount++;
            swapCount++;
            System.out.print(swapCount + ", ");
        return compCount;
    }
    
    public static int randomFill(){

        Random rand = new Random();
        int randomNum = rand.nextInt(10000);
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
          int n = 100000;
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
                int y = radixSort(anArray);	
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
