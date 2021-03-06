package GraphRepresentation2Way;

import java.util.LinkedList;

public class GraphAdjList {
	static class Graph{
		int V;
		LinkedList<Integer> adjListArray[];
		
		//생성자
		Graph(int V){
			this.V = V;
			//vertex 개수로 배열의 크기를 정의 
			adjListArray = new LinkedList[V];
			
			for(int i=0; i<V; i++){
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	// Adds an edge to an undirected graph
	static void addEdge (Graph graph, int src, int dest){
		// from src to dest 엣지 추가 
		graph.adjListArray[src].addFirst(dest);
		// from dest to src 엣지 추가 
		graph.adjListArray[dest].addFirst(src);
	}
	
	static void printGraph(Graph graph)
    {       
        for(int v = 0; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: graph.adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }
	public static void main(String[] args) {
		// create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        printGraph(graph);
	}
}
