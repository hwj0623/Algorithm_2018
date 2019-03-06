package Quick_Sort;

//머지소트와 마찬가지로 D&Q 알고리즘을 사용
//하나의 엘리먼트를 피벗으로 뽑고, 선택한 피벗을 중심으로 파티션을 나눈다.
//퀵소트에서 피벗을 선택하는 방법은 다양하다.
// 1) 매번 첫 요소를 피벗으로 뽑기
// 2) 매번 마지막 요소를 피벗으로 뽑기 (구현)
// 3) 랜덤 요소를 피벗으로 뽑기
// 4) 중앙값을 피벗으로 뽑기
/*

Pseudo Code for recursive QuickSort function :
low  --> Starting index,  high  --> Ending index
 
	quickSort(arr[], low, high)
	{
	    if (low < high)
	    {
	        // pi is partitioning index, arr[pi] is now
	        // at right place 
	        pi = partition(arr, low, high);
	
	        quickSort(arr, low, pi - 1);  // Before pi
	        quickSort(arr, pi + 1, high); // After pi
	    }
	}
 */
// =======================
// 파티션 알고리즘
// There can be many ways to do partition,
// following pseudo code adopts the method given in CLRS book.

// pivot으로 가장 오른쪽 요소를 지정
// 더 작은 element의 index를 i라 하고, low-1부터 시작.
// 가장 왼쪽의 요소부터 (j=low) 탐색하여 
// 만약 현재의 arr[j]가 피벗보다 작거나 같다면 i를 증가시키고, 
// arr[i]와 arr[j]를 스왑 
// 마지막에 i+1 인덱스 요소와 피벗을 스왑한다. 
/*
 * 
 * 
 * 
pivot으로 최 우측 element를 사용 
partition (arr[], low, high)
{
    // pivot (Element to be placed at right position)
    pivot = arr[high];  
    i = (low - 1)  // Index of smaller element
    for (j = low; j <= high- 1; j++)
    {
        // If current element is smaller than or
        // equal to pivot
        if (arr[j] <= pivot)
        {
            i++;    // increment index of smaller element
            swap arr[i] and arr[j]
        }
    }
    swap arr[i + 1] and arr[high])
    return (i + 1)
}
*/

public class QuickSort {
	static void quicksort(int arr[], int low, int high){
		
		if (low < high){
			int pivot = partition (arr, low, high);
			quicksort(arr, low, pivot-1);
			quicksort(arr, pivot+1, high);
		}
			
	}
	static int partition(int arr[], int low, int high){
		int pivot = arr[high];
		int i = low -1;
		for(int j = low; j < high; j++){
			if(arr[j] < pivot){
				i++;
				//swap 
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		
		return i+1;
	}
	 static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	 
	public static void main(String[] args) {
		 int arr[] = {10, 7, 8, 9, 1, 5};
		 int n = arr.length;
	 
         QuickSort ob = new QuickSort();
         ob.quicksort(arr, 0, n-1);
 
         System.out.println("sorted array");
         printArray(arr);
	}
}
