package Quick_Iterative;

// no recursive, just iterative
public class IterativeQuickSort {
	static void swap(int arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	// 파티션 분할 메소드는 iterative나 recursive나 동일 
	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	
	
	//recursive quick sort
	static void RecursiveQuicksort(int arr[], int low, int high){
 		if(low < high){
 			//파티션 이전의 피벗 위치를 찾는다. 
 			int pi = partition(arr, low, high);
 			//피벗을 기준으로 재귀 분할 
 			RecursiveQuicksort(arr, low, pi-1);
 			RecursiveQuicksort(arr, pi+1, high);
 		}
 	}
	
	//보조 스택을 활용하여 재귀적 퀵소트를 반복문 퀵소트로 변환 가능
	void IterativeQuickSort(int arr[], int low, int high) {
		//보조 스택 생성 
		int stack[] = new int[high - low + 1];
		//stack의 top 초기화
		int top = -1;
		//스택의 초기 값을 push, 처음에 low, high 인덱스를 푸시한다 
		stack[++top] = low;
		stack[++top] = high;

		while (top >= 0) {
			//pop high and low
			high = stack[top--];
			low = stack[top--];

			// set pivot element 
			int pivot = partition(arr, low, high);

			// 만약 피벗의 좌측에 요소들이 남아있다면,
			// 스택에 그것들을 푸시한다.
			if (pivot - 1 > low) {
				stack[++top] = low;
				stack[++top] = pivot - 1;
			}
			
			// 만약 피벗의 오른쪽에 요소들이 남아있다면
			// 스택에 그것들을 쌓는다. 
			if (pivot + 1 < high) {
				stack[++top] = pivot + 1;
				stack[++top] = high;
			}
		}
	}

	public static void main(String[] args) {
        IterativeQuickSort ob = new IterativeQuickSort();
        int arr[] = {4, 3, 5, 2, 1, 3, 2, 3};
        ob.IterativeQuickSort(arr, 0, arr.length-1);
        ob.printArr(arr, arr.length);

	}
	 // A utility function to print contents of arr
    void printArr( int arr[], int n )
    {
        int i;
        for ( i = 0; i < n; ++i )
            System.out.print(arr[i]+" ");
    }
}
