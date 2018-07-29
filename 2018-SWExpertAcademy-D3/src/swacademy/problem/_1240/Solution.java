package swacademy.problem._1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int zero [] = { 0, 0, 0, 1, 1, 0, 1 };	//8+16+64 = 88
	static int one  [] = { 0, 0, 1, 1, 0, 0, 1 };	//4+8+64 = 76
	static int two  [] = { 0, 0, 1, 0, 0, 1, 1 };	//4+32+64 = 100
	static int three[] = { 0, 1, 1, 1, 1, 0, 1 };	//2+4+8+16+64 = 94
	static int four [] = { 0, 1, 0, 0, 0, 1, 1 };	//2+32+64 = 98
	static int five [] = { 0, 1, 1, 0, 0, 0, 1 };	//2+4+64 = 70
	static int six  [] = { 0, 1, 0, 1, 1, 1, 1 };	//2+8+16+32+64 = 122
	static int seven[] = { 0, 1, 1, 1, 0, 1, 1 };	//2+4+8+32+64 = 110
	static int eight[] = { 0, 1, 1, 0, 1, 1, 1 };	//2+4+16+32+64 = 118
	static int nine [] = { 0, 0, 0, 1, 0, 1, 1 };	//8+32+64 = 104
	static int T, N, M;
	static int input[][];
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			input = new int[N][M];
			for(int i=0; i<N; i++){
				String str = br.readLine();
				for(int j=0; j<M; j++){
					input[i][j] = str.charAt(j)-'0';
				}
			}
//			print();
			String tmp = solve(input);
			int ret = 0;
			ret = check(tmp);
			System.out.println("#"+t+" "+ret);
		}
	}
	
	public static String solve(int arr[][]){
		String ret = "";
		for(int i=0; i<N; i++){
			if(ret.length()==8)
				break;
			//7개씩 끊어서 체크
			
			
			for(int j=M-1; j>=6; j--){
				int bit = 0;
				if(arr[i][j]==0)continue;	//뒤에서부터 체크해서 1이 나오면 그때부터 코드 검사 
				else{
					for(int k=0; k<=6; k++){
						if(arr[i][k+j-6]==0)continue; //0 pass
						else{
							bit+=1<<k;
						}
					}
					
					switch(bit) {
						case 88:
							ret="0"+ret;
							break;
						case 76:
							ret="1"+ret;
							break;
						case 100:
							ret="2"+ret;
							break;
						case 94:
							ret="3"+ret;
							break;
						case 98:
							ret="4"+ret;
							break;
						case 70:
							ret="5"+ret;
							break;
						case 122:
							ret="6"+ret;
							break;
						case 110:
							ret="7"+ret;
							break;
						case 118:
							ret="8"+ret;
							break;
						case 104:
							ret="9"+ret;
							break;
					}
					j-=6;
				}
			}
		}
		return ret;
	}
	public static int check(String str){
		int tmp[] = new int[8];
		int ret=0;
		for(int i=0; i< 8; i++){
			tmp[i] = str.charAt(i)-'0';
			ret +=tmp[i];
		}

//		for(int i=0; i<8; i++){
//			System.out.print(tmp[i]+" ");
//		}System.out.println();
//		
		int first = ( (tmp[0]+tmp[2]+tmp[4]+tmp[6])*3 +tmp[1]+tmp[3]+tmp[5]+tmp[7] );
		if(first%10==0){
//			System.out.println("ret : "+ret);
			return ret;
		}
		else{
			return ret=0;
		}
	}
	public static void print(){
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				System.out.print(input[i][j]);
			}System.out.println();
		}
	}
}
