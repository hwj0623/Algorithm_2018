package swacademy.problem.p_1211;

/**
 * Ladder1
 */
import java.util.Scanner;

public class Solution {

	static int map[][];
	static final int UP = 0;
	static final int LEFT = 1;
	static final int RIGHT = 2;
	static int retX = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int test = sc.nextInt();
			map = new int[100][100];
			int startX = 0;
			int startY = 0;
			int initDir = UP;
			for (int i = 0; i < 100; i++) {
				if (i != 99) {
					for (int j = 0; j < 100; j++) {
						map[i][j] = sc.nextInt();
					}
				} else {
					for (int j = 0; j < 100; j++) {
						map[i][j] = sc.nextInt();
						if (map[i][j] == 2) {
							startX = j;
							startY = i;
						}
					}
				}
			}
			move(startY, startX, initDir);
			System.out.println("#" + t + " " + retX);
		}
	}

	public static void move(int y, int x, int dir) {

		if (y <= 0) {
			retX = x;
			return;
		}

		if (dir == UP) {
			while (true) {
				if (y <= 0) {
					retX = x;
					break;
				}
			
				// check if right-way is open
				if (y >= 0 && x < 99) {
					if (map[y][x + 1] == 1) {
						move(y, x , RIGHT);
						break;
					}
				}
				// check if left-way is open
				if (y >= 0 && x > 0) {
					if (map[y][x - 1] == 1) {
						move(y, x , LEFT);
						break;
					}
				}
				
				y--; // move up

			}
		} else if (dir == LEFT) {
			while (true) {
				if (y <= 0) {
					break;
				}
				if ((x-1) >= 0 && y > 0) {
					x--; // move left
					if (map[y - 1][x] == 1) {
						move(y - 1, x, UP);
						break;
					}
				}
			}
		} else if (dir == RIGHT) {
			while (true) {
				if (y < 0) {
					break;
				}
				if ((x+1) < 100 && y > 0) {
					x++;
					if (map[y - 1][x] == 1) {
						move(y - 1, x, UP);
						break;
					}
				}
			}
		}
	}
}
