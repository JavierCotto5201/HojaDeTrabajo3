package test;

import java.util.Arrays;

public class JUnit {
	
	public int[] selectionSort(int[] random_numbers){  
        for (int i = 0; i < random_numbers.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < random_numbers.length; j++){  
                if (random_numbers[j] < random_numbers[index]){  
                    index = j; 
                }  
            }  
            int small_number = random_numbers[index];   
            random_numbers[index] = random_numbers[i];  
            random_numbers[i] = small_number;  
        }
		return random_numbers;  
    } 
	
	
	public static int[] mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return a;
	    }else {
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	    }
		return a;
	}
	
	public static void merge(
			  int[] a, int[] l, int[] r, int left, int right) {
			  
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] <= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			            a[k++] = r[j++];
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }
			}
	
	public int[] quickSort(int arr[], int low, int high) 
	  { 
	      if (low < high) 
	      { 
	          /* pi is partitioning index, arr[pi] is  
	            now at right place */
	          int pi = partition(arr, low, high); 

	          // Recursively sort elements before 
	          // partition and after partition 
	          quickSort(arr, low, pi-1); 
	          quickSort(arr, pi+1, high); 
	      }
		return arr; 
	  }
		
		int partition(int arr[], int low, int high) 
	    { 
	        int pivot = arr[high];  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	            // If current element is smaller than the pivot 
	            if (arr[j] < pivot) 
	            { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                int temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	  
	        return i+1; 
	    } 

		static int[] radixSort(int arr[], int n) 
	    { 
	        // Find the maximum number to know number of digits 
	        int m = getMax(arr, n); 
	  
	        // Do counting sort for every digit. Note that instead 
	        // of passing digit number, exp is passed. exp is 10^i 
	        // where i is current digit number 
	        for (int exp = 1; m/exp > 0; exp *= 10) 
	            countSort(arr, n, exp);
			return arr; 
	    } 
	    
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
	    } 

	    static int[] gnomeSort(int arr[], int n) 
	    { 
	        int index = 0; 
	  
	        while (index < n) { 
	            if (index == 0) 
	                index++; 
	            if (arr[index] >= arr[index - 1]) 
	                index++; 
	            else { 
	                int temp = 0; 
	                temp = arr[index]; 
	                arr[index] = arr[index - 1]; 
	                arr[index - 1] = temp; 
	                index--; 
	            } 
	        } 
	        return arr; 
	    } 
}

