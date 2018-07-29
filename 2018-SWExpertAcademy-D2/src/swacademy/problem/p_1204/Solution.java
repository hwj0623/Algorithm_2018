package swacademy.problem.p_1204;

import java.util.Scanner;

public class Solution {
	static int T,N;
	static int arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
	
		for(int t =1; t <= 10; t++){
			int testcase = sc.nextInt();
			arr = new int [1001];
			for(int i=1; i<=1000; i++){
				int current = sc.nextInt();
				arr[current]++;
			}
			int ret = arr[1];
			int idx = 1;
			for(int i=2; i<=1000; i++){
				if(arr[i]>=ret){
					ret = arr[i];
					idx = i;				
				}
			}
			System.out.println("#"+testcase+" "+idx);
		}
	}
}
