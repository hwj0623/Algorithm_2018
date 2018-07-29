package swacademy.problem._2477;

import java.util.Scanner;

public class Solution {
	public static int ans;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = sc.nextInt();
			char str[] = Integer.toString(ans).toCharArray();
			int N = sc.nextInt();
			bt(0, str, N, 0);
			System.out.print("#" + t + " " + ans);
			if (t < T)
				System.out.println();
		}
		sc.close();
	}

	public static void bt(int left, char str[], int N, int k) {
		if (k == N) {
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < str.length; i++)
				buf.append(str[i]);
			ans = Math.max(ans, Integer.parseInt(buf.toString()));
			return;
		}

		if (left == str.length - 2) {
			swap(str, left, left + 1);
			bt(left, str, N, k + 1);
			return;
		}
		char max = str[left];
		for (int i = left + 1; i < str.length; i++){
			if (max < str[i])
				max = str[i];
		}
		if (str[left] == max)
			bt(left + 1, str, N, k);
		else
			for (int i = left + 1; i < str.length; i++) {
				if (max == str[i]) {
					swap(str, left, i);
					bt(left + 1, str, N, k + 1);
					swap(str, left, i); // trace back
				}
			}
	}

	public static void swap(char[] str, int a, int b) {
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}
}