package Test;
//建堆的时间复杂度时候n， 堆化的时间复杂度是logn，排序时间复杂度是nlogn， 堆排序是原地排序
public class Heap {
    int [] a;
    int n;
    int count;
    public Heap(int capacity){
        a = new int [capacity+1];
        n = capacity;
        count = 0;
    }
    public  void insert(int data){
        if(count >= n)return;
        count++;
        a[count]=data;
        int i = count;
        while(i/2 >0 && a[i] > a[i/2]){
            int tmp = a[i];
            a[i] = a[i/2];
            a[i/2] = tmp;
            i = i/2;
        }
    }
    public void removeMax(){
        if(count == 0)return ;
        a[1]=a[count];//最后一个元素填充第一个位置
        count--;
        heapify(a,count,1);
    }
    private void heapify(int[] a,int n,int i){
        while(true){
            int maxpois = i;
            if(2*i <n && a[2*i] > a[maxpois])maxpois = 2*i;
            if(2*i+1 <n && a[maxpois]  < a[2*i+1])maxpois = 2*i+1;
            if(maxpois == i)break;//如果父子节点比较没有改变，则不需要堆化下面排好的数据
            int tmp = a[i];
            a[i]=a[maxpois];
            a[maxpois]=tmp;
            i=maxpois;
        }
    }
    private void buildHeap(int[] a, int n){
        for (int i = n/2; i>=1 ; i--){//完全二叉树叶子结点下标从n/2+1开始，所以从下往上进行堆化
            heapify(a,n,i);
        }
    }
    public void sort(int [] a, int n){
        buildHeap(a,n);
        int k = n;
        while(k > 1){
            int tmp = a[k];
            a[k] = a[1];
            a[1] = tmp;
            k--;
            heapify(a, k,1);
        }

    }
    public static void main(String[] args){
        Heap h = new Heap(13);
        h.insert(33);h.insert(21);h.insert(16);h.insert(13);
        h.insert(1);h.insert(2);h.insert(6);h.insert(5);h.insert(17);
        h.insert(8);h.insert(7);h.insert(9);h.insert(15);
        int [] result = h.a;
        System.out.println("插入数据后：");
        for(int i=0; i < result.length; i++){
            System.out.println(result[i]);
        }
        h.removeMax();
        System.out.println("删除堆顶数据后：");
        for(int i=0; i < result.length; i++){
            System.out.println(result[i]);
        }
        h.sort(result,result.length-1);
        System.out.println("堆排序后：");
        for(int i=0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
