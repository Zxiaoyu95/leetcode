package JiKeTest;
//时间复杂度是logn，效率是十分快的，
//但是依赖的结构只能是顺序结构，也就是数组，其次要求原始的数据排序是有序的，一次排序多次查找的情形下，避免多次插入删除
//针对动态的数据集合，二分查找就不适用了，（二叉树适用），同时数据量太少也不适用，顺序查找即可，数据量太大也不适用，因为要
//开辟一个很大的连续内存空间（数组），比较吃力！
public class BinSearch {
    //非递归实现二分查找
    public int bsearch(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low <= high){//注意循环退出条件
            //int mind = (low+high)/2;
            //避免内存溢出
            int mind = low + (high-low)/2;
            if(a[mind]==value){
                return mind;
            }
            else if(a[mind] < value){
                low = mind+1;//注意更新是要加一，否则会陷入死循环
            }
                else{
                    high = mind-1;
            }
        }
        return -1;
    }
    //递归实现二分查找
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
       System.out.println("非递归---"+result1+"\n"+"递归---"+result2);
    }
}
