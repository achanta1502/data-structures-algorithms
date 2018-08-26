//@author:achanta
package assgn4;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Graph {
private int vertex;
LinkedList<Integer> adjList[];
int visited[];
Stack<Integer> s =new Stack<Integer>();

public Graph(int vertex){
	this.vertex=vertex;
	adjList=new LinkedList[vertex+1];
	for(int i=1;i<=vertex;i++){
		adjList[i]=new LinkedList<Integer>();
	}
	visited=new int[vertex+1];
	for(int i=1;i<=vertex;i++)
		visited[i]=0;
	
	
}
protected void addEdge(Graph g,int src,int dest){
	g.adjList[src].addFirst(dest);
}
protected void printGraph(Graph g){
	System.out.println("The graph");
	for(int i=1;i<=g.vertex;i++){		
		System.out.print("vertex is "+i+":");
		for(Integer j:adjList[i]){
			System.out.print("->"+j);
		}
		System.out.println();
	}

}
protected void BFS(Graph g,int src) {
	int visited[]=new int[g.vertex+1];
	for(int i=1;i<=g.vertex;i++) {
		visited[i]=0;
	}
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(src);
	visited[src]=1;
	while(q.size()!=0) {
		src=q.poll();
		System.out.print(src+"->");
		Iterator<Integer> seq=g.adjList[src].listIterator();
		while(seq.hasNext()) {
			int elem=seq.next();
			if(visited[elem]==0) {
			q.add(elem);
			visited[elem]=1;}
			
		}
	}
	System.out.print("done");
}
protected void DFS(Graph g,int v){
	g.s.push(v);
	g.visited[v]=1;
	while(g.s.size()!=0){
		int elem=g.s.pop();
		System.out.print(elem+"->");
		Iterator<Integer> iter=g.adjList[elem].listIterator();
		while(iter.hasNext()){
			int elem1=iter.next();
			//System.out.println("vertex"+elem+":"+elem1);
			if(g.visited[elem1]!=1){
				g.s.push(elem1);
				g.visited[elem1]=1;
			}
			
		}
	}System.out.print("done");
}
}
