package Principal;
import java.io.*;
import java.util.*;

public class Principal {
	static int numeros;
public static void main(String[] args) {
	int op = 0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Ingrese la cantidad de numeros para el archivo");
	int numeros = sc.nextInt();
	String ruta = "C:\\Users\\Javier Cotto\\Desktop\\UVG Trabajos\\3er Semestre\\Estructura de datos\\HojDeTrabajo2.0\\HDT3\\src\\sorting.txt";;
	File archivo = new File(ruta);
	BufferedWriter bw;BufferedReader fr;
	Comparable[] valores = new Comparable[3000];
	try{
		bw = new BufferedWriter(new FileWriter(archivo));
		for (int i=0;i<numeros;i++){
			int numero = (int)(Math.random() * 100) + 1;
			bw.write(numero+"\n");
			valores[i]= numero;
			}
		bw.close();
		}catch(Exception e){
			System.out.print("Hubo un error");
		}
	while(op<6) {
		System.out.println("------Menu------");
		System.out.println("1.	Selection Sort");
		System.out.println("2.	Merge Sort");
		System.out.println("3.	Quick Sort");
		System.out.println("4.	Radix Sort");
		System.out.println("5.	Sort Aleatorio");
		System.out.println("Sort a utilizar");
		op = sc.nextInt();
		sc.nextLine();

		switch(op) {
		case 1:
			Sorts.SelectionSort(valores);
			break;
		case 2:
			Sorts.mergeSort(valores);
			break;
		case 3:
			Sorts.quickSort(valores);
			break;
		case 4:
			Sorts.Radixsort(valores);
			break;
		case 5:
			//Sorts.SortAleatorio();
			break;
		}
		}
}
public static int getNumeros() {
	return numeros;
}
public void setNumeros(int numeros) {
	this.numeros = numeros;
} 
}
