package Merge_Iterative;

//Unlike Iterative QuickSort, the iterative MergeSort 
//doesn’t require explicit auxiliary stack.
public class IterativeMergeSort {
	public static void mergeSort(int[] arr, int n) {
		// for current size of subarrays to be merged
		int curSize;
		// 병합할 left배열의 starting index
		int leftStart;

		// bottom-up 방식으로 subarray들을 병합한다.
		// 1)First merge subarrays of size 1 to create sorted subarrays of size 2
		// 2) then merge subarrays of size 2 to create sorted subarrays of size4, and so on.
		for (curSize = 1; curSize <= n - 1; curSize = 2 * curSize) {
			//current size 변화에 따라 다양한 부분배열의 스타트 지점을 선택 
			for (leftStart = 0; leftStart < n - 1; leftStart += 2 * curSize) {
				//  left 부분 배열의 end point를 찾는다. 
				int mid = leftStart + curSize - 1;
				int rightEnd = Math.min(leftStart + 2 * curSize - 1, n - 1);

				merge(arr, leftStart, mid, rightEnd);
			}
		}
	}

	static void merge(int arr[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		/* create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays L[] and R[] */
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays back into arr[l..r] */
		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy the remaining elements of L[], if there are any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there are any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
 
	public static void main(String[] args) {
	    int arr[] = {12, 11, 13, 5, 6, 7};
	    int n = arr.length;
	    System.out.println("Given array is \n");
	    printArray(arr);
	 
	    mergeSort(arr, n);
	 
	    System.out.println("\nSorted array is \n");
	    printArray(arr);
	}
}
