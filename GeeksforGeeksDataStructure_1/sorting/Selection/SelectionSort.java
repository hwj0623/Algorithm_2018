package Selection;

public class SelectionSort {

	void sort(int arr[]) {
		int n = arr.length;
		// 정렬되지 않은 배열에서 하나씩 인덱스를 선택한다.
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			// Find the min element in unsorted array
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx])
					minIdx = j;
			}
			// swap the found min element with the first element
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}

	// Prints the array
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
