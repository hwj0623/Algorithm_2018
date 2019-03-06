package DetectCycleInDAG;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInDAG {
	int V;
	static LinkedList<Integer> adj[];
	DetectCycleInDAG(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	boolean isCyclicUtil(int v, boolean visited[], boolean[] recStack) {
		if (!visited[v]) {
			visited[v] = true;
			recStack[v] = true;

			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				int cur = i.next();
				if (!visited[cur] && isCyclicUtil(cur, visited, recStack)) {
					return true;
				} else if (recStack[cur])
					return true;
			}
		}
		recStack[v] = false; // remove the vertex from recursion
		return false;
	}

	boolean isCyclic() {
		boolean visited[] = new boolean[V];
		boolean recStack[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
			recStack[i] = false;
		}

		for (int i = 0; i < V; i++) {
			if (isCyclicUtil(i, visited, recStack))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		DetectCycleInDAG g = new DetectCycleInDAG(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		 if(g.isCyclic())
			 System.out.println("Graph contains cycle");
		 else
			 System.out.println("Graph doesn't contain cycle");
	}
}
