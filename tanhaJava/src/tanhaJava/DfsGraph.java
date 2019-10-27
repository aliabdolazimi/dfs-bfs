/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanhaJava;


// Java program to print DFS traversal from a given given graph 
import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list 
// representation 
class DfsGraph 
{ 
	private int V; // No. of vertices 

	// Array of lists for Adjacency List Representation 
	private LinkedList<Integer> adj[]; 

	// Constructor 
	DfsGraph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 
	//Function to add an edge into the graph 
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w); // Add w to v's list. 
	} 

	// A function used by DFS 
	void DFSUtil(int v,boolean visited[]) 
	{ 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		System.out.print(v+" "); 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n,visited); 
		} 
	} 

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	void DFS() 
	{ 
		// Mark all the vertices as not visited(set as 
		// false by default in java) 
		boolean visited[] = new boolean[V]; 

		// Call the recursive helper function to print DFS traversal 
		// starting from all vertices one by one 
		for (int i=0; i<V; ++i) 
			if (visited[i] == false) 
				DFSUtil(i, visited); 
	} 

	public static void main(String args[]) 
	{ 
		DfsGraph g = new DfsGraph(4); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 5); 
		g.addEdge(3, 3); 

		System.out.println("Following is Depth First Traversal"); 

		g.DFS(); 
	} 
} 
// This code is contributed by Aakash Hasija 
