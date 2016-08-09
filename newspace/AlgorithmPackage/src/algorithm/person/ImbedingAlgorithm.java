package algorithm.person;

import java.util.Arrays;

public class ImbedingAlgorithm {
	static int actNumber=0;
	public static void insert(int sourceNum,int objectNum,int[] array){
		//插入算法 
		
		if (sourceNum<objectNum) {
			//插入位置在后方
			int num = array[sourceNum];
			for (int i = sourceNum; i < objectNum; i++) {
				actNumber++;
				array[i]=array[i+1];
			}
			array[objectNum]=num;
		}else {
			//插入位置在前方
			if (sourceNum==objectNum) {
				return;
			
			}
			int num2 = array[sourceNum];
			for (int i = sourceNum; i > objectNum; i--) {
				array[i]=array[i-1];
			}
			array[objectNum]=num2;
			}
	}
	public static int compareToArray(int k,int[] array) {
		//将新数放入前数列中比较，返回要插入的位置
		for (int i = k-1; i >= 0; i--) {
			actNumber++;
			if(array[k]>array[i]){
				return i+1;
			}
		}
		return 0;
	}
	public static void trim(int i,int j,int[]array) {
		//对第i位和j位的数整理排序
		if (i>j) {
			if (array[i]<array[j]) {
				change(i, j, array);
			} 
		}else {
			if (array[i]>array[j]) {
				change(i, j, array);
			} 
		}
		
	}
	public static void change(int i,int j,int[]array) {
		//互换位置
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public  void StartToSort(int[] array){
//		int[] original= {12,6,2,3,5,7,8,9,4,7,5,10,11,5,7,1};
		int[] original = array;
		
//		Scanner in = new Scanner(System.in);
//		System.out.print("请分别输入20个数字：(用回车键结束)\n");
//		boolean flag = true;
//		
//		//捕捉输入异常
//		while (flag) {
//			try {
//				for (int i = 0; i < original.length; i++) {
//					System.out.println("请输入第"+(i+1)+"个数：");
//					original[i] = in.nextInt();
//				}
//				System.out.println("输入数组排序后结果：");
//				in.close();
//				flag = false;
//				
//			} catch (Exception e) {
//				System.out.println("** 格式错误！请输入数字 **");
//				in.next();
//			}
//		}
//		
		//输入结束，排序开始
		trim(0,1,original);
		for (int j = 2; j < original.length; j++) {
			int sataionNum = compareToArray(j, original);
			insert(j, sataionNum, original);
			}
		System.out.println("直接插入排序之后：");
		System.out.println(Arrays.toString(original)+"总计算次数："+actNumber);
	}
	
}
