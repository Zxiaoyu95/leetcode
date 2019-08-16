package Test;
//插入排序的时间复杂度为o(n^2),在原排列有序时可以降为o(n),是稳定排序，同时也是原地排序
//插入排序  从尾部向前进行遍历
public class InsertionSort {
	public void insertionsort(int[] a,int n){
		if(n<=1){return; }
		for(int i=1;i<n;i++){
			int tmp=a[i];
			int j=i-1;//小细节注意，写在二层循环体外面，变量不释放
			for(;j>=0;j--){
				if(tmp<a[j]){
					a[j+1]=a[j];
			//		a[j]=tmp;
				}
				else{break;}
			}
			a[j+1]=tmp;
		}
	}
	public static void main(String[] args){
		int[]a={2,45,6,4,32,54,66};
		InsertionSort is =new InsertionSort();
		is.insertionsort(a,7);
		for(int i:a){
			System.out.println(i+" ");
		}

	}

}
