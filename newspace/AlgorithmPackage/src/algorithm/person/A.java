package algorithm.person;

public class A {
	static int sametime=0;//定义一个统计重复次数的常量
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry= {88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262};
		for (int i = 0; i < arry.length&&sametime!=2; i++) {
			sametime =0;
			for (int j = i+1; j < arry.length; j++) {
				if (arry[i]==arry[j]) {
					sametime++;
				} 
				if (sametime==2) {
					System.out.println(arry[i]);
				}
			}
		}
		if (sametime==2) {
			System.out.println("需要找的数字已找到");
		}else {
			System.out.println("需要找的数字不存在");
		}
	}

}
