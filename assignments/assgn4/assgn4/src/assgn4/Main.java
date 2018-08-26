package assgn4;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph g=new Graph(10);
g.addEdge(g, 1, 2);
g.addEdge(g, 1, 1);
g.addEdge(g, 2, 4);
g.addEdge(g, 2, 5);
g.addEdge(g, 2, 8);
g.addEdge(g, 3, 10);
g.addEdge(g, 4, 5);
g.addEdge(g, 4, 9);
g.addEdge(g, 5, 6);
g.addEdge(g, 5, 8);
g.addEdge(g, 5, 7);
g.addEdge(g, 6, 7);
g.addEdge(g, 7, 8);
g.addEdge(g, 8, 1);
g.addEdge(g, 8, 6);
g.addEdge(g, 8, 10);
g.addEdge(g, 9, 2);
g.addEdge(g, 9, 3);
g.addEdge(g, 9, 9);
g.addEdge(g, 10, 1);
g.printGraph(g);
System.out.print("The BFS for the graph is: ");
g.BFS(g, 1);
System.out.println();
System.out.print("The DFS for the graph is: ");
g.DFS(g, 1);
	}

}

