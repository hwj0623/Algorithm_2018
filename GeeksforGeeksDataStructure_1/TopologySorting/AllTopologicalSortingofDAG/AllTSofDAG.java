//package AllTopologicalSortingofDAG;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Stack;
//import java.util.Vector;
//
//public class AllTSofDAG {
//	int V;
//	// 그래프
//	LinkedList<Integer> adj[];
//	// 정점의 차수를 저장할 indegree 배열
//	Vector<Integer> indegree;
//
//	AllTSofDAG(int v) {
//		this.V = v;
//		adj = new LinkedList[v];
//		indegree = new Vector();
//
//		// 모든 차수를 0으로 설정
//		for (int i = 0; i < v; i++) {
//			indegree.add(0);
//			adj[i] = new LinkedList<>();
//		}
//	}
//
//	void addEdge(int v, int w) {
//		adj[v].add(w);
//		int t = indegree.get(w) + 1;
//		indegree.set(w, t);
//	}
//
//	void allTopologicalSortUtil(Stack result, boolean visited[]) {
//		// To indicate whether all topological are found
//		// or not
//		boolean flag = false;
//		int cur;
//		int t;
//		for (int i = 0; i < V; i++) {
//			if (indegree.get(i) == 0 && !visited[i]) {
//				Iterator<Integer> j = adj[i].listIterator();
//				while (j.hasNext()) {
//					 cur = j.next();
//					 t = indegree.get(cur) - 1;
//					indegree.set(cur, t);
//				}
//				// i vertex를 result에 포함
//				result.add(i);
//				visited[i] = true;
//				allTopologicalSortUtil(result, visited);
//
//				// 백트래킹을 위해 visited와 result, indegree를 리셋한다.
//				visited[i] = false;
//				result.clear();
//				
//				j = adj[i].listIterator();
//				
//				while (j.hasNext()) {
//					cur = j.next();
//					t = indegree.get(cur)+1;
//					indegree.set(cur, t);
//				}
//
//				flag = true;
//			}
//		}
//		// 모든 정점을 다 방문하였다면, 해당 토폴로지 소팅을 출력한다.
//		if (!flag) {
//			for (int i = 0; i < result.size(); i++) {
//				System.out.print(result.pop() + " ");
//			}System.out.println();
//		}
//	}
//
//	void allTopologicalSort() {
//		boolean visited[] = new boolean[V];
//		for (int i = 0; i < V; i++)
//			visited[i] = false;
//
//		Stack result = new Stack();
//		allTopologicalSortUtil(result, visited);
//	}
//
//	public static void main(String[] args) {
//		AllTSofDAG g = new AllTSofDAG(6);
//		g.addEdge(5, 2);
//		g.addEdge(5, 0);
//		g.addEdge(4, 0);
//		g.addEdge(4, 1);
//		g.addEdge(2, 3);
//		g.addEdge(3, 1);
//
//		System.out.println("All Topological sorts");
//		g.allTopologicalSort();
//	}
//
//}
