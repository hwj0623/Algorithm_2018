package DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	void DFSUtil2(int v, boolean visited[]){
		visited[v] = true;
		System.out.println(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	void DFSUtil(int v, boolean visited[]) {
		// 현재 방문 지점 true
		visited[v] = true;
		System.out.println(v + " ");
		for(int i=0; i<adj[v].size(); i++){
			int n = adj[v].get(i);
			if(!visited[n]){
				DFSUtil(n, visited);
			}
		}

	}

	void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFSUtil(v, visited);
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}
}
