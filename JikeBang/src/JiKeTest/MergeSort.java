package JiKeTest;
//归并排序首先利用了分治的思想，先将数列平分为两个子处理数列段，然后利用一个数组来按顺序合并两个处理段，最好与最坏的
// 时间复杂度都为o(nlogn)，但不是原地排序（空间复杂度为o(n)，这是致命缺点！），是稳定排序
public class MergeSort {
    //定义数组参数以及数组大小
    public static  void mergeSort(int[] a,int n){
        mergeSortRecursion(a,0,n-1);
    }
    private static void mergeSortRecursion(int[] a,int p,int r){
        if(p >= r)return;
        //int q =(p+r)/2;  //为了防止p与r的和超过int的范围，此等式需要换写法
        int q = p + (r-p)/2;
        //递归不需要绕到详细的每个步骤，可以只想最外面的一层
        mergeSortRecursion(a,p,q);
        mergeSortRecursion(a,q+1,r);
        mergeArray(a,p,q,r);
    }
    private static  void mergeArray(int[] a,int p,int q,int r){
        int i=p;
        int j=q+1;
        int k=0;//新的数组计数
        int[] tmp=new int[r-p+1];
        while(i <= q&&j <= r){
            if(a[i] <= a[j]){//加等号可以保证排序的稳定性
                tmp[k++]=a[i++];
            }
            else {
                tmp[k++]=a[j++];
            }
        }
        //先判断哪一个子数组有剩余数据
        int start=i;
        int end=q;
        if(j <= r){
            start=j;
            end=r;
        }
        //将剩余数据写入tmp数组
        while(start <= end){
            tmp[k++]=a[start++];
        }
        //拷贝tmp数组给数组a
        for(int m=0;m < (r-p+1);m++){
        a[p+m]=tmp[m];//注意a数组的起始位置为当前p的位置
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
