package Heap_Sort;

public class HeapSort {
	public void heapSort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// 하나씩 heap에서 추출
		for (int i = n - 1; i >= 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			// 감소된 힙 구조 크기만큼 max heapify 만든다.
			heapify(arr, i, 0);
		}
	}

	void heapify(int arr[], int n, int i) {
		int largest = i; // largest를 root로 초기화
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// 만약 왼쪽 자식이 루트보다 크면
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		// 만약 오른쪽 자식이 largest보다 크다면
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		// 만약 largest 인덱스가 root인덱스(i)가 아니라면
		// arr[largest]와 arr[i] 둘을 스왑한다.
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			// largest를 루트로 하는 서브 트리 재귀 호출
			heapify(arr, n, largest);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;

		HeapSort ob = new HeapSort();
		ob.heapSort(arr);

		System.out.println("Heap Sorted array is");
		printArray(arr);
	}
}
