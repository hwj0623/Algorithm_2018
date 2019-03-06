package ShellSort;

public class ShellSort {

	static int shellSort(int arr[]) {
		int n = arr.length;

		// 매우 큰 gap 값으로부터 시작하여 gap을 줄여나간다.
		for (int gap = n / 2; gap > 0; gap /= 2) {
			// 이 gap size에 대해 삽입 정렬을 수행
			// 첫 gap의 요소들은 a[0...gap-1]
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = arr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
		return 0;
	}

	// Driver method
	public static void main(String args[]) {
		int arr[] = { 12, 34, 54, 2, 3 };
		System.out.println("Array before sorting");
		printArray(arr);

		ShellSort ob = new ShellSort();
		ob.shellSort(arr);

		System.out.println("Array after sorting");
		printArray(arr);
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
