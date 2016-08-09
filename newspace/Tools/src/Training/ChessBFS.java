package Training;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChessBFS {

	//以马走日的方式，遍历。
	static int map[][];
	static int sx, sy, ex, ey;
	static int n, m;
	static int vis[][];
	static int dir[][] = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 },
			{ -1, -2 }, { -2, 1 }, { -2, -1 } };
	private static Scanner sc;

	// 实现马走日
	static void bfs() {
		Queue<node> q = new LinkedList<node>();
		node nod = new node(sx, sy, 0);
		q.offer(nod);
		boolean mark = false;
		while (!q.isEmpty()) {
			node currentnode = q.peek();
			q.poll();
			if (currentnode.x == ex && currentnode.y == ey) {
				if (currentnode.dis == 0)
					break;
				System.out.println(currentnode.dis);
				mark = true;
				break;
			}
			int obstaclex,obstacley;
			node nextPossibleNode;
			for (int i = 0; i < 8; i++) {
				nextPossibleNode = new node();
				nextPossibleNode.x = currentnode.x + dir[i][0];
				nextPossibleNode.y = currentnode.y + dir[i][1];
				obstaclex = currentnode.x + dir[i][0] / 2;// 马当前方向上前面的一个坐标
				obstacley = currentnode.y + dir[i][1] / 2;
				// 限制条件
				if (nextPossibleNode.x >= 0 && nextPossibleNode.y >= 0 && nextPossibleNode.x < n && nextPossibleNode.y < m && obstaclex < n
						&& obstacley < m && obstaclex >= 0 && obstacley >= 0)
					if (vis[nextPossibleNode.x][nextPossibleNode.y] != 1 && map[nextPossibleNode.x][nextPossibleNode.y] != 3
							&& map[obstaclex][obstacley] != 3) {
						nextPossibleNode.dis = currentnode.dis + 1;
						vis[nextPossibleNode.x][nextPossibleNode.y] = 1;
						q.offer(nextPossibleNode);
					}
			}
		}
		if (!mark)
			System.out.println("-1\n");
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int d;
		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		vis = new int[n][m];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++) {
				d = sc.nextInt();
				System.out.print(" " + d);
				map[i][j] = d;
				if (map[i][j] == 1) {
					sx = i;
					sy = j;
				} else if (map[i][j] == 2) {
					ex = i;
					ey = j;
				}
			}
			System.out.println();}
		bfs();
	}

}

class node {
	int x, y;
	int dis;

	node() {
		super();
	}

	node(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

}