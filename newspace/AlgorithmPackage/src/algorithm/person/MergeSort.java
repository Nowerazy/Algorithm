package algorithm.person;

import java.util.Arrays;

public class MergeSort {
	// 归并排序
	// 将有序数组a[]和b[]合并到c[]中
	public void MemeryArray(int a[], int alen, int b[], int blen, int c[]) {
		int i, j, k;
		i = j = k = 0;
		while (i < alen && j < blen) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while (i < alen)
			c[k++] = a[i++];
		while (j < blen)
			c[k++] = b[j++];
	}

	// 将有二个有序数列a[first...mid]和a[mid...last]合并。
	public void mergearray(int a[], int first, int mid, int last, int temp[]) {
		int i = first, j = mid + 1;
		int k = 0;
		while (i <= mid && j <= last) {
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		while (i <= mid)
			temp[k++] = a[i++];
		while (j <= last)
			temp[k++] = a[j++];
		for (i = 0; i < k; i++)
			a[first + i] = temp[i];
	}
	public void mergesort(int a[], int first, int last, int temp[]) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergesort(a, first, mid, temp); // 左边有序
			mergesort(a, mid + 1, last, temp); // 右边有序
			mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
		}
	}

	public void toMergesort(int a[]) {
		int n=a.length;
		int[] p = new int[n];
		mergesort(a, 0, n - 1, p);
		System.out.println(Arrays.toString(p));
	}
}
