import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mergeSort{

    static int compCount = 0;
    static int swapCount = 0;
    public static int mergeSort(int[] list) {
    	mergeSort(list, 0 ,list.length-1);
        System.out.print(swapCount + ", ");
        return compCount;
        }
    
    private static void mergeSort(int[] list, int low, int high) {
		if (low < high) {
			int mid = (low + high)/2;
			mergeSort(list,low,mid);
			mergeSort(list,mid+1,high);
			merge(list,low,high);
			}
    	}

    public static int[] copy(int[] list) {
		int[] temp = new int[list.length];
		for (int k=0; k<list.length; k++) {
 			temp[k] = list[k];
 			}
		return temp;
		}

    private static void merge(int[] list, int low, int high) {
		int[] temp = copy(list);
		int mid = (low + high)/2;
		int index1 = 0;
		int index2 = low;
		int index3 = mid + 1;
		while (index2 <= mid && index3 <= high) {
			compCount++;
			if (list[index2] < list[index3]) { 
				swapCount++;
				temp[index1] = list[index2];
				index1++;
				index2++;
				} else {
					temp[index1] = list[index3];
					swapCount++;
					index1++;
					index3++;
					}
			}
		// if there are any items left over in the first subarray, add them to
		// the new array
		while (index2 <= mid) {
			temp[index1] = list[index2];
			swapCount++;
			index1++;
			index2++;
			}
		// if there are any items left over in the second subarray, add them
		// to the new array
		while (index3 <= high) {
			temp[index1] = list[index3];
			swapCount++;
			index1++;
			index3++;
			}
		// load temp array's contents back into original array
		for (int i=low, j=0; i<=high; i++, j++) {
			list[i] = temp[j];
			swapCount++;
			}
		}

    public static int randomFill() {
    	Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
    	}
   
   public static boolean isSorted(int[] data) {
        for(int i = 1; i < data.length; i++) {
            if(data[i-1] > data[i]){
                return false;
            }
        }
        return true;
        }
   
   public static void main(String[] args) {
          int n = 100000;		//change n
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
                int y = mergeSort(anArray);		//sort called here
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
