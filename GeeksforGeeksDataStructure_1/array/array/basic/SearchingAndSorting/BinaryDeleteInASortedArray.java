package array.basic.SearchingAndSorting;

public class BinaryDeleteInASortedArray {
	// 이진탐색 
	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		// mid = low + (high-low)/2;
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, mid + 1, high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}
	
	
	static int deleteElement(int arr[], int n, int key) {
		int pos = binarySearch(arr, 0, n-1, key);
		if(pos==-1){
			System.out.println("Element is not found");
			return n;
		}
		int i;
		//삭제한 원소의 오른쪽 원소들을 shift 
		for(i=pos; i<n-1; i++){
			arr[i] = arr[i+1];
		}
		
		return n-1; //줄어든 사이즈를 반환 
	}
	
	
	
	public static void main(String[] args) {
		 int i;
	        int arr[] = {10, 20, 30, 40, 50};
	      
	        int n = arr.length;
	        int key = 30;
	      
	        System.out.print("Array before deletion:\n");
	        for (i=0; i<n; i++)
	          System.out.print(arr[i] + " ");
	      
	        n = deleteElement(arr, n, key);
	      
	        System.out.print("\n\nArray after deletion:\n");
	        for (i=0; i<n; i++)
	          System.out.print(arr[i] + " ");
	}
}
