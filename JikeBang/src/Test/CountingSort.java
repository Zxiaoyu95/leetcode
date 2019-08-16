package Test;

public class CountingSort {
    public void countSort(int[] a,int n){
        if(n<=1)return;
        int max=a[0];
        //求出数组中值的范围
        for(int i=1;i<n;i++){
            if(max < a[i]){
                max=a[i];
            }
        }
        int[] C =new int[max+1];//开辟新数组进行计数
        for(int i=0; i<= max;i++){
            C[i]=0;
        }
        //遍历数组a  进行计数计入C数组中
        for(int i=0;i<n;i++){
            C[a[i]]++;
        }
        //将计数数组进行顺序求和
        for(int i=1;i <= max;i++){
            C[i]=C[i-1]+C[i];
        }
        //分配一输出数组
        int[] R=new int[n];
        for(int i=0;i<n;++i){//疑问 为什么要从后往前遍历？？？？？(正反序结果都一样)
            int index=C[a[i]]-1;//获取对应数值的下标
            R[index]=a[i];
            C[a[i]]--;
        }
        //复制R数组到a数组
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
