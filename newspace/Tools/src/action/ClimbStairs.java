package action;

import java.util.Scanner;

public class ClimbStairs {

	//计算爬楼题问题，一共有几种爬法。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System .in);
		System.out.println("----------请输入要爬的楼层数，回车结束----------------");
		int num=scanner.nextInt();
		System.out.println("一共有 "+NumberWays_ClimbStair(num)+" 种爬法。");
		scanner.close();
	}
	public static int NumberWays_ClimbStair(int N){
		if (N>0) {
			int value;
		switch (N) {
		case 0:value =0;
			break;
		case 1:value=1;
			break;
		case 2:value=2;
			break;
		default:value =NumberWays_ClimbStair(N-1)+NumberWays_ClimbStair(N-2);//递归思想
			break;
		}
		return value;
		}
		return -1;
	}

}
