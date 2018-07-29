package swacademy.problem.p_1208;

import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	static int DUMP = 0;
	static int arr[] = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		for(int t=1; t<=10; t++){
			Arrays.fill(arr, 0);
			DUMP = sc.nextInt();
			int tmpMaxIdx = 0; 
			int tmpMax = 0;
			int tmpMinIdx = 0;
			int tmpMin = 100;
			for(int i=0; i<100; i++){
				arr[i] = sc.nextInt();
				if(arr[i] > tmpMax){
					tmpMax = arr[i];
					tmpMaxIdx = i;	
				}
				if(arr[i]<tmpMin){
					tmpMin = arr[i];
					tmpMinIdx = i;
				}
			}
			
			//DUMP 시작
			while(true){
				DUMP--;
				tmpMax--;
				arr[tmpMaxIdx]--;
				arr[tmpMinIdx]++;
				tmpMin++;
				//새로운 tmpMin과 tmpMax 갱신 
				for(int i=0; i<100; i++){
					if(arr[i] > tmpMax){
						tmpMax = arr[i];
						tmpMaxIdx = i;	
					}
					if(arr[i]<tmpMin){
						tmpMin = arr[i];
						tmpMinIdx = i;
					}
				}
				if(DUMP==0)
					break;
				if((tmpMax-tmpMin) <=1 )
					break;
			}
			
			int result = tmpMax-tmpMin;
			System.out.println("#"+t+" "+result);	
		}
		
	}
}
