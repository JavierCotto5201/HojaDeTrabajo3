import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Sorts {
	public static int[] valor = new int[10];
	public static int[] valor1 = new int[10];
	public static int[] valor2 = new int[10];
	public static int[] valor3 = new int[10];
	public static int[] valor4 = new int[10];
	public static int[] valor5 = new int[10];
	public static int a, b, c, d, e, f, g, h, i, j;
	static Random rndm = new Random();
	static int cont=0;
	int op=0;
	
	//Metodo llenar archivo
	public static void LlenarArchivo() {
		try {
            String ruta = "C:\\Users\\Javier Cotto\\Desktop\\UVG Trabajos\\3er Semestre\\Estructura de datos\\sorting.txt";
            for(int i = 0; i < 10; i = i + 1) {
            	int v1 = rndm.nextInt(20);
            	valor[i]=v1;
            	valor1[i]=v1;
            	valor2[i]=v1;
            	valor3[i]=v1;
            	valor4[i]=v1;
            	valor5[i]=v1;
            }
            while(cont<10) {
            String contenido = String.valueOf(valor[cont]);
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido + "\n");
            bw.close();
            cont+=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//Metodo Selection
	public static void SelectionSort() {
		int n = valor1.length; 
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (valor1[j] < valor1[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = valor1[min_idx]; 
            valor1[min_idx] = valor1[i]; 
            valor1[i] = temp;
            System.out.println(valor1[i]);
            }
    	}   
	
	//Metodo Merge
	public static void MergeSort() {
		
		}
	
	public static void sort(int valor2[], int left, int right){
	    if(left < right){
	      //Encuentra el punto medio del vector.
	      int middle = (left + right) / 2;
	      
	      //Divide la primera y segunda mitad (llamada recursiva).
	      sort(valor2, left, middle);
	      sort(valor2, middle + 1, right);

	      //Une las mitades.
	      merge(valor2, left, middle, right);
	    }
	}

	public static void merge(int valor2[],int left, int middle, int right) {
		  //Encuentra el tamaño de los sub-vectores para unirlos.
		  int n1 = middle - left + 1;
		  int n2 = right - middle;

		  //Vectores temporales.
		  int leftArray[] = new int [n1];
		  int rightArray[] = new int [n2];

		  //Copia los datos a los arrays temporales.
		  for (int i=0; i < n1; i++) {
		    leftArray[i] = valor2[left+i];
		  }
		  for (int j=0; j < n2; j++) {
		    rightArray[j] = valor2[middle + j + 1];
		  }
		  /* Une los vectorestemporales. */

		  //Índices inicial del primer y segundo sub-vector.
		  int i = 0, j = 0;

		  //Índice inicial del sub-vector arr[].
		  int k = left;

		  //Ordenamiento.
		  while (i < n1 && j < n2) {
		    if (leftArray[i] <= rightArray[j]) {
		      valor2[k] = leftArray[i];
		      i++;
		    } else {
		        valor2[k] = rightArray[j];
		        j++;
		    }
		    k++;
		  }//Fin del while.

		  /* Si quedan elementos por ordenar */
		  //Copiar los elementos restantes de leftArray[].
		  while (i < n1) {
		    valor2[k] = leftArray[i];
		    i++;
		    k++;
		  }
		  //Copiar los elementos restantes de rightArray[].
		  while (j < n2) {
		    valor2[k] = rightArray[j];
		    j++;
		    k++;
		  }
		}

	public static void printArray(int valor2[]) {
        int n = valor2.length;
        for (int i=0; i<n; ++i) {
            System.out.println(valor2[i] + " ");
        }
        System.out.println();
    }
	
	//Metodo Quick
	 public static void QuickSort() {
		 quicksort(valor3, b, c);
	 }

	public static void quicksort(int valor3[], int izq, int der) {
		 int pivote=valor3[izq]; // tomamos primer elemento como pivote
		  int i=izq; // i realiza la búsqueda de izquierda a derecha
		  int j=der; // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i<j){            // mientras no se crucen las búsquedas
		     while(valor3[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
		     while(valor3[j]>pivote) j--;         // busca elemento menor que pivote
		     if (i<j) {                      // si no se han cruzado                      
		         aux= valor3[i];                  // los intercambia
		         valor3[i]=valor3[j];
		         valor3[j]=aux;
		     }
			   	System.out.println(valor3[j]);
		   }
		   valor3[izq]=valor3[j]; // se coloca el pivote en su lugar de forma que tendremos
		   valor3[j]=pivote; // los menores a su izquierda y los mayores a su derecha
		   if(izq<j-1)
		      quicksort(valor3,izq,j-1); // ordenamos subarray izquierdo
		   if(j+1 <der)
		      quicksort(valor3,j+1,der); // ordenamos subarray derecho
	}
	//Metodo Radix
	public static void RadixSort() {
		class Radix_Sort {
			// The main function to that sorts arr[] of size n using 
		    // Radix Sort 
		    void radixSort(int valor4[], int n) 
		    { 
		        // Find the maximum number to know number of digits 
		        int m = getMax(valor4, n); 
		  
		        // Do counting sort for every digit. Note that instead 
		        // of passing digit number, exp is passed. exp is 10^i 
		        // where i is current digit number 
		        for (int exp = 1; m/exp > 0; exp *= 10) 
		            countSort(valor4, n, exp); 
		    } 
		    
		 // A utility function to get maximum value in arr[] 
		    int getMax(int valor4[], int n) 
		    { 
		        int mx = valor4[0]; 
		        for (int i = 1; i < n; i++) 
		            if (valor4[i] > mx) 
		                mx = valor4[i]; 
		        return mx; 
		    } 
		  
		    // A function to do counting sort of arr[] according to 
		    // the digit represented by exp. 
		    void countSort(int valor4[], int n, int exp) 
		    { 
		        int output[] = new int[n]; // output array 
		        int i; 
		        int count[] = new int[10]; 
		        Arrays.fill(count,0); 
		  
		        // Store count of occurrences in count[] 
		        for (i = 0; i < n; i++) 
		            count[ (valor4[i]/exp)%10 ]++; 
		  
		        // Change count[i] so that count[i] now contains 
		        // actual position of this digit in output[] 
		        for (i = 1; i < 10; i++) 
		            count[i] += count[i - 1]; 
		  
		        // Build the output array 
		        for (i = n - 1; i >= 0; i--) 
		        { 
		            output[count[ (valor4[i]/exp)%10 ] - 1] = valor4[i]; 
		            count[ (valor4[i]/exp)%10 ]--; 
		        } 
		  
		        // Copy the output array to arr[], so that arr[] now 
		        // contains sorted numbers according to curent digit 
		        for (i = 0; i < n; i++) 
		            valor4[i] = output[i]; 
		    } 
		}
	}
	public static void SortAleatorio() {
		
	}
}
