package Training;

import java.util.Scanner;

public class CatchCow_linklistqueue {
	static int N, K;
	static byte[] vis;
	static Queue queue;
	static int nextP;
	private static Scanner scanner;

	static void bfs() {
		while (!queue.isEmpty()) {
			Position currentPosition = queue.poll();

			if (currentPosition.x == K) {
				System.out.println(currentPosition.step);
				break;
			}
			nextP = currentPosition.x - 1;
			if (nextP >= 0 && nextP <= 100000 && vis[nextP] != 1) {
				Position tempPosition = new Position(nextP,
						currentPosition.step + 1);
				vis[nextP]=1;
				if (tempPosition.x == K) {
					System.out.println(tempPosition.step);
					break;
				}
//System.out.println("[Queue get in ]" + tempPosition);
				queue.offer(tempPosition);
			}
			nextP = currentPosition.x + 1;
			if (nextP >= 0 && nextP <= 100000 && vis[nextP] != 1) {
				Position tempPosition = new Position(nextP,
						currentPosition.step + 1);
//System.out.println("[Queue get in ]" + tempPosition);
				vis[nextP]=1;
				if (tempPosition.x == K) {
					System.out.println(tempPosition.step);
					break;
				}
				queue.offer(tempPosition);

			}
			nextP = currentPosition.x * 2;
			if (nextP >= 0 && nextP <= 100000 && vis[nextP] != 1) {
				Position tempPosition = new Position(nextP,
						currentPosition.step + 1);
//System.out.println("[Queue get in ]" + tempPosition);
				vis[nextP]=1;
				if (tempPosition.x == K) {
					System.out.println(tempPosition.step);
					break;
				}
				queue.offer(tempPosition);
			}

		}
	}

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		vis = new byte[100001];
		queue = new Queue();
		queue.offer(new Position(N, 0));
		vis[N] = 1;
		bfs();
	}
}



class LinkList {
	Position dataPosition=new Position(0, 0);
	LinkList nextP;

	public LinkList(Position dataPosition, LinkList nextP) {
		this.dataPosition = dataPosition;
		this.nextP = nextP;
	}

}

class Queue {
	LinkList firstLinkList = new LinkList(null, null);
	LinkList lastLinkList = firstLinkList;
	boolean isempty = true;

	public Queue() {

	}

	void offer(Position data) {
		if (isempty == true) {
			firstLinkList.dataPosition = data;
			isempty = false;
		} else {
			lastLinkList.nextP = new LinkList(data, null);
			lastLinkList = lastLinkList.nextP;

		}
	}

	Position poll() {
		if (isempty != true) {
			Position t = firstLinkList.dataPosition;
			firstLinkList = firstLinkList.nextP;
			if (null == firstLinkList) {
				firstLinkList=new LinkList(null, null);
				lastLinkList = firstLinkList;
				isempty = true;
			}
			return t;
		}
		return null;
	}

	boolean isEmpty() {
		return isempty;
	}
}
