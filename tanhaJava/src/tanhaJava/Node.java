package tanhaJava;

import java.util.ArrayList;

public class Node
{
    public static int f = 1;
    public int X,Y;
    public int Name;
    public ArrayList<Integer> connection = new ArrayList();
    public Node(int X,int Y) {
        this.X = X;
        this.Y = Y;
        this.Name = Node.f;
        Node.f +=1;      
    }
    public void AddConnection(int Name){
        this.connection.add(Name);
    }
    
}
