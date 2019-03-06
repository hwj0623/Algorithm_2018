package BucketSort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	static void bucketSort(double arr[], int n) {
		// 1) n empty 버킷 생성
		ArrayList<ArrayList<Double>> bucketList = new ArrayList<ArrayList<Double>>(n);
		for(int i=0; i<n; i++){
			ArrayList<Double> tmp = new ArrayList<Double>();
			bucketList.add(tmp);
		}
		// 2) 배열의 요소들을 각각 다른 버킷들에 넣는다. 
		for (int i = 0; i < n; i++) {
			int bi = (int) (n * arr[i]); // index in bucket
			bucketList.get(bi).add(arr[i]);
		}
		
		// 3)  각각의 버킷을 소팅
		for(int i=0; i<n; i++){
			Collections.sort(bucketList.get(i));
		}
		
		// 4) 모든 버킷들을 arr[]에 붙여넣는다
		int idx = 0;
		for(int i=0; i<n; i++){
			for(int j= 0; j<bucketList.get(i).size(); j++){
				arr[idx++] = bucketList.get(i).get(j);
			}
		}
	}

	public static void main(String[] args) {
	    double arr[] = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
	    int n = arr.length; 
	    bucketSort(arr, n);
	    
	    System.out.println("Sorted array is ");
	    for(int i=0; i<n; i++)
	    	System.out.print(arr[i]+" ");
		System.out.println();
	}
}
