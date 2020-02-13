import java.io.*;
import java.util.*;

public class Principal {
	public static int op=0;
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(op!=6) {
		System.out.println("------Menu------");
		System.out.println("1.	Llenar Archivo");
		System.out.println("2.	Selection Sort");
		System.out.println("3.	Merge Sort");
		System.out.println("4.	Quick Sort");
		System.out.println("5.	Radix Sort");
		System.out.println("6.	Sort Aleatorio");
		System.out.println("Sort a utilizar");
		op = sc.nextInt();
		sc.nextLine();
		
		switch(op) {
		case 1:
			Sorts.LlenarArchivo();
			break;
		case 2:
			Sorts.SelectionSort();
			break;
		case 3:
			Sorts.MergeSort();
			break;
		case 4:
			Sorts.QuickSort();
			break;
		case 5:
			Sorts.RadixSort();
			break;
		case 6:
			Sorts.SortAleatorio();
			break;
			}
		}
    }
}
