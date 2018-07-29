package swacademy.problem._1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1215. [S/W 문제해결 기본] 3일차 - 회문1 

public class Solution {
	static char arr[][] = new char[8][8];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for(int testCase = 0; testCase<10; testCase++){
			int NUM = Integer.parseInt(br.readLine());
			for (int i=0; i<8; i++){
				arr[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}
			
			
//		}
	}

}
