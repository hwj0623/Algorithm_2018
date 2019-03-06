package sol1;

import java.util.ArrayList;

/**
 * 
 * @author hw
 * 제한사항
 * 배열 arr의 크기 : 100 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 */
public class Solution {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,3,3,0,1,1};
		int arr2[] = {4,4,4,3,3};
		int arr3[] = {1,2,3,4};

		solution(arr);
		System.out.println("========");
		solution(arr2);
		System.out.println("========");

		solution(arr3);

	}
    public static int[] solution(int[] arr) {
        int[] answer = {};
        //현재 숫자와 다음 숫자 비교,
        //현재 숫자가 이미 연속으로 나타나는 숫자라면 boolean 값을 true로 설정하고,
        //연속하지 않는 숫자가 나타나는 경우 이를 저장한다.
        //배열의 크기가 100이하이므로 O(n^2)으로 하여도 효율성에서 크게 저하되지는 않는다고 판단.
        
        //다만 첫번째 예제에서 1!=3이라고 해서 outer loop 에서 index 1부터 시작할 필요는 없다.
        //따라서 index 2 부터 반복문 시작하도록 outer loop index 를 보정한다.
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length-1; i++){
        	int j=i+1;
        	//2회이상 연속된다면 반복 시도 
        	if(arr[i]==arr[j]){ //바로 이웃한 원소끼리 연속한 경우 
        		while(arr[i]==arr[j] && j<=arr.length){
        			j++;
        			
        			//계속 연속한다면 반복 
        			if(j<arr.length && arr[i] ==arr[j])
        				continue;
        			else { //불일치 구간 나오면 탈출 
					list.add(arr[i]);
					i=j-1;	
					break;
            			}
            		}
        	}
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
        	answer [i] = list.get(i);
        }

        return answer;
    }
	
}
