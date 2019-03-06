package RadixSort;

import java.util.Arrays;

public class RadixSort {
	static int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];

		return max;
	}

	// exp로 대표되는 자릿수에 따라 arr[]을 카운트 소팅하는 함수
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10]; // 0~9
		Arrays.fill(count, 0);

		// count[]에 빈도를 카운트하여 저장
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		// count[i]가 자릿수의 실제 위치를 포함하도록 변경
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		// output array 만들기
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static void radixSort(int arr[], int n) {
		int max = getMax(arr, n);

		for (int exp = 1; max / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixSort(arr, n);
		print(arr, n);
	}
}