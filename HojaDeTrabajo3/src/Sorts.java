import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Sorts {
	public static int[] valor = new int[10];
	static Random rndm = new Random();
	static int cont=0;
	int op=0;
	
	public static void LlenarArchivo() {
		try {
            String ruta = "C:\\Users\\Javier Cotto\\Desktop\\UVG Trabajos\\3er Semestre\\Estructura de datos\\sorting.txt";
            for(int i = 0; i < 10; i = i + 1) {
            	int v1 = rndm.nextInt(20);
            	valor[i]=v1;
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
	
	public static void SelectionSort() {	
		int n = valor.length; 		  
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
            
            try {
                String ruta = "C:\\Users\\Javier Cotto\\Desktop\\UVG Trabajos\\3er Semestre\\Estructura de datos\\sorting.txt";
                for(int x = 0; x < 10; x = x + 1) {
                	String contenido = String.valueOf(valor[x]);
                	cont+=1;
                File file = new File(ruta);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido + "\n");
                bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
	}
	public static void MergeSort() {
		
	}
	public static void QuickSort() {
	
	}
	public static void RadixSort() {
	
	}
	public static void SortAleatorio() {
		
	}
}
