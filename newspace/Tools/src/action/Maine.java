package action;

import java.util.Scanner;

public class Maine {
	static int stepnum, n, m, startx, starty, endx, endy, find, canstep,
			maxstep = -1;
	static char[][] data;

	static void nextstep(int x, int y) {
		int flag = 0;
		canstep++;
		if (find == 1) {
			return;
		}
		if (x == n - 1 && y == m - 1) {
			find = 1;
			if (maxstep < canstep) {
				maxstep = canstep;
			}
			return;
		}
		for (int i = x + 1, j = 0; j < stepnum; j++) {
			if (i < 0 || i > n) {
				continue;
			}
			if (data[i][y] == '.') {
				flag++;
			}
		}
		if (flag == stepnum) {
			nextstep(x + 4, y);
			canstep--;
		}
		flag = 0;
		for (int i = x - 1, j = 0; j < stepnum; j++) {
			if (i < 0 || i > n) {
				continue;
			}
			if (data[i][y] == '.') {
				flag++;
			}
		}
		if (flag == stepnum) {
			nextstep(x - 4, y);
			canstep--;
		}

		flag = 0;
		for (int i = x - 1, j = 0; j < stepnum; j++) {
			if (i < 0 || i > n) {
				continue;
			}
			if (data[x][i] == '.') {
				flag++;
			}
		}
		if (flag == stepnum) {
			nextstep(x, y - 4);
			canstep--;
		}

		flag = 0;
		for (int i = x + 1, j = 0; j < stepnum; j++) {
			if (i < 0 || i > n) {
				continue;
			}
			if (data[x][i] == '.') {
				flag++;
			}
		}
		if (flag == stepnum) {
			nextstep(x, y + 4);
			canstep--;
		}

	}

	public static void main(String[] arg) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		data = new char[n][m];
		for (int i = 0; i < n; i++) {
			String tString = sc.next();
			for (int j = 0; j < m; j++) {
				data[i][j] = tString.charAt(j);
			}
		}
		startx = sc.nextInt();
		starty = sc.nextInt();
		stepnum = sc.nextInt();
		nextstep(startx, starty);
		if (maxstep==-1) {
			System.out.println(-1);
		}else {
			System.out.println(maxstep);
		}

	}
}