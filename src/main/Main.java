package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Dijsktra;
import model.MGraph;
 
public class Main {
	
	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		
		sc = new Scanner(System.in); 
		menu();
		
			
	}

			
	private static void menu() throws IOException {
		boolean run = true;
		do {
		System.out.println("PROGRAMA APOYO INDUCCIÓN PARA ESTUDIANTES DE PREGRADO\n");
		System.out.println("Conocerás la universidad, mira los puntos más usados por los estudiantes"
		+" elije al que quieras ir, nosotros te daremos el camino más corto ;) \n");
				
		System.out.println(
				"1. Ver lista de puntos\n"+
				"2. Mostrar los caminos cortos posibles (Dijkstra)\n"+
				"3. Buscar un camino específico Floyd");
		int option= sc.nextInt();
				
		switch(option) {
			case 1:
				ShowList();
					
			break;
			case 2:
				Dijkstraa();
					
			break;
			case 3:
				Floyd();
					
			break;
			
			}
		}while(run==true);
				
	}

			
		
			private static void Dijkstraa() {
				Dijsktra djk= new Dijsktra();
				djk.createGraph();
			}

			
			
			private static void ShowList() throws IOException {
				BufferedReader br = new BufferedReader(new FileReader("src/main/puntos"));
				ArrayList<String> list = new ArrayList<String>();
				String linea = br.readLine();
				int cantidad = Integer.parseInt(linea);
			
			}
			
			
			public static void Floyd() throws IOException {
				long [][] matriz;
				FileReader fr = new FileReader("src/main/Matriz");
				BufferedReader br = new BufferedReader(fr);
				
				String linea = br.readLine();
				int longitud = Integer.parseInt(linea);
				matriz = new long[longitud][longitud];
			
				linea = br.readLine();
				int fila = 0; 
				while(linea != null) {
					
					String[] enteros = linea.split(";");
					for (int i = 0; i < enteros.length; i++)
						matriz[fila][i] = Integer.parseInt(enteros[i]);
					fila++; 
					linea = br.readLine(); 
			
				} 
				
				System.out.println("En que punto se encuentra?");
				int v1=sc.nextInt();
				System.out.println("A qué punto va?");
				int v2=sc.nextInt();
	
				MGraph ruta= new MGraph(); 
				System.out.println(ruta.algoritmoFloyd(matriz, v1,v2));
			
			}
			
	}

	  
	



