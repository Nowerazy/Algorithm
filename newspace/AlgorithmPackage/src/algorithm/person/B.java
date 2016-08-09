package algorithm.person;

public class B {
	public int[] mergeSort(int[] A, int n) {
        // write code here
        int[] temp=new int[n];
        return mergeArray(A,0,n-1,temp);
    }
   public int[] mergeArray(int[] a,int left,int right,int[]temp){
       if(left<right){
        int mid =(left+right)/2;
        mergeArray(a,left,mid,temp);
        mergeArray(a,mid+1,right,temp);
       return mergesort(a,left,mid,right,temp);
       }
        return new int[0];
   }
    public int[] mergesort(int[] a,int left,int mid,int right,int[]temp){
        int idx=0;
        int i=left,j=mid+1;
        
        while(i<=mid&&j<=right){
            if(a[i]<a[j])
                temp[idx++]=a[i++];
            else
                temp[idx++]=a[j++];
        }
        if(i>mid)
            while(j<=right){
             temp[idx++]=a[j++];
        }
        else
            while(i<=mid){
            temp[idx++]=a[i++];
        }
        for (int j2 = 0; j2 < idx; j2++) {
			a[left+j2]=temp[j2];
		}
        return a;
    }
}
