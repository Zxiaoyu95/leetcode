package Test;
//常见的4种二分查找变形问题（以前都是简单的无重复元素查找问题）
//1 查找第一个值等于给定值的元素
//2 查找最后一个元素等于给定值得的元素
//3 查找第一大于等于给定值得元素
//4 查找最后一个小于等于给定值得元素
public class TurnBinSearch {
    //1 查找第一个值等于给定值的元素
    public int findFirstEqual(int[] a,int n,int val){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mind = low + (high-low)/2;
            if(a[mind] < val){
                low = mind + 1;
            }
            else if(a[mind] > val){
                high = mind - 1;
            }
                else{
                    if(mind == 0 || a[mind-1] != val){return mind;}//如果a[mind]=val，而且mind指向第一个元素或者mind前面的一个元素值不等于val
                        else{high = mind - 1;}
            }
        }
        return -1;
    }
    //2 查找最后一个元素等于给定值得的元素
    public int findLastEqual(int[] a,int n,int val){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mind = low + (high-low)/2;
            if(a[mind] < val){
                low = mind + 1;
            }
            else if(a[mind] > val){
                high = mind - 1;
            }
            else{
                if(mind == n-1 || a[mind+1] != val){
                    return mind;
                }
                else{low = mind + 1;}
            }
        }
        return -1;
    }
    //3 查找第一大于等于给定值得元素
    public int findFistlargeEqual(int[] a,int n,int val){
        int slow = 0;
        int high = n-1;
        while(slow <= high){
            int mind = slow + (high - slow)/2;
            if(a[mind] >= val){
                if(mind == 0 || a[mind-1] < val){
                    return mind;
                }
                else{high = mind - 1;}
            }
            else{slow = mind + 1;}
        }
        return -1;
    }
    //4 查找最后一个小于等于给定值得元素
    public int findLastLessEqual(int[] a,int n,int val){
        int slow = 0;
        int high = n-1;
        while(slow <= high){
            int mind = slow + (high-slow)/2;
            if(a[mind] <= val){
                if(mind == n-1 || a[mind+1] > val){
                    return mind;
                }
                else{slow = mind +1;}
            }
            else{high = mind -1;}
        }
        return -1;
    }
    public static void main(String[] args){
        int[] a = {1,3,3,3,4,4,6,6,7,9,12,19};
        TurnBinSearch tbs = new TurnBinSearch();
        int result1 = tbs.findFirstEqual(a,a.length,3);
        int result2 = tbs.findLastEqual(a,a.length,6);
        int result3 = tbs.findFistlargeEqual(a,a.length,5);
        int result4 = tbs.findLastLessEqual(a,a.length,5);
        System.out.println("第一个等于3的下标--"+result1+"\n"+
                            "最后一个等于6的下标--"+result2+"\n"+
                            "第一个大于等于5的下标--"+result3+"\n"+
                            "最后一个小于等于5的下标--"+result4);
    }
}
