package assgn5;

public class Graph {
class Edge{
	int src,dest,weight;
	Edge(){
		src=dest=weight=' ';
	}
};
int V,E;
Edge edge[];
Graph(int v,int e){
	V=v;
	E=e;
	edge=new Edge[e];
	for(int i=0;i<e;i++) {
		edge[i]=new Edge();
	}
}
public void printGrapg(Edge edge ) {
	System.out.print(edge.dest+" "+edge.src+" "+edge.weight);
}
public void belmanGotdAlgo(int strt,Graph graph) {
	int v=graph.V;
	int e=graph.E;
	int distArray[]=new int[v+1];
	int parArray[]=new int[v+1];
	for(int i=1;i<distArray.length;i++) {
		distArray[i]=Integer.MAX_VALUE;
	}
	for(int i=1;i<parArray.length;i++) {
		parArray[i]=0 ;
	}
	distArray[strt]=0;
	for(int i=1;i<v;i++) {
		for(int j=0;j<e;j++) {
			int src=graph.edge[j].src;
			int dest=graph.edge[j].dest;
			int weight=graph.edge[j].weight;
			if(distArray[src]!=Integer.MAX_VALUE && distArray[src]+weight<distArray[dest]) {
				distArray[dest]=distArray[src]+weight;
				parArray[dest]=src;}
		}
	}
	int neg=0;
	for(int j=0;j<e;j++) {
		int src=graph.edge[j].src;
		int dest=graph.edge[j].dest;
		int weight=graph.edge[j].weight;
		if(distArray[src]!=Integer.MAX_VALUE && distArray[src]+weight<distArray[dest]) {
			neg=1;
	}}
	 if(neg==0) {
	printDistAndParent(distArray, parArray);}
	 else {System.out.println("Graph contains negative weight cycles. There can't be any shortest path.");
	 }
}
public void printDistAndParent(int dist[],int par[]) {
	char arr[]= {'/','s','t','x','y','z'};
	System.out.println("vertex Distance Parent");
	for(int i=1;i<dist.length;i++) {
		System.out.println(arr[i]+"\t"+dist[i]+"\t"+arr[par[i]]);
	}
}
}
