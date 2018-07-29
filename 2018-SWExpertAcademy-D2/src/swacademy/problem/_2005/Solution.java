package swacademy.problem._2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//파스칼 삼각형 
public class Solution {
	static int map[][];
	static int T, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++){
				map[i][0] = 1;
//				map[i][i] = 1;
			}
			for(int i=1; i<N; i++){
				for(int j=1; j<N; j++){
					map[i][j] = map[i-1][j]+map[i-1][j-1];
				}
			}
			System.out.println("#"+t);
			for(int i=0; i<N; i++){
				for(int j=0; j<i; j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.print(map[i][i]);
				System.out.println();
			}
		}
	}
}
