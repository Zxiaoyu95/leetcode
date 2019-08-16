package Test;
//快速排序也利用了分治的思想，但是与归并排序不同，具体来说是相反的，它首先先合并构成了一个以piovt（一般取最后一个数）为左右
//分界的局部有序数列，左边为小于piovt的数，右边则大于，然后进行分解为子处理段。但是它是原地排序，但不是稳定排序，它的时间复杂
// 度最好为o（nlogn）,但是在最坏的情况下（原数列有序）时则会变为o(n^2),但是这种情况很少见！
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
                i++;//注意在最后一步pivot放到正确位置时，还进行了一步i++，所以最后返回的正确下标是i-1
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
