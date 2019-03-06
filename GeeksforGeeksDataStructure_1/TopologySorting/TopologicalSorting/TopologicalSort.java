package TopologicalSorting;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	static int V;
	public LinkedList<Integer> adj[];

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	TopologicalSort(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	void topologicalSortUtil(int v, boolean visited[], Stack stack) {
		// 현재 지점을 방문
		visited[v] = true;
		// 현재 정점 v와 인접한 모든 정점을 재귀 탐색
		for (int i = 0; i < adj[v].size(); i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		// 인접 정점을 다 돌고 난 뒤에 스택에 v정점을 넣는다.
		// (v의 인접정점은 v이전에 스택에 쌓인다.)
		// stack에 꺼낼때는 v부터 나오므로 !!
		stack.push(v);
	}

	void topologicalSort() {
		Stack stack = new Stack();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		TopologicalSort graph = new TopologicalSort(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		graph.topologicalSort();
	}
}
