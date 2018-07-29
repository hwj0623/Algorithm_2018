package swacademy.problem._4466;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//4466. 최대 성적표 만들기 D3
public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc= new Scanner (System.in);
		int T = sc.nextInt();
		int N, K;
		
		for(int t=1; t<=T; t++){
			N = sc.nextInt();
			K = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			int ans = 0;
			for(int k=arr.length-1; k>arr.length-K-1; k--){
				ans += arr[k];
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
