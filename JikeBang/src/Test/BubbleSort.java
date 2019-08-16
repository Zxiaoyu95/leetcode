package Test;
//冒泡排序的时间复杂度是o(n^2)，在原排列有序时可以降到o(n)，同时排序是稳定的，是原地排序，其中交换的次数等于逆序度
public class BubbleSort {
	public void bubblesort(int[] a,int n){
		if(n<=1)return;
		for(int i=0;i<n;i++){
			boolean flag=false;
			for(int j=0;j<n-i-1;j++){
				if(a[j]>a[j+1]){
					int tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
					flag=true;
				}
			}
		if(!flag){break;}
			}
		
	}
	public static void main(String[] args) {
		int[]a={2,45,6,4,32,54,66};
		BubbleSort bs =new BubbleSort();
		bs.bubblesort(a,7);
		for(int i:a){
			System.out.println(i+" ");
		}
	}
}
