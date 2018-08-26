package assgn5;

import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		int V = 5;  // Number of vertices in graph
        int E = 10;  // Number of edges in graph
 
        Graph graph = new Graph(V, E);
        Hashtable<Character, Integer> hash=new Hashtable<>();
        hash.put('s', 1);
        hash.put('t', 2);
        hash.put('x', 3);
        hash.put('y', 4);
        hash.put('z', 5);
        graph.edge[0].src = hash.get('s');
        graph.edge[0].dest = hash.get('t');
        graph.edge[0].weight = 6;
 
        
        graph.edge[1].src = hash.get('s');
        graph.edge[1].dest = hash.get('y');
        graph.edge[1].weight = 7;
 
        
        graph.edge[2].src = hash.get('t');
        graph.edge[2].dest = hash.get('x');
        graph.edge[2].weight = 5;
        
        graph.edge[3].src = hash.get('t');
        graph.edge[3].dest = hash.get('y');
        graph.edge[3].weight = 8;
        
        graph.edge[4].src = hash.get('t');
        graph.edge[4].dest = hash.get('z');
        graph.edge[4].weight = -5;
        
        graph.edge[5].src = hash.get('x');
        graph.edge[5].dest = hash.get('t');
        graph.edge[5].weight = -2;
        
        graph.edge[6].src = hash.get('y');
        graph.edge[6].dest = hash.get('x');
        graph.edge[6].weight = -2;
        
        graph.edge[7].src = hash.get('y');
        graph.edge[7].dest = hash.get('z');
        graph.edge[7].weight = 9;
        
        graph.edge[8].src = hash.get('z');
        graph.edge[8].dest = hash.get('x');
        graph.edge[8].weight = 7;
        
        graph.edge[9].src = hash.get('z');
        graph.edge[9].dest = hash.get('s');
        graph.edge[9].weight = 2;
        
 //graph.printGrapg(graph.edge[6]);
        if(graph.edge[6].weight==-2) {
        	System.out.println("The output for y->x = -2");
        }else {System.out.println("The output for y->x = -3");}
       graph.belmanGotdAlgo(1, graph);

	}

}
