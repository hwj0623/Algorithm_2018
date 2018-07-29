package swacademy.problem._1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.
//
//1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
//2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
//3. 판매는 얼마든지 할 수 있다.
//
//예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.
//bitmask로는 풀이 안됨
//각 날짜에 사거나 | 팔거나 | 아무것도 안하거나 3가지 행동 가능.
//divide and conquer 로 접근
// 배열을 쪼개서 한 부분배열의 구간의 max가 가장 오른쪽에 오게 위치시킨다. 
// 나머지 배열에 대해서도 그러한 방식으로 쪼갠다. 
// 길이가 1인 배열의 경우에는 구매없음, 가장 오른쪽이 부분 최대값인 경우 각 날짜별로 그 길이만큼 차이 합산

public class Solution {
	static int T, N;
	static long ans;
	static int arr[];
	static int dp[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T =Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int tmpMax = 0;
			int tmpIdx = 0;
			arr = new int[N];
			dp = new int[N];
			int n = 0;
			for (n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
		
			dnq(0, arr.length-1);

			System.out.println("#" + t + " " + ans);
		}
	}

	public static void dnq(int left, int right) {
		int tmpMax = 0;
		int tmpIdx = left;
		if (left >= right)
			return;
		int nextleft = left;
		for ( ; nextleft <= right; nextleft++) {
			if (tmpMax < arr[nextleft]) {
				tmpMax = arr[nextleft];
				tmpIdx = nextleft;
			}
		}
		for(int k=left; k<tmpIdx; k++){
			ans += tmpMax-arr[k];
		}
		dnq(tmpIdx+1, right);
		
	}
}
