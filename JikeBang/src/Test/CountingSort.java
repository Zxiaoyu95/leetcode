package Test;

public class CountingSort {
    public void countSort(int[] a,int n){
        if(n<=1)return;
        int max=a[0];
        //���������ֵ�ķ�Χ
        for(int i=1;i<n;i++){
            if(max < a[i]){
                max=a[i];
            }
        }
        int[] C =new int[max+1];//������������м���
        for(int i=0; i<= max;i++){
            C[i]=0;
        }
        //��������a  ���м�������C������
        for(int i=0;i<n;i++){
            C[a[i]]++;
        }
        //�������������˳�����
        for(int i=1;i <= max;i++){
            C[i]=C[i-1]+C[i];
        }
        //����һ�������
        int[] R=new int[n];
        for(int i=0;i<n;++i){//���� ΪʲôҪ�Ӻ���ǰ��������������(����������һ��)
            int index=C[a[i]]-1;//��ȡ��Ӧ��ֵ���±�
            R[index]=a[i];
            C[a[i]]--;
        }
        //����R���鵽a����
        for(int i=0;i<n;i++){
            a[i]=R[i];
        }
    }
    public static void main(String[] args){
        CountingSort cs =new CountingSort();
        int[] a={2,5,3,0,2,3,0,3};
        cs.countSort(a,8);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}
