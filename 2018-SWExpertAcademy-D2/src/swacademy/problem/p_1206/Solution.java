package swacademy.problem.p_1206;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		for(int t =1; t <= 10; t++){
			int result=0;
			int size = sc.nextInt();
			int arr[] = new int [size];
			int maxOfFour[] = new int [size]; //좌우 네 값중 최대값을 담는 배열
			//input 
			for(int i=0; i<size; i++){
				arr[i]= sc.nextInt();	
			}
			
			for(int i=2; i<size-2; i++){
				int cur = Math.max(arr[i-2], arr[i-1]);
				cur = Math.max(cur, arr[i+1]);
				cur = Math.max(cur, arr[i+2]);
				maxOfFour[i]=cur;
				
				if(arr[i]-maxOfFour[i]>0){
					result+=arr[i]-maxOfFour[i];
				}else{
					continue;
				}
			}
			System.out.println("#"+t+" "+result);	
		}
	}
}
