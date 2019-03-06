package MergeSort;

public class MergeSort {
	void merge(int arr[], int l, int m, int r) {

		// 병합할 두 서브배열의 크기를 찾는다
		int n1 = m - l + 1;
		int n2 = r - m;
		// 임시배열 Left, Right 생성
		int L[] = new int[n1];
		int R[] = new int[n2];

		// 요소를 임시 배열에 복사
		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];

		for (int j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		// 두 서브어레이에 대한 인덱스 생
		int i = 0, j = 0;
		// 병합된 서브어레이의 초기 인덱스 설정
		int k = l;
		//i와 j가 각각의 배열보다 둘다 작을 때 반복해서 
		//arr[k](to be sorted) 에 값을 비교하여 넣는다. 
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++; 
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++; //k의 인덱스 증가 
		}
		
		//L 또는 R의 남은 요소를 arr에 옮겨 담는다
		while(i<n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	void mergeSort(int arr[], int l, int r){
		if(l<r){
			//Find the mid point
			int mid = (l+r)/2;
			
			//Sort 1st and 2nd halves
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			//merge the sorted halves 
			merge(arr, l, mid, r);
		}
	}
	/* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
}
