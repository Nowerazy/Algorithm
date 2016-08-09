package action;

import java.util.Scanner;

public class Dfs {

	public static void dfs(int[][] sour, int x, int y, int temp,int[][] visit) {
		if (x>=sour.length||y>=sour[0].length||x<0||y<0||sour[x][y] == 1||visit[x][y]==1) {
			return;
		}
		if (sour[x][y] == 2) {
			temp++;
			visit[x][y]=1;
			System.out.println("tmp[" + x + "][" + y + "]=" + temp);
			dfs(sour, x + 1, y, temp,visit);
			dfs(sour, x, y + 1, temp,visit);
			dfs(sour, x - 1, y, temp,visit);
			dfs(sour, x, y - 1, temp,visit);
		}else {
			System.out.println("Xtmp[" + x + "][" + y + "]=" + temp);
			dfs(sour, x + 1, y, temp,visit);
			dfs(sour, x, y + 1, temp,visit);
			dfs(sour, x - 1, y, temp,visit);
			dfs(sour, x, y - 1, temp,visit);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T_case = scanner.nextInt();
		for (int tcase = 1; tcase <= T_case; tcase++) {
			int N = scanner.nextInt();
			int data[][] = new int[N][10];
			int visit[][] =new int[N][10];
			for (int j = 0; j < data.length; j++) {
				for (int i = 0; i < data[0].length; i++) {
					data[j][i] = scanner.nextInt();
				}
			}

			int temp =0;
			dfs(data, N-1, 0, temp,visit);
			for (int i = 0; i < visit.length; i++) {
				for (int is : visit[i]) {
				System.out.print(is+" ");
			}
				System.out.println();
			}
			
		}

	}
}
