package algorithm.person;

import java.util.Arrays;

public class HeapSort {

	private int leftChild(int i) {
		return 2 * i + 1;
	}

//按照最大堆排序
	public void percDown(int[] arr, int i, int N) {
		int tmp, child;
		for (tmp = arr[i]; leftChild(i) < N; i = child) {
			child = leftChild(i);
			if (child+1 < N  && arr[child + 1] > arr[child])
				child++;
			if (arr[child] > tmp)
				arr[i] = arr[child];
			else
				break;
		}
		arr[i] = tmp;
	}

	public void toHeapSort(int[] arr) {
		int i;
		int N = arr.length;
		for (i = N/2-1; i >= 0; i--)
			percDown(arr, i, N);
		for (i = N - 1; i > 0; i--) {
			int te = arr[0];
			arr[0] = arr[i];
			arr[i] = te;
			percDown(arr, 0, i);
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
