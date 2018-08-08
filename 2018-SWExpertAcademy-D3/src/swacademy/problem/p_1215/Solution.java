package swacademy.problem.p_1215;

/**
 *Palindrome 1215
 */
import java.util.Scanner;
 
public class Solution {
    static char arr[][];
    static final int VERTICAL = 1;
    static final int HORIZONTAL = 0;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            arr = new char[8][8];
            int len = sc.nextInt(); // 찾아야 하는 회문의 길이
            sc.nextLine();
            for (int i = 0; i < 8; i++) {
                String str = sc.nextLine();
                arr[i] = str.toCharArray();
            }
            int cnt = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - len; j++) {
                    if (isPal(i, j, len, HORIZONTAL)) {
                        cnt++;
                    }
                }
            }
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i <= 8 - len; i++) {
                    if (isPal(i, j, len, VERTICAL)) {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
 
    // arr[i][j]에서 시작하는 길이 l짜리 회문 구하기
    public static boolean isPal(int i, int j, int l, int d) {
        boolean palindrome = true;
        if (d == HORIZONTAL) {
            int dest = j + l - 1;
            // System.out.println("시작지점이 : "+i + ", " + j);
            for (int k = j; k < j + (l / 2); k++) {
                if (arr[i][k] != arr[i][dest--]) {
                    // System.out.println(k+", "+(dest--)+" // "+arr[i][k] + " " + arr[i][dest--] + " is not same");
                    palindrome = false;
                    break;
                }
            }
        } else {
            int dest = i + l - 1;
            for (int k = i; k < i + (l / 2); k++) {
                if (arr[k][j] != arr[dest--][j]) {
                    palindrome = false;
                }
            }
        }
//      System.out.println("from i, j : " + i + ", " + j + " is palindrome : " + palindrome);
        return palindrome;
    }
}
