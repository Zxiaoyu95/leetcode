package JiKeTest;
//ʱ�临�Ӷ���logn��Ч����ʮ�ֿ�ģ�
//���������Ľṹֻ����˳��ṹ��Ҳ�������飬���Ҫ��ԭʼ����������������ģ�һ�������β��ҵ������£������β���ɾ��
//��Զ�̬�����ݼ��ϣ����ֲ��ҾͲ������ˣ������������ã���ͬʱ������̫��Ҳ�����ã�˳����Ҽ��ɣ�������̫��Ҳ�����ã���ΪҪ
//����һ���ܴ�������ڴ�ռ䣨���飩���Ƚϳ�����
public class BinSearch {
    //�ǵݹ�ʵ�ֶ��ֲ���
    public int bsearch(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low <= high){//ע��ѭ���˳�����
            //int mind = (low+high)/2;
            //�����ڴ����
            int mind = low + (high-low)/2;
            if(a[mind]==value){
                return mind;
            }
            else if(a[mind] < value){
                low = mind+1;//ע�������Ҫ��һ�������������ѭ��
            }
                else{
                    high = mind-1;
            }
        }
        return -1;
    }
    //�ݹ�ʵ�ֶ��ֲ���
    public int DGbinsearch(int[] a,int n,int val){
        return DGrun(a,0,n-1,val);
    }
    public int DGrun(int[] a,int low,int high,int val){
        if(low > high)return -1;
        int mind = low + (high - low)/2;
        if(a[mind] == val){
            return mind;
        }

        else if(a[mind] < val){
            low = mind + 1;
            return DGrun(a,low,high,val);
        }
        else{
            high = mind - 1;
            return DGrun(a,low,high,val);
        }
    }
    public static void main(String[] args){
       BinSearch bs = new BinSearch();
       int[] a ={2,4,6,7,12,23,45,66,77,88};
       int result1 = bs.bsearch(a,a.length,4);
       int result2 = bs.DGbinsearch(a,a.length,4);
       System.out.println("�ǵݹ�---"+result1+"\n"+"�ݹ�---"+result2);
    }
}
