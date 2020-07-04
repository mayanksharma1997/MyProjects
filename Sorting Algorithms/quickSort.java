import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quickSort{
    static int compCount = 0;
    static int swapCount = 0;

    public static int quicksort(int[] a) {
          quicksort(a, 0, a.length-1);
          System.out.print(swapCount + ", ");
          return compCount;
	   }
	   
	 
	   private static void quicksort(int[] a, int low, int high) {
	      if (low >= high) return;
	      int pivotIndex = partition(a, low, high); 
	      quicksort(a, low, pivotIndex-1);            // Sort the left half
	      quicksort(a, pivotIndex+1, high);         // Sort the right half
	      
	   }

       public static int partition(int arr[], int low, int high) 
       { 
           int pivot = arr[high];  
           int i = (low-1); // index of smaller element 
           for (int j=low; j<high; j++) 
           { 
               // If current element is smaller than or 
               // equal to pivot 
               if (arr[j] <= pivot) {
                   compCount++; 
                   i++; 
     
                   // swap arr[i] and arr[j] 
                   int temp = arr[i]; 
                   arr[i] = arr[j]; 
                   arr[j] = temp; 
                    swapCount++;
                } 
           } 
     
           // swap arr[i+1] and arr[high] (or pivot) 
           int temp = arr[i+1]; 
           arr[i+1] = arr[high]; 
           arr[high] = temp; 
           swapCount++;
           return i+1; 
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
                int y = quicksort(anArray);	
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
    
