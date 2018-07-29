package swacademy.problem._1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N,M;
	static int map[][];
	static int garo[][];
	static int sero[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];	//
			garo = new int[N][N];	//가로
			sero = new int[N][N];	//세로
			for(int i=0;i<N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int i,j, ret=0;
			for(i=0; i<N; i++){
				int tmp=0;
				for(j=0; j<N; j++){
					if(tmp==0 && map[i][j]==0) continue;
					if(map[i][j]==1)
						tmp++;
					if(j==N-1){
						garo[i][j]=tmp;
					}
					if(j<N-1 && map[i][j+1]==0){
						garo[i][j]=tmp;
						tmp=0;
					}
				}
			}
			for(j=0; j<N; j++){
				int tmp=0;
				for(i=0; i<N; i++){
					if(tmp==0 && map[i][j]==0) continue;
					if(map[i][j]==1)
						tmp++;
					if(i==N-1){
						sero[i][j]=tmp;
					}
					if(i<N-1 && map[i+1][j]==0){
						sero[i][j]=tmp;
						tmp=0;
					}
				}
			}
			for( i=0; i<N; i++){
				for( j=0; j<N;j++){
					if(sero[i][j]==M)
						ret++;
					if(garo[i][j]==M)
						ret++;
				}
			}
			
			System.out.println("#"+t+" "+ret);
//			for( i=0; i<N; i++){
//				for( j=0; j<N; j++){
//					System.out.print(garo[i][j]+" ");
//				}System.out.println();
//			}
//			
//			System.out.println();
//			for( i=0; i<N; i++){
//				for( j=0; j<N; j++){
//					System.out.print(sero[i][j]+" ");
//				}System.out.println();
//			}
		}
	}
}
