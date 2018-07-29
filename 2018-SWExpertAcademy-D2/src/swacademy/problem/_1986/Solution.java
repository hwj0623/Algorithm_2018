package swacademy.problem._1986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
			N = Integer.parseInt(br.readLine());
			int ret =0;
			for(int i=1; i<=N; i++){
				if(i%2==0){
					ret-=i;
				}else{
					ret+=i;
				}
			}
			System.out.println("#"+t+" "+ret);
		}
	}
}
