package RecursiveBinarySearch;

public class RecursiveBinarySearch {

	// arr[]내에 존재한다면 x의 index를 반환한다.
	// 아니면 return -1
	int binarySearch(int arr[], int l, int r, int x) {
		if (r >= 1) {
			//중간 인덱스 값 찾기 
			int mid = l + (r - l) / 2;
			//탐색 성공시 
			if (arr[mid] == x)
				return mid;
			//재귀 탐색 
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);
			else
				return binarySearch(arr, mid + 1, r, x);
		}
		// 탐색 실패 시
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursiveBinarySearch ob = new RecursiveBinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = ob.binarySearch(arr, 0, n - 1, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
	}
}
