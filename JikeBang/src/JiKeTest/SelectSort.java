package JiKeTest;
//选择排序最好最坏的情况时间复杂度都为o(n^2)，它是原地排序，但是它是不稳定的
public class SelectSort {
	public void select(int[] a,int n){
		if(n<=1)return;
		for(int i=0;i<n;i++){
			//int min=a[i];
			int min =i;//注意细节 如果这里将min赋值为a[i],那么在进行交换时，交换前最小值的索引将丢失！！！！！！
			for(int j=i;j<n;j++){
				if(a[j]<a[min]){
					min=j;
				}
			}
			if(i != min){
				int tmp;
				tmp=a[i];
				a[i]=a[min];
				a[min]=tmp;
			}
		}
	}
	public static void main(String[] args) {
	int[] a={1,3,4,5,33,2,44};
	SelectSort ss=new SelectSort();
	ss.select(a, 7);
	for(int i:a){
		System.out.println(i+" ");
	}
	
	}
}
