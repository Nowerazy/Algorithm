package algorithm.person;

public class CircleDraw {
	//用*号画圆

	public static void draw(int radius) {
		int x=0;
		int y=0;
		// TODO Auto-generated method stub
		for (int i = 0; i <= radius*2; i++) {
			for (int j = 0; j <= radius*2; j++) {
				double changfang = Math.pow(Math.abs(j - radius)/1.3,2);
				double kuanfang = Math.pow(Math.abs(i - radius),2);
				boolean sign = changfang+kuanfang<=Math.pow(radius,2)&&changfang+kuanfang>Math.pow(radius-1,2);
				if (sign) {
					if (y!=i) {
						//换行了
						System.out.println();
						for (int k = 0; k < j; k++) {
							System.out.print(" ");
						}
						System.out.print("*");
					}else {
						//未换行
						if (i==0) {
							for (int k = 0; k < j-x; k++) {
								System.out.print(" ");
							}
							System.out.print("*");
						}else {
							for (int k = 0; k < j-x-1; k++) {
								System.out.print(" ");
							}
							System.out.print("*");
						}
						
					}
					
//					if (!flag) {
//						System.out.println("*");
//					}else {
						
					x=j;
					y=i;
				}
			}
		}
		System.out.println();
	}

}
