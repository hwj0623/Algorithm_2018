package swacademy.problem._4371;

import java.io.IOException;
import java.util.Scanner;

//4371. 항구에 들어오는 배  D3
public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner (System.in);
		
		int T = sc.nextInt();
		int N;
		
		for(int t=1; t<=T; t++){
			N = sc.nextInt();
			int arr[] = new int [N];
			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}

			int initDiff = arr[1]-arr[0];

			int ans = 0;
			int check[] = new int[N];
			int ret[] = new int[N];
			 for(int i=1; i<arr.length; i++){
				 initDiff = arr[i]-arr[0];
				 for(int j=i; j<arr.length; j++){
					 if(check[j]!=0){
						 continue;
					 }
					 if((arr[i]-arr[j])%initDiff==0){
						 check[j] = initDiff;
						 ret[i] = initDiff;
					 }else{
						 continue;
					 }

				 }
			 }

			 for(int i=0; i<ret.length; i++){
				 if(ret[i]!=0){
					 ans++;
				 }
			 }
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
