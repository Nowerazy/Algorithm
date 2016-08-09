package action;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class MyTest {

	public static void main(String[] args)throws Exception {
		
		Random roun = new Random();
		System.out.println("roun.nextBoolean():"+roun.nextBoolean());
		byte[] bte = new byte[4];
		roun.nextBytes(bte);
		System.out.println(Arrays.toString(bte));
		byte b=0x7;
		short s=0x6ff;
		int i=55;
		long l=0xffffl;
		char c='b';
		float f=0.255f;
		double d=0.2e-5;
		
		
		//四舍五入
		double d1 = 111231.5585;
		BigDecimal bi =new BigDecimal(d1);
		double f1 = bi.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("first way:"+f1);
		//第二种
		java.text.DecimalFormat df=new java.text.DecimalFormat("#.##");   
		  System.out.println("Second way:"+df.format(d1)); 
		
		 // 第三种，通过printf实现
		  System.out.print("third way:");
		System.out.printf("%3.2f", d1);
		System.out.println();
		System.out.printf("%.1f; %.3f; %f%n", -756.453f, 7464.232541d, 7464.23);
	}
}
