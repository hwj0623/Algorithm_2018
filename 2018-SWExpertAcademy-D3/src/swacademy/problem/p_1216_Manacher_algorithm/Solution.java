package swacademy.problem.p_1216_Manacher_algorithm;

/**
 * Palindrome 1215
 * Manacher Algorithm을 이용한 풀이 
 */
import java.util.Scanner;

public class Solution {
	static char arr[][];
	static final int VERTICAL = 1;
	static final int HORIZONTAL = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int test = sc.nextInt();
			sc.nextLine(); // clear buffer

			arr = new char [100][100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}
			int ret = 0;
			
			//가로 회문 검사 
			for(int i=0; i<100; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<100; j++){
					sb.append(arr[i][j]);
				}
//				System.out.println(sb.toString());
				int tmp = Manacher(sb.toString());
				
				if(ret <tmp)
					ret = tmp;
				
			}
			//세로 회문 검사 
			for(int j=0; j<100; j++){
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<100; i++){
					sb.append(arr[i][j]);
				}
				int tmp = Manacher(sb.toString());
				if(ret<tmp)
					ret = tmp;
			}
			
			System.out.println("#"+t+" "+ret);
		}
	}

	public static int Manacher(String s) {
		//입력받은 문자열에 대해 사이에 #을 넣고, 양 끝지점에 각각 $, @를 넣기 위해 길이를 *2+3해준다.
		char T[] = new char[s.length() * 2 + 3];
		T[0] = '$'; // 시작 문자
		T[s.length() * 2 + 2] = '@'; // 마지막 문자
		//사이에 #을 채운다. 
		for (int i = 0; i < s.length(); i++) {
			T[2 * i + 1] = '#';
			T[2 * i + 2] = s.charAt(i);
		}
		T[s.length() * 2 + 1] = '#';

		int[] p = new int[T.length];
		//mirr, center, right 를 인덱스로 활용하여, 각 center의 회문길이값을 저장하는 배열 p를 채운다 .
		int center = 0; // C
		int right = 0; // R

		// Manacher 알고리즘
		for (int i = 1; i < T.length-1; i++) {	// T.length-1 : '@'는 조사할 필요 없다. 
			// 1. update mirr
			int mirr = 2 * center - i; // mirr는 center를 중심으로 하는 회문에서 i와 대칭인
										// 인덱스이다.
			// 2. p[i]에 저장된 대칭의 회문 길이 대입
			if (i < right) {
				p[i] = Math.min(right - i, p[mirr]);
			}
			while (T[i + (1 + p[i])] == T[i - (1 + p[i])]) {
				p[i]++;
			}
			// 현재 회문의 길이가 기존의 회문 길이(right boundary)를 초과하면
			// center와 right boundary를 갱신한다.
			if (i + p[i] > right) {
				center = i;
				right = i + p[i];
			}
		}

		int maxPalindromeLength = 0;
		center = 0;
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > maxPalindromeLength) {
				maxPalindromeLength = p[i];
				center = i;
			}
		}
		return maxPalindromeLength;
	}

}
