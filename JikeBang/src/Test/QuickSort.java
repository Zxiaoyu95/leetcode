package Test;
//��������Ҳ�����˷��ε�˼�룬������鲢����ͬ��������˵���෴�ģ��������Ⱥϲ�������һ����piovt��һ��ȡ���һ������Ϊ����
//�ֽ�ľֲ��������У����ΪС��piovt�������ұ�����ڣ�Ȼ����зֽ�Ϊ�Ӵ���Ρ���������ԭ�����򣬵������ȶ���������ʱ�临��
// �����Ϊo��nlogn��,�������������£�ԭ��������ʱ����Ϊo(n^2),��������������ټ���
public class QuickSort {
    public void quickSort(int[] a,int n){
        quickSortRecursion(a,0,n-1);
    }
    private void quickSortRecursion(int[] a,int p,int r){
        if(p >= r)return;
        int q = quickSortPartition(a,p,r);
        quickSortRecursion(a,p,q-1);
        quickSortRecursion(a,q+1,r);
    }
    private int quickSortPartition(int[] a,int p,int r){
        int pivot = a[r];
        int i=p;
        int j=p;
        while(j <= r){
            if(a[j] <= pivot){
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                j++;
                i++;//ע�������һ��pivot�ŵ���ȷλ��ʱ����������һ��i++��������󷵻ص���ȷ�±���i-1
            }
            else{
                j++;
            }
        }
        return i-1;
    }
    public static void main(String[] args){
        int[] a={2,3,23,1,22,56,5};
        new QuickSort().quickSort(a,7);
        for(int value:a){
            System.out.println(value+" ");
        }
    }
}
