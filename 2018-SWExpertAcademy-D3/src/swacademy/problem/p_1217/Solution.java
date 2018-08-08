package swacademy.problem.p_1217;

/**
 *dfs multiply 1216
 */
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int test = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ret = dfsMultiply(N, M);
			System.out.println("#" + t + " "+ret);

		}
	}

	public static int dfsMultiply(int n, int m) {
		int nextM = m;
		// basic
		if (m <= 0)
			return 1;
		// recursive
		else {
			int tmp = dfsMultiply(n, --nextM) * n;
			return tmp;
		}
	}
}
