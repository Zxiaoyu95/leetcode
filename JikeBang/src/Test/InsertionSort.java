package Test;
//���������ʱ�临�Ӷ�Ϊo(n^2),��ԭ��������ʱ���Խ�Ϊo(n),���ȶ�����ͬʱҲ��ԭ������
//��������  ��β����ǰ���б���
public class InsertionSort {
	public void insertionsort(int[] a,int n){
		if(n<=1){return; }
		for(int i=1;i<n;i++){
			int tmp=a[i];
			int j=i-1;//Сϸ��ע�⣬д�ڶ���ѭ�������棬�������ͷ�
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
