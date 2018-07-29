package swacademy.problem._1989;

import java.util.Scanner;

public class Solution {
	static int T;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		sc.nextLine();
		String str="";
		for(int t=1; t<=T; t++){
			str = sc.nextLine();
			System.out.println("# "+t+" "+isPal(str));
		}
	}
	public static  int isPal(String str){
		
		if(str.length()==1){
			return 1;
		}
		if(str.length()==2 && str.charAt(0)==str.charAt(1)){
			return 1;
		}
		
		String next = str.substring(1, str.length()-1);
		if(str.charAt(0)==str.charAt(str.length()-1))
			isPal(str.substring(1, str.length()-1));
		
		else{
			return 0;
		}
		return 1;
	}
}
