package JiKeTest;
//ѡ���������������ʱ�临�Ӷȶ�Ϊo(n^2)������ԭ�����򣬵������ǲ��ȶ���
public class SelectSort {
	public void select(int[] a,int n){
		if(n<=1)return;
		for(int i=0;i<n;i++){
			//int min=a[i];
			int min =i;//ע��ϸ�� ������ｫmin��ֵΪa[i],��ô�ڽ��н���ʱ������ǰ��Сֵ����������ʧ������������
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
