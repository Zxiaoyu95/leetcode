package JiKeTest;
//�鲢�������������˷��ε�˼�룬�Ƚ�����ƽ��Ϊ�����Ӵ������жΣ�Ȼ������һ����������˳��ϲ���������Σ���������
// ʱ�临�Ӷȶ�Ϊo(nlogn)��������ԭ�����򣨿ռ临�Ӷ�Ϊo(n)����������ȱ�㣡�������ȶ�����
public class MergeSort {
    //������������Լ������С
    public static  void mergeSort(int[] a,int n){
        mergeSortRecursion(a,0,n-1);
    }
    private static void mergeSortRecursion(int[] a,int p,int r){
        if(p >= r)return;
        //int q =(p+r)/2;  //Ϊ�˷�ֹp��r�ĺͳ���int�ķ�Χ���˵�ʽ��Ҫ��д��
        int q = p + (r-p)/2;
        //�ݹ鲻��Ҫ�Ƶ���ϸ��ÿ�����裬����ֻ���������һ��
        mergeSortRecursion(a,p,q);
        mergeSortRecursion(a,q+1,r);
        mergeArray(a,p,q,r);
    }
    private static  void mergeArray(int[] a,int p,int q,int r){
        int i=p;
        int j=q+1;
        int k=0;//�µ��������
        int[] tmp=new int[r-p+1];
        while(i <= q&&j <= r){
            if(a[i] <= a[j]){//�ӵȺſ��Ա�֤������ȶ���
                tmp[k++]=a[i++];
            }
            else {
                tmp[k++]=a[j++];
            }
        }
        //���ж���һ����������ʣ������
        int start=i;
        int end=q;
        if(j <= r){
            start=j;
            end=r;
        }
        //��ʣ������д��tmp����
        while(start <= end){
            tmp[k++]=a[start++];
        }
        //����tmp���������a
        for(int m=0;m < (r-p+1);m++){
        a[p+m]=tmp[m];//ע��a�������ʼλ��Ϊ��ǰp��λ��
    }
}
    public static void main(String[] args){
        int[] a={2,3,23,1,22,56,32};
        new MergeSort().mergeSort(a,7);
        for(int value:a){
            System.out.println(value+" ");
        }
    }
}
