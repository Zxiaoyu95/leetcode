package JiKeTest;

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
        a[1]=a[count];
        count--;
        heapify(a,count,1);
    }
    private void heapify(int[] a,int n,int i){
        while(true){
            int maxpois = i;
            if(2*i <n && a[2*i] > a[maxpois])maxpois = 2*i;
            if(2*i+1 <n && a[maxpois] < a[2*i+1])maxpois = 2*i+1;
            if(maxpois == i)break;
            int tmp = a[i];
            a[i]=a[maxpois];
            a[maxpois]=tmp;
            i=maxpois;
        }
    }
}
