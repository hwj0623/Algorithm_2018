package swacademy.problem._1926;

import java.util.Scanner;

public class Solution {
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		String str = solve(n);
	}
	public static String solve(int n){
		String str="";
		for(int i=1; i<=n; i++){
			String tmp = ""+i;
			int cnt =0;
			for(int j=0; j<tmp.length(); j++){
				if(tmp.charAt(j)=='3' || tmp.charAt(j)=='6'|| tmp.charAt(j)=='9'){
					cnt++;
				}
			}
			if(cnt!=0){
				while(cnt>0){
					sb.append('-');
					cnt--;
				}
			}else{
				sb.append(tmp);
			}
			sb.append(' ');
		}
		str = sb.toString();
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		return str;
	}
}
