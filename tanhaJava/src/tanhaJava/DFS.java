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
class DFS
{ 
	private int V; // No. of vertices
        public ArrayList <Integer> data = new ArrayList();
	public void DFSUtil(int v,boolean visited[]) 
	{ 
		visited[v] = true; 
		System.out.print(v+" ");
                data.add(v);
                ArrayList<Integer> list = null;
                for(Node circle :panel.circleList){
                    if(circle.Name==v)
                    {
                        list =circle.connection;
                    }
                }
                for(int i=0 ; i<list.size();i++){             
                    if (!visited[list.get(i)]) 
                    { 
                        visited[list.get(i)] = true; 
                        DFSUtil(list.get(i),visited);
                    } 
                } 
 
	} 
	public ArrayList <Integer> DFSFunction() 
	{ 
		boolean visited[] = new boolean[panel.circleList.size()+1];  
		for (int i=0; i<panel.circleList.size();i++){
                     if (visited[i] == false){
                             DFSUtil(panel.circleList.get(i).Name, visited);
                     } 
                }
              	return data;				 
	} 

//	public static void main(String args[]) 
//	{ 
//		DfsGraph g = new DfsGraph(4); 
//
//		g.addEdge(0, 1); 
//		g.addEdge(0, 2); 
//		g.addEdge(1, 2); 
//		g.addEdge(2, 0); 
//		g.addEdge(2, 5); 
//		g.addEdge(3, 3); 
//
//		System.out.println("Following is Depth First Traversal"); 
//
//		g.DFS(); 
//	} 
} 
// This code is contributed by Aakash Hasija 
