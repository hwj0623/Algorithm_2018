package sol2;

class Pair {
	private int nativeArr[];
	private int pairArr[];
	private int pairValue;
	private int pairCnt;

	public Pair() {
	}

	public Pair(int arr[]) {
		this.nativeArr = new int[arr.length];
		this.pairArr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			nativeArr[i] = arr[i];
		}
		this.pairCnt = 0;
		this.pairValue = 0;
	}

	// pairValue와 pairCnt를 획득하기 위한 함수
	public void makePair() {

		for (int i = 0; i < this.nativeArr.length; i++) {
			this.pairArr[nativeArr[i]]++;
			// Pair 발견시, 페어카운트 먼저 갱신여부 고려
			if (pairArr[nativeArr[i]] >= 2) {
				// 현재 갱신된 n페어가 저장된 값보다 더 크면 (2페어 < 3페어) 갱신
				if (pairArr[nativeArr[i]] > pairCnt) {
					this.pairCnt = pairArr[nativeArr[i]];
					this.pairValue = nativeArr[i];
				}
				// 현재 갱신된 n페어가 저장된 페어와 같다면 페어 숫자(2,2 < 7,7)를 비교 
				else if(pairArr[nativeArr[i]] == pairCnt){
					if(nativeArr[i] > pairValue){
						pairValue = nativeArr[i];
					}
				}
			}
		}
	}
	
	public int getPairCnt(){
		return this.pairCnt;
	}
	
	public int getPairValue(){
		return this.pairValue;
	}
}
public class Solution {

	public static void main(String[] args) {
//		int arr1[] = {1, 5, 7, 2, 9};
//		int arr2[] = {2, 3, 9, 4, 8};
		
//		int arr1[] = {1, 4, 1, 3, 5};
//		int arr2[] = {9, 2, 3, 1, 3};
//		
//		int arr1[] = {1, 1, 9, 4, 1};
//		int arr2[] = {2, 3, 3, 9, 9};
//		
		int arr1[] = {1, 4, 9, 4, 1};
		int arr2[] = {9, 3, 1, 9, 1};
		System.out.println(solution(arr1, arr2));
		
	}
	/**
	 * 규칙 
	 * 1) 각 배열의 Pair를 비교하여 둘 중 어느쪽이 더 큰 Pair값을 갖는지 확인하여
	 *   - arr1 배열이 더 큰 pair값 지니면 1 리턴
	 *   - arr2 배열이 더 큰 pair값 지니면 2 리턴
	 *   - 양쪽 모두 페어 없으면 0
	 *   - 양쪽에 같은 페어 값이면 0
	 *   
	 * 2) Pair 조건
	 *  - 같은 숫자 2개인 Pair < 3개인 Pair < 4개인 Pair
	 *  - 2 Pair == 2 Pair 라면
	 *    더 큰 숫자 Pair 쌍이 더 큰 값을 갖는다.
	 *  
	 * 3) 숫자 Pair가 2벌 이상이라면
	 *  - 더 큰 숫자로 된 Pair만 고려한다. 
	 */
	
	
	public static  int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        Pair pair1 = new Pair(arr1);
        Pair pair2 = new Pair(arr2);
        pair1.makePair();
        pair2.makePair();
        
        answer = compareToArrays(pair1, pair2);
        return answer;
	}
	
	public static int compareToArrays(Pair pair1, Pair pair2) {
		int answer = 0;
		int arr1Cnt = pair1.getPairCnt();
		int arr1Value = pair1.getPairValue();

		int arr2Cnt = pair2.getPairCnt();
		int arr2Value = pair2.getPairValue();

		// 카운트 값에 비중을 더 준다
		int arr1Total = arr1Cnt * 10 + arr1Value;
		int arr2Total = arr2Cnt * 10 + arr2Value;

		// 1) 양쪽 배열에서 페어 숫자가 같은 경우
		if (arr1Total == arr2Total) {
			return answer = 0;
		}
		// 2)페어 없는 경우
		if (arr1Cnt == 0 && arr2Cnt == 0) {
			return answer = 0;
		}
		// 두 페어의 값을 비교한다.
		// 페어 카운트 값에 가중치를 부여하였기 때문에
		// n+1쌍 페어의 어떤 수도 n쌍 페어의 어떤 수보다 페어 비굣값이 더 크다.
		if (arr1Total > arr2Total) {
			return answer = 1;
		} else {
			return answer = 2;
		}
	}
}
