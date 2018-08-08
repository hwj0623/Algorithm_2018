package swacademy.problem.p_1213;

import java.util.ArrayList;
/**
 * String 1213
 */
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int test = sc.nextInt();
			sc.nextLine(); // buffer clear
			String pattern = sc.nextLine();
			String input = sc.nextLine();
			ArrayList<Integer> result = KMP(input, pattern);
			
			
			System.out.println("#" + t + " "+result.size() );

		}
	}

	public static ArrayList<Integer> KMP(String str, String pattern) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] pi = getPi(pattern); // pi 배열 생성

		int n = str.length();
		int m = pattern.length();
		int j = 0;
		
		char s[] = str.toCharArray();
		char p[] = pattern.toCharArray();
		
		//str 전체 문자열. pattern : 찾을 문자열
		//i : 전체 문자열(str)의 비교할 인덱스. 1씩증가
		//j : 패턴 문자열(pattern) 의 인덱스 
		
		for(int i=0; i<n; i++){
			while(j>0 && s[i] !=p[j]){	//패턴이 현재 인덱스에서 불일치 하는 경우
				//중간 단계는 뛰어넘는다.
				//pi 배열을 활용하여 j 인덱스를 변경(건너뜀)함으로써 while문은 중단된다. 
				j = pi[j-1];	//현재 j의 비교에서 불일치하므로 이전 j인 j-1의 pi[j-1]값을 찾아서 
								//포함된 부분문자열 인덱스(건너뛰지 않을 부분)를 지정한다. 
			}
			if(s[i]==p[j]){
				if(j==m-1){ 				//pattern을 str에서 발견 
					list.add(i-m+1);	//pattern을 찾은 부분의 초기 인덱스 값을 리스트에 넣는다. 
					// 전체 문자열에서 여러 개의 패턴 문자열이 있을 수 있다. 따라서 j를 m-1만큼  건너뛰고 다시 진행한다. 
					j= pi[j];
				}else{
					j++;
				}
			}
		}
		return list;
	}

	public static int[] getPi(String pattern) {
		int m = pattern.length();
		int j = 0;
		char p[] = new char[m];
		int pi[] = new int[m];
		p = pattern.toCharArray();

		// i 는 pattern 문자열의 0 ~ i까지의 부분문자열을 의미.
		// i=0인 경우는 부분문자열이 1개이고 접두/접미사 비교가불가능하다.
		// 즉, 항상 pi[0] = 0이므로 의미가 없다.
		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j]) { // pattern의 접두사와 접미사 부분문자열이 일치하지 않는
											// 경우,
				j = pi[j - 1]; // 이전 단계에서 일치했던 부분만큼 앞당겨서 다시비교한다.

			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
