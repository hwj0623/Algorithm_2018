package BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	// 시작 점 s로부터 BFS 순회 시작 
	void BFS(int s){
		//visited 배열 초기화 
		boolean visited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()){ //queue.size()!=0
			
			//queue에서 vertex를 출력(=방문)
			s = queue.poll();
			System.out.println(s+" ");
			// 현재 방문 vertex와 인접한 모든 vertex를  
			Iterator<Integer>i = adj[s].listIterator();
			
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.BFS(2);
	}
}
