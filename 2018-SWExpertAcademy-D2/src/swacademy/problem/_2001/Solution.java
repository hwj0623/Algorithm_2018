package swacademy.problem._2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파리 퇴치 
public class Solution {
	static int T,N,M;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			dp = new int[N][N];
			for(int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ret = 0;
			for(int i=0; i<N-M+1; i++){
				for(int j=0; j<N-M+1; j++){
					for(int k=0; k<M; k++){
						for(int l=0; l<M; l++){
							dp[i][j] += map[i+k][j+l];
						}
					}
					if(ret <dp[i][j])
						ret = dp[i][j];
				}
			}
			System.out.println("#"+t+" "+ret);
		}
	}
}
