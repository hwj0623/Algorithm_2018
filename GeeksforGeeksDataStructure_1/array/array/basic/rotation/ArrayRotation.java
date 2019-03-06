package array.basic.rotation;

public class ArrayRotation {

	// Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
	// elements.
	// 1 2 3 4 5 6 7
	// Rotation of the above array by 2 will make array
	// 3 4 5 6 7 1 2

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
	
		// Method (Rotate one by one)
		leftRotate(arr, 2, arr.length);
		printArray(arr);
		
		int arr2[] = {1,2,3,4,5,6,7};
	}
	public static void printArray(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
	// Method 2 (Rotate one by one)
	// arr에 대해, d번 회전, arr의 크기는 n
	public static int[] leftRotate(int arr[], int d , int n){
		for(int i=0; i<d;i++){
			int tmp = arr[0];
			for(int j=0; j<arr.length-1; j++){
				arr[j]=arr[j+1];
			}
			arr[arr.length-1] = tmp;
		}
		return arr;
	}
	
	// Method 3 (Juggling Algorithm)
//	This is an extension of method 2.
//  Instead of moving one by one, divide the array in different sets
//	where number of sets is equal to GCD of n and d and move the elements within sets.
//	If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
//  https://www.geeksforgeeks.org/?p=2398
//	Here is an example for n =12 and d = 3. GCD is 3 and
	
	public static void leftRotateJuggling(int arr[], int d, int n){
		int i,j, k, tmp;
		for(i=0; i< gcd(d, n); i++){
			//move i-th values of blocks
			tmp = arr[i];
			j=i;
			while(true)
			{
				k=j+d;
				if(k>=n)
					k=k-n; 
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=tmp;
		}
	}
	public static int gcd(int a, int b){
		if(b==0)
			return a;
		else 
			return (gcd(b, a%b));
	}
}
