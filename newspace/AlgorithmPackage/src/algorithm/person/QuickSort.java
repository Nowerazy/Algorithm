package algorithm.person;

public class QuickSort {

	//快速排序
	static void quick_sort(int s[], int l, int r)
	{
	    if (l < r)
	    {
			//Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
	        int i = l, j = r, x = s[l];
	        while (i < j)
	        {
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
					j--;
	            if(i < j) 
					s[i++] = s[j];
				
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
					i++;
	            if(i < j)
					s[j--] = s[i];
	        }
	        System.out.println("此时i="+i+",j="+j+".");
	        s[i] = x;
	        quick_sort(s, l, i - 1); // 递归调用 
	        quick_sort(s, i + 1, r);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a={40,98,7,6,78,8,4,3,36,26,25,16,15,17,12,11,46,27,45,66,77,88,99,24,21,14,56,63,43};
		quick_sort(a, 0, a.length-1);
		for (int i : a) {
			System.out.print(i+",");
		}
	}

}
