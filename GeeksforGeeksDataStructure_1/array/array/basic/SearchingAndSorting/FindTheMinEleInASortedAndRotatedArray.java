package array.basic.SearchingAndSorting;

// 정렬된 & 회전된 배열에서 최솟값 찾기 
// 선형 탐색시 O(n)
// 이진 탐색 기법을 쓴다. O(lg n)
//
public class FindTheMinEleInASortedAndRotatedArray {

	static int findMin(int arr[], int low, int high) {

		// 배열이 회전된 상태가 아닌 경우에 적용된다.
		if (high < low)
			return arr[0];

		// 만약 한 원소만 남았다면
		if (high == low)
			return arr[low];

		// mid 값을 찾는다.
		int mid = low + (high - low) / 2; /* (low+high) /2 */

		// Check if element (mid+1) is min element,
		// Consider case like {3,4,5,1,2}
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);

		return findMin(arr, mid + 1, high);
	}

	public static void main(String[] args) {
		int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findMin(arr1, 0, n1-1));
 
        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findMin(arr2, 0, n2-1));
 
        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ findMin(arr3, 0, n3-1));
 
        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ findMin(arr4, 0, n4-1));
 
        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ findMin(arr5, 0, n5-1));
 
        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ findMin(arr6, 0, n1-1));
 
        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ findMin(arr7, 0, n7-1));
 
        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ findMin(arr8, 0, n8-1));
 
        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMin(arr9, 0, n9-1));
	}

}
