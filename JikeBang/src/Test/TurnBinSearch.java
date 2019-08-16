package Test;
//������4�ֶ��ֲ��ұ������⣨��ǰ���Ǽ򵥵����ظ�Ԫ�ز������⣩
//1 ���ҵ�һ��ֵ���ڸ���ֵ��Ԫ��
//2 �������һ��Ԫ�ص��ڸ���ֵ�õ�Ԫ��
//3 ���ҵ�һ���ڵ��ڸ���ֵ��Ԫ��
//4 �������һ��С�ڵ��ڸ���ֵ��Ԫ��
public class TurnBinSearch {
    //1 ���ҵ�һ��ֵ���ڸ���ֵ��Ԫ��
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
                    if(mind == 0 || a[mind-1] != val){return mind;}//���a[mind]=val������mindָ���һ��Ԫ�ػ���mindǰ���һ��Ԫ��ֵ������val
                        else{high = mind - 1;}
            }
        }
        return -1;
    }
    //2 �������һ��Ԫ�ص��ڸ���ֵ�õ�Ԫ��
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
    //3 ���ҵ�һ���ڵ��ڸ���ֵ��Ԫ��
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
    //4 �������һ��С�ڵ��ڸ���ֵ��Ԫ��
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
        System.out.println("��һ������3���±�--"+result1+"\n"+
                            "���һ������6���±�--"+result2+"\n"+
                            "��һ�����ڵ���5���±�--"+result3+"\n"+
                            "���һ��С�ڵ���5���±�--"+result4);
    }
}
