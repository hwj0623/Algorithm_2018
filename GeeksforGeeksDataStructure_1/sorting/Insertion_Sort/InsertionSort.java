package Insertion_Sort;

public class InsertionSort {
	void insertionSort (int arr[]){
		int n = arr.length;
		for(int i=1; i<n; i++){
			int cur = arr[i];
			int j = i-1;
			//current 요소 보다 큰 arr[0..i-1] 을
			//각각 한칸씩 뒤로 미루는 작업 수행 
			while(j>=0 && arr[j] > cur){
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = cur;
		}
	}
	/* A utility function to print array of size n*/
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
        int arr[] = {12, 11, 13, 5, 6};
 
        InsertionSort ob = new InsertionSort();        
        ob.insertionSort(arr);
         
        printArray(arr);
    }
}
