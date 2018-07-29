package swacademy.problem.p_1209;

import java.util.Scanner;
public class Solution {
	static int arr[][] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		for(int t=1; t<=10; t++){
			int test = sc.nextInt();
			int orthogonal1 = 0;
			int orthogonal2 = 0;
			int garo [] = new int [100];
			int sero [] = new int [100];
			arr = new int[100][100];
			int result = 0;
			//초기화 및 가로 합 
			for(int i=0; i<100; i++){
				for(int j=0; j<100; j++){
					arr[i][j] = sc.nextInt();
					garo[i] += arr[i][j];
				}
				if(result <garo[i])
					result = garo[i];
			}
			//세로 합 
			for(int j=0; j<100; j++){
				for(int i=0; i<100; i++){
					sero[j] += arr[i][j];
				}
				if(result <sero[j])
					result = sero[j];
			}
			
			//대각선 \ 합
			//대각선 / 합 
			for(int i=0; i<100; i++){
				orthogonal1 += arr[i][i];
				orthogonal2 += arr[100-i-1][i];
			}
			result = Math.max(result, orthogonal1);
			result = Math.max(result, orthogonal2);
		
			System.out.println("#"+t+" "+result);	
		}
	}
}
