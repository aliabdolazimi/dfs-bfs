package tanhaJava;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS 
{ 
    public static ArrayList<Integer> handleBfs(int s){     
        boolean visited[] = new boolean[panel.circleList.size()+1]; 
        ArrayList <Integer> data = new ArrayList();
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<>(); 
  
        // Mark the current node as visited and enqueue it 
       System.out.println(s);
        visited[s]=true; 
        queue.add(s); 
        
        while (!queue.isEmpty()) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            data.add(s);
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it
            ArrayList<Integer> list = null;
            for(Node circle :panel.circleList){
                if(circle.Name==s){
                    list =circle.connection;
                }
            }
            for(int i=0 ; i<list.size();i++){
                
                if (!visited[list.get(i)]) 
                { 
                    visited[list.get(i)] = true; 
                    queue.add(list.get(i)); 
                } 
            } 
        } 
        return data;        
    }
    
}
