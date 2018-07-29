package swacademy.problem._1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//rule 1. c로부터 8면에 지뢰가 존재하지 않으면 queue에 넣는다. (value =0)
//rule 2. dp 배열에 인접한 지뢰가 있는지 카운트 하여 정보를 입력한다.
//rule 3. dp[i][j]==0인 경우와 그 외의 경우를 나눠서 카운트 한다. 

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int T;
	static int N;
	static int map[][];
	static char board[][];
	static boolean visited[][];

	

	static int mx[] = { -1, 1, 0, 0 };
	static int my[] = { 0, 0, -1, 1 };
	// 8방향
	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			board = new char[N][N];
			visited = new boolean[N][N];
			for (int n = 0; n < N; n++) {
				String tmp = br.readLine();
				board[n] = tmp.toCharArray();
			}
			// bfs queue
			Queue<Point> qq = new LinkedList<Point>();
			// 인접 지뢰 카운트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '*') {
						map[i][j] = 9;
						continue;
					}
					int nierMine = 0;
					// 별표가 아닌 지점에서 인접 지뢰 개수 구한다.
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || ny < 0 || nx >= N || ny >= N)
							continue;
						if (board[nx][ny] == '*') {	//
							nierMine++;
						}
					}
					map[i][j] = nierMine;
				}
			}

			int click = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0 && !visited[i][j]) { // 첫 시작점을 넣는다.
						qq.add(new Point(i, j));
						click++;
						// bfs 시작
						while (!qq.isEmpty()) {
							Point cur = qq.poll();
							int cx = cur.x;
							int cy = cur.y;
							visited[cx][cy] = true; // 방문 체크

							// 인접한 8방향에 대해서 지뢰와 인접한 영역은 방문 체크해준다.
							for (int k = 0; k < 8; k++) {
								int nx = cx + dx[k];
								int ny = cy + dy[k];
								if (nx < 0 || ny < 0 || nx >= N || ny >= N)
									continue;
								if (map[nx][ny] > 0 && map[nx][ny] != 9) {
									visited[nx][ny] = true;
								}else  if(map[nx][ny]==0 && !visited[nx][ny]){
									qq.add(new Point(nx, ny));
									visited[nx][ny] = true;
								}
							}
						}
					}
				}
			}
			// 인접한 0이 없는 나머지 빈칸개수를 더한다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && !visited[i][j] && map[i][j] != 9) {
						// System.out.println("여기 안오냐 ");
						click++;
						visited[i][j] = true;
					}
				}
			}
			System.out.println("#" + t + " " + click);
			click = 0;
		}
	}
}
