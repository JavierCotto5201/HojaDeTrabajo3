package Principal;
import java.util.Arrays;

public class Sorts {
	static int[] valor = new int[Principal.getNumeros()];
	/*
	 * SELECTIONSORT
	  */
		public static void SelectionSort(Comparable data[]) {
			int n = Principal.getNumeros();
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            // Find the minimum element in unsorted array 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (valor[j] < valor[min_idx]) 
	                    min_idx = j; 
	  
	            // Swap the found minimum element with the first 
	            // element 
	            int temp = valor[min_idx]; 
	            valor[min_idx] = valor[i]; 
	            valor[i] = temp;
	            System.out.println(valor[i]);
	            }
	    	}   
		/*
		 * MERGESORT
		  */
private static void merge(Comparable data[], Comparable temp[],int low, int middle, int high){
	int ri = low; 
	int ti = low; 
    int di = middle; 

    while (ti < middle && di <= high){
    	if (data[di].compareTo(temp[ti])<0) {
    		data[ri++] = data[di++]; 
    		} else {
    			data[ri++] = temp[ti++]; 
    			}
    	}
    while (ti < middle){
    	data[ri++] = temp[ti++];
    	}
    }
	 
public static void mergeSortRecursive(Comparable data[],Comparable temp[], int low, int high){
	int n = high-low+1;
    int middle = low + n/2;
    int i;
    if (n < 2) return;
    for (i = low; i < middle; i++){
    	temp[i] = data[i];
    	}
    mergeSortRecursive(temp,data,low,middle-1);
    mergeSortRecursive(data,temp,middle,high);
    merge(data,temp,low,middle,high);
    }

public static void mergeSort(Comparable data[]){
     mergeSortRecursive(data,new Comparable[data.length],0,data.length-1);
     System.out.println(data);
     }

/*
 * QUICKSORT
  */
public static void swap(Comparable data[], int i, int j){
	Comparable temp;
	temp = data[i];
	data[i] = data[j];
	data[j] = temp;
}
private static int partition(Comparable data[], int left, int right){
	while (true){
		while (left < right && data[left].compareTo(data[right]) < 0) right--;
		if (left < right) swap(data,left++,right);
		else return left;
		while (left < right && data[left].compareTo(data[right]) < 0) left++;
		if (left < right) swap(data,left,right--);
		else return right;
		}
	}

public static void quickSort(Comparable data[]){
	quickSortRecursive(data,0,data.length-1);
}

private static void quickSortRecursive(Comparable data[],int left,int right){
	int pivot; // the final location of the leftmost value
	if (left >= right) return;
	pivot = partition(data,left,right); /* 1 - place pivot */
	quickSortRecursive(data,left,pivot-1); /* 2 - sort small */
	quickSortRecursive(data,pivot+1,right);/* 3 - sort large */
}

public static void Radixsort(Comparable arr[]){
    // Find the maximum number to know number of digits
    int n = arr.length;
    Comparable m = getMax(arr, n);

    // Do counting sort for every digit. Note that instead
    // of passing digit number, exp is passed. exp is 10^i
    // where i is current digit number
    for (int exp = 1; (int)m/exp > 0; exp *= 10)
        countSort(arr, n, exp);
}
private static void countSort(Comparable arr[], int n, int exp){
    int output[] = new int[n]; // output array
    int i;
    int count[] = new int[10];
    Arrays.fill(count,0);
   
    // Store count of occurrences in count[]
    for (i = 0; i < n; i++)
        count[ ((int)arr[i]/exp)%10 ]++;

    // Change count[i] so that count[i] now contains
    // actual position of this digit in output[]
    for (i = 1; i < 10; i++)
        count[i] += count[i - 1];

    // Build the output array
    for (i = n - 1; i >= 0; i--)
    {
        output[count[ ((int)arr[i]/exp)%10 ] - 1] = (int)arr[i];
        
        count[ ((int)arr[i]/exp)%10 ]--;
    }

    // Copy the output array to arr[], so that arr[] now
    // contains sorted numbers according to curent digit
    for (i = 0; i < n; i++)
        arr[i] = output[i];
}
private static Comparable getMax(Comparable arr[], int n){
    Comparable mx = arr[0];
    for (int i = 1; i < n; i++)
        if (arr[i].compareTo(mx) > 0)
            mx = arr[i];
    return mx;
}
}
