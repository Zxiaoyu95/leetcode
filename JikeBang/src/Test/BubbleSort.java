package Test;
//ð�������ʱ�临�Ӷ���o(n^2)����ԭ��������ʱ���Խ���o(n)��ͬʱ�������ȶ��ģ���ԭ���������н����Ĵ������������
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
