package Training;

import java.util.Scanner;

class ChachCow {

	static int N,K;
	static byte[] vis;
	static Queuezy queue;
	static int nextP;
	private static Scanner scanner;
	static void bfs(){
		while (!queue.isEmpty()) {
			Position currentPosition=queue.poll();
			
			if (currentPosition.x==K) {
				System.out.println(currentPosition.step);
				break;
			}
			nextP=currentPosition.x-1;
			if (nextP>=0&&nextP<=100000&&vis[nextP]!=1) {
				Position tempPosition=new Position(nextP, currentPosition.step+1);
				if (tempPosition.x==K) {
					System.out.println(tempPosition.step);
					break;
				}vis[nextP]=1;
//System.out.println("[Queue get in ]"+tempPosition);
				queue.offer(tempPosition);
			}
			nextP=currentPosition.x+1;
			if (nextP>=0&&nextP<=100000&&vis[nextP]!=1) {
				Position tempPosition=new Position(nextP, currentPosition.step+1);
//System.out.println("[Queue get in ]"+tempPosition);
				if (tempPosition.x==K) {
					System.out.println(tempPosition.step);
					break;
				}vis[nextP]=1;
				queue.offer(tempPosition);
				
			}
			nextP=currentPosition.x*2;
			if (nextP>=0&&nextP<=100000&&vis[nextP]!=1) {
				Position tempPosition=new Position(nextP, currentPosition.step+1);
//System.out.println("[Queue get in ]"+tempPosition);
				if (tempPosition.x==K) {
					System.out.println(tempPosition.step);
					break;
				}vis[nextP]=1;
				queue.offer(tempPosition);
			}
			
		}
	}
	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		N=scanner.nextInt();
		K=scanner.nextInt();
		vis=new byte[100001];
		Position startPosition =new Position(N,0);
		queue=new Queuezy();
		queue.offer(startPosition);
//System.out.println("[Queue get in ]"+startPosition);
		vis[N]=1;
		bfs();
		
	}

}
 class Position{
	int x;
	int step;
	 Position(int x, int step) {
		this.x = x;
		this.step = step;
	}
	@Override
	public String toString() {
		String r ="positionInfor:\n";
		r+="x="+x+",step="+step+"\n";
		return r;
	}
	
}
class Queuezy{
	 static int containsNum=10;
	 static Position[] contains;
	 static int cur=0;
	 static int top=0;
	 boolean isempty=true;
	 
	public Queuezy() {
		Queuezy.contains = new Position[containsNum];
	}
	void offer(Position data){
		 if (isempty==true||cur!=top) {
			contains[cur]=data;
			cur=(cur+1)%containsNum;
			
		}else {
			Position[] containsTemp=new Position[containsNum*2];
			int i=0;
			containsTemp[i++]=contains[top];
			for (int j = top+1; j !=top; ) {
				containsTemp[i++]=contains[j++];
				j=j%containsNum;
			}
			cur=containsNum;
			top=0;
			containsNum*=2;
			contains=containsTemp;
			contains[cur]=data;
			cur=(cur+1)%containsNum;
		} 
		 isempty=false;
		 
	 }
	Position poll(){
		 if (isempty!=true) {
			 Position t=contains[top];
		 top=(top+1)%containsNum;
		 if (cur==top) {
			isempty=true;
		}
		 return t;
		}
		 return null;
	 }
	 boolean isEmpty(){
		 return isempty;
	 }
 }