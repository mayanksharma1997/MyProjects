import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class heapSort {
    private static int compCount;
    private static int swapCount;


    public static int sort(int[] array) {
    	compCount = 0;
        swapCount = 0;
        int length = array.length;
        buildMaxHeap(array, length);
        for(int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, 1, i);
            swapCount++;
        	}
        System.out.print(swapCount + ", ");
        return compCount;
        }

    private static  void buildMaxHeap(int[] array, int heapSize) {
        if(array == null) {
            throw new NullPointerException("null");
        	}
        if(array.length <=0 || heapSize <= 0) {
            throw new IllegalArgumentException("illegal");
        	}
        if(heapSize > array.length) {
            heapSize = array.length;
        	}
        for(int i = heapSize/2; i > 0; i--) {
            maxHeapify(array, i, heapSize);
        	}
    	}

    private static void maxHeapify(int[] array, int index, int heapSize) {
        int l = index * 2;
        int r = l + 1;
        int largest;
        if(l <= heapSize && array[l - 1] > array[index - 1]) {
            largest = l;
            } else {
            	largest = index;
            	}
        if(r <= heapSize && array[r - 1] > array[largest - 1]) {
        	largest = r;
        	}
        if(largest != index) {
            int temp = array[index - 1];
            array[index - 1] = array[largest - 1];
            array[largest - 1] = temp;
            maxHeapify(array, largest, heapSize);
            swapCount++;
        	}
        compCount++;
        }
    
    public static int randomFill(){
        Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
        }
   
   public static boolean isSorted(int[] data) {
	   for(int i = 1; i < data.length; i++) {
		   if(data[i-1] > data[i]) {
			   return false;
			   }
		   }
	   return true;
	   }
   
   public static void main(String[] args) {
	   int n = 100000;		//change value of n
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
           int y = sort(anArray);	//Heap Sort called here
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
