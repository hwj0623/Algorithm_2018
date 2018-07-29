package swacademy.problem._2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2007. 패턴 마디의 길이
//문자열 길이 30, 마디의 길이 최대 10 
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			char arr[] = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			int ans = 1; //마디 초기 길이 
			sb.append(arr[0]);
			for(int i=1;i<arr.length; i++){
				if(arr[i]==arr[0] && sb.toString().length()*2<=arr.length && sb.toString().equals(str.substring(i,  i+sb.length())))
					break;
				else
					sb.append(str.charAt(i));
				
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
