package action;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InterestApp {

	static int Evensquare(int sum, int a) {
		int i;
		i = (int) Math.pow(a, 2);
		sum += i;
		return sum;
	}

	static int Oddcube(int sum, int a) {
		int i;
		i = (int) Math.pow(a, 3);
		sum += i;
		return sum;
	}
	public static void main(String[] args)throws Exception  {
		
		// 使用猎豹浏览器打开网页。
		String cmmdString = "C:/Users/ZhaoYan/AppData/Local/liebao/liebao.exe ";
		String urlString = "https://www.baidu.com";
//		Runtime rt= Runtime.getRuntime();
//		try {
//			rt.exec(cmmdString+urlString);
//			rt.exec("notepad");
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		// 输入n个数，进行从小到达排序，重复数字只出现一次，其他省略。
				Scanner scanner=new Scanner(System.in);
				System.out.println("---------输入要排序数字的个数--------");
				int n=scanner.nextInt();
				int[] inputArray=new int[n];
				Map<String, String> dMap=new TreeMap<String, String>();//用treemap实现自动排序,treemap默认是升序排列。
				int i=0;
				System.out.println(" 请输入"+n+"个要排序的数字：");
				while (i<n) {
					
					inputArray[i++]=scanner.nextInt();
				}
				scanner.close();
				//从数组第一项向后依次遍历，分别与自己之后的数字比较，重复将后者值为零。
				for (int j = 0; j < inputArray.length-1; j++) {
					for (int j2 = j+1; j2 < inputArray.length; j2++) {
						if (inputArray[j]==inputArray[j2]) {
							inputArray[j2]=0;
						}
					}
				}
				//从头开始遍历，分别查找在自己之后的最小数与自己对调，直至遍历到最后一个数。
				for (int j = 0; j < inputArray.length-1; j++) {
					int min =j;
					for (int j2 = j+1; j2 < inputArray.length; j2++) {
						if (inputArray[min]>inputArray[j2]) {
							min=j2;
						}
					}
					int temp=inputArray[min];
					inputArray[min]=inputArray[j];
					inputArray[j]=temp;
				}
				System.out.println("排序结果为：");
				for (int j = 0; j < inputArray.length; j++) {
					if (inputArray[j]!=0) {
						System.out.print(inputArray[j]+" | ");
					}
					if (j==inputArray.length-1) {
						System.out.println();
					}
				}
				//输出排序后的数组
//				System.out.println(Arrays.toString(inputArray));
		
				// 给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。
				Scanner sc = new Scanner(System.in);
				while (sc.hasNextInt()) {
					int n1=0;
					int m=0;
					int oddsum=0;
					int evensum=0;
					n1 = sc.nextInt();
					m=sc.nextInt();
					if (n1<=m) {
						for (int i1 = n1; i1 <=m; i1++) {
							if (i1%2!=0) {
								oddsum = Oddcube(oddsum,i1);
							}else {
								evensum=Evensquare(evensum,i1);
							}
						}
						System.out.println(evensum+" "+oddsum);
						
					}
				}
				sc.close();
				
				//创建文件夹及文件
				File path = new File("word");
				File pa = new File(path,"a.txt");
				if (!path.exists()) {
					path.mkdir();
					boolean a = pa.createNewFile();
					System.out.println("文件是否创建？-----"+a);
				}
				System.out.println("文件据对路径为："+pa.getAbsolutePath());
				
	}
}
