package model;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Dijsktra {
	
	
	
	private static Scanner sc;

	// Create a new graph.
	Graph g = new Graph(50);
	
	
	public void createGraph() {
		sc = new Scanner(System.in);
		// Add the required edges.
		g.addEdge(1, 2, 1); 
		g.addEdge(2, 3, 1); g.addEdge(2, 10, 2); g.addEdge(2, 11, 3); g.addEdge(2, 39, 2);
		g.addEdge(3, 10,3); g.addEdge(3, 2, 1); 
		g.addEdge(4, 5, 2); g.addEdge(4, 7, 1);  g.addEdge(4, 11, 1);
		g.addEdge(5, 4, 2); g.addEdge(5, 6, 1); 
		g.addEdge(6, 5, 1); g.addEdge(6, 7, 1);  g.addEdge(6, 8, 2); 
		g.addEdge(7, 4, 1); g.addEdge(7, 6, 1);  g.addEdge(7, 8, 1);  g.addEdge(7, 40, 5);
		g.addEdge(8, 6, 2); g.addEdge(8, 7, 1);  g.addEdge(8, 11, 1); g.addEdge(8, 10, 2);
		g.addEdge(9, 10,1); g.addEdge(9,11, 1); 
		g.addEdge(10, 2,2); g.addEdge(10, 3 ,3); g.addEdge(10, 8 ,2); g.addEdge(10, 9 ,1); g.addEdge(10, 39 ,2); 
		g.addEdge(10,29,5); g.addEdge(10, 13,3); g.addEdge(10, 16,9); g.addEdge(10, 40 ,3);
		g.addEdge(11, 2,3); g.addEdge(11, 4, 1); g.addEdge(11, 8, 1); g.addEdge(11, 9, 1);
		g.addEdge(12, 13, 5);
		g.addEdge(13, 12, 1); g.addEdge(13,10,3); g.addEdge(13,29,2); g.addEdge(13, 14, 2);g.addEdge(13, 31, 5);
		g.addEdge(14, 13, 2); g.addEdge(14,16,3); g.addEdge(14,15,1); g.addEdge(14,22,4);
		g.addEdge(15, 14, 1); g.addEdge(15,16,1); g.addEdge(15,18,3);
		g.addEdge(16, 10, 9); g.addEdge(16,14,3); g.addEdge(16,15,1); g.addEdge(16,17,1);
		g.addEdge(17, 16, 1); g.addEdge(17,18,4); g.addEdge(17,19,5);
		g.addEdge(18, 15, 3); g.addEdge(18,17,4); g.addEdge(18,19,1);
		g.addEdge(19, 17, 5); g.addEdge(19,18,1); g.addEdge(19,20,2);
		g.addEdge(20, 21, 2); g.addEdge(20,19,2);
		g.addEdge(21, 20, 2); 
		g.addEdge(22, 14, 4); g.addEdge(22, 25, 7); g.addEdge(22,23,3);   g.addEdge(22,31,4);
		g.addEdge(23, 22, 3); g.addEdge(23, 24,2);  g.addEdge(23, 34, 3);
		g.addEdge(24, 23, 2); g.addEdge(24, 25, 1); 
		g.addEdge(25, 22, 7); g.addEdge(25, 24, 1); g.addEdge(25, 26, 4); g.addEdge(25, 28, 4);g.addEdge(25, 31, 3); g.addEdge(25,32, 4);
		g.addEdge(26, 25, 4); g.addEdge(26, 27, 1); g.addEdge(26, 28, 2); g.addEdge(26,33, 6);
		g.addEdge(27, 26, 1); 
		g.addEdge(28, 25, 4); g.addEdge(28, 26, 2); g.addEdge(28,29,5); 
		g.addEdge(29, 10, 5); g.addEdge(29,13,2);   g.addEdge(29, 28, 5); g.addEdge(29, 30, 1);
		g.addEdge(30, 29, 1); 
		g.addEdge(31, 13, 5); g.addEdge(31, 22, 4); g.addEdge(31, 25, 3);
		g.addEdge(32, 25, 4); g.addEdge(32, 33,7);  g.addEdge(32, 34, 4);
		g.addEdge(33, 32, 7); g.addEdge(33, 26, 6);
		g.addEdge(34, 23, 3); g.addEdge(34, 32, 4); g.addEdge(34, 35, 5); g.addEdge(34, 37, 8);
		g.addEdge(35, 34, 5); g.addEdge(35, 36, 1); g.addEdge(35, 37, 2); g.addEdge(35, 38, 6);
		g.addEdge(36, 35, 1); 
		g.addEdge(37, 34, 8); g.addEdge(37, 35, 2);
		g.addEdge(38, 35, 6); 
		g.addEdge(39, 2, 2);  g.addEdge(39, 10, 2);
		g.addEdge(40, 10, 3); g.addEdge(40, 7, 5);
		
		
		
		// Calculate Dijkstra.
		System.out.println("En que punto se encuentra?");
		int v1=sc.nextInt();
		
		calculate(g.getVertex(v1));	

		// Print the minimum Distance.
		System.out.println("Puntos a los que puedes llegar estando en: "+g.getVertex(v1)+"\n");
		
		for(Vertex v:g.getVertices()){
				System.out.print("Puede ir a: "+v+"\nYendo por[");
				for(Vertex pathvert:v.path) {
					System.out.print(pathvert+" ");
				}
				System.out.println(""+v+"]\n");
			}
			
	}
	




	public void calculate(Vertex source){
		// Algo:
		// 1. Take the unvisited node with minimum weight.
		// 2. Visit all its neighbours.
		// 3. Update the distances for all the neighbours (In the Priority Queue).
		// Repeat the process till all the connected nodes are visited.
		
		source.minDistance = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			
			Vertex u = queue.poll();
		
			for(Edge neighbour:u.neighbours){
				
				int newDist = (int) (u.minDistance+neighbour.weight);
				
				if(neighbour.target.minDistance>newDist){
					// Remove the node from the queue to update the distance value.
					queue.remove(neighbour.target);
					neighbour.target.minDistance = newDist;
					
					// Take the path visited till now and add the new node.s
					neighbour.target.path = new LinkedList<Vertex>(u.path);
					neighbour.target.path.add(u);
					
					//Reenter the node with new distance.
					queue.add(neighbour.target);					
				}
			}
		}
	}

}


