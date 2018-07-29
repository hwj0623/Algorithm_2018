package swacademy.problem._1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int sudoku[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sudoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean ret = check(sudoku);
			if(ret)
				System.out.println("#"+t+" "+1);
			else
				System.out.println("#"+t+" "+0);
		}
	}

	public static boolean check(int arr[][]) {
		// 가로 체크
		boolean result = true;
		boolean checkGaro[][] = new boolean[9][9];
		boolean checkSero[][] = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (checkGaro[i][arr[i][j] - 1])
					return result = false;
				else
					checkGaro[i][arr[i][j] - 1] = true;
			}
		}

		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				if (checkSero[arr[i][j] - 1][j])
					return result = false;
				else
					checkSero[arr[i][j] - 1][j] = true;
			}
		}

		// 3x3 check
		boolean check3x3[] = new boolean[9];
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				Arrays.fill(check3x3, false);
				// j = 0~2, 3~5, 6~8
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (check3x3[arr[i + (m * 3)][j + (n * 3)] - 1])
							return result = false;
						else
							check3x3[arr[i + (m * 3)][j + (n * 3)] - 1] = true;
					}
				}
			}
		}
		return result;
	}
}
