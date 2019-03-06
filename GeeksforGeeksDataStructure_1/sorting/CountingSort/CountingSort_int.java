package CountingSort;

public class CountingSort_int {

	void countingSort2(int arr[]){
		int n = arr.length;
		
		//정렬될 숫 배열 output을 만든다
		int output[] = new int[n];
		
		//카운트 배열을 만들어서 각각의 문자배열을 세고 저장한다.
		//0으로 초기화 
		int count[] = new int[arr.length];
		
		//각각의 문자를 세서 그 카운트를 저장한다.
		for(int i=0; i<n; i++){
			++count[arr[i]];
		}
		
		// count[i]를 변화시켜서, count[i]가 output 배열에서
		// 해당 문자의 실제 위치를 포함하도록 한다.
		for(int i=1; i<=arr.length-1; i++){
			count[i] += count[i-1];
		}
		
		//output 배열을 채워 넣는다. 
		for(int i=0; i<n; i++){
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]]; //카운트 배열에서 카운트를 1씩 감소  
		}
		
		//output배열의 값을 arr배열에 다시 복사
		for(int i = 0; i<n; i++)
			arr[i] = output[i];
	}
	 public static void main(String args[])
	    {
	        CountingSort_int ob = new CountingSort_int();
	        int arr[] = {1, 3, 3, 3, 1, 5, 1,
	                      7, 8, 2, 2, 3, 2, 1, 1, 1
	                     };
	 
	        ob.countingSort2(arr);
	 
	        System.out.print("Sorted integer array is ");
	        for (int i=0; i<arr.length; ++i)
	            System.out.print(arr[i]);
	    }
}

