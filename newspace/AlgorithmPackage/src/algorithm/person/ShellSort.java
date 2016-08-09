package algorithm.person;

import java.util.Arrays;

public class ShellSort {
//希尔排序
	static int actNumber=0;
	public  void StartToSort(int[] a) {
		System.out.println("排序之前：");
		System.out.println(Arrays.toString(a));
		// 希尔排序
		int d = a.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					//以i为首步长为d的向前插入排序
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						actNumber++;
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
		System.out.println("希尔排序之后：");
		System.out.println(Arrays.toString(a)+"总计算次数："+actNumber);

	}
}
