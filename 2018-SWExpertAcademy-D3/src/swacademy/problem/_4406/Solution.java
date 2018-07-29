package swacademy.problem._4406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//4406. 모음이 보이지 않는 사람 D3
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringBuilder sb = new StringBuilder();
             
            String tmp = br.readLine();
            char arr[] = tmp.toCharArray();
            for(int i=0; i<arr.length; i++){
                if(arr[i]!='a' &&arr[i]!='e' && arr[i] !='i'&& arr[i] !='o'&&arr[i]!='u'){
                    sb.append(arr[i]);
                }
            }
             
            System.out.println("#"+t+" "+sb.toString());
        }
	}

}
