package IterativeBinarySearch;

public class IterativeBinarySearch {
	int binarySearch(int arr[], int x) {
		int l = 0, r = arr.length - 1;
		// 재귀 대신 반복문
		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (arr[mid] == x)
				return mid;
			// x가 arr[mid] 보다 크다면 l을 mid+1로 갱신
			if (arr[mid] < x)
				l = mid + 1;
			// x가 arr[mid] 보다 작다면 r을 mid-1로 갱신
			else
				r = mid - 1;
		}
		// 실패시
		return -1;
	}

	public static void main(String[] args) {
		IterativeBinarySearch ob = new IterativeBinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = ob.binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
	}
}
