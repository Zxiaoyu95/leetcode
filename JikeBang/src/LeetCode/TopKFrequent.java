package LeetCode;
import java.util.*;
class A{
    int key,value;
}
public class TopKFrequent {//小顶堆
    int count = 0;
    public void insertHeapify(A[] heap,int key,int value){
        int len = heap.length;
        count++;
        if(count < len){//构造大小为K的小顶堆
            heap[count] = new A();
            heap[count].key = key;
            heap[count].value = value;
            int i = count;
            while(i/2 >0 && heap[i/2].value > heap[i].value){
                int tmpkey = heap[i].key;
                heap[i].key = heap[i/2].key;
                heap[i/2].key = tmpkey;
                int tmpvalue = heap[i].value;
                heap[i].value = heap[i/2].value;
                heap[i/2].value = tmpvalue;
                i=i/2;
            }
        }
        else if(count >= len && heap[1].value < value){//如果新插入的数据比堆顶元素小，则不考虑，否则替换堆顶元素，进行堆化
            heap[1].key = key;
            heap[1].value = value;
            heapify(heap,1);//堆化
        }
    }
    public void heapify(A[] heap,int i){//固定大小为K的小顶堆堆化
        int len = heap.length;
        while(true){
            int maxpoit = i;
            if(2*i < len && heap[2*i].value < heap[maxpoit].value)maxpoit=2*i;
            if(2*i+1 < len && heap[2*i+1].value < heap[maxpoit].value)maxpoit=2*i+1;
            if(maxpoit == i)break;
            int tmpkey = heap[i].key;
            heap[i].key = heap[maxpoit].key;
            heap[maxpoit].key = tmpkey;
            int tmpvalue = heap[i].value;
            heap[i].value = heap[maxpoit].value;
            heap[maxpoit].value = tmpvalue;
            i = maxpoit;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        A[] heap = new A[k+1];
        HashMap<Integer,Integer> Frequent = new HashMap<>();
        Frequent.put(nums[0],1);
        for(int i =1; i< len; i++){
            if(Frequent.containsKey(nums[i])){
                int value = Frequent.get(nums[i])+1;
                Frequent.put(nums[i],value);
            }
            else{
                Frequent.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : Frequent.entrySet()){
            insertHeapify(heap,entry.getKey(),entry.getValue());
        }
        for(int i=1; i<heap.length; i++){
            list.add(heap[i].key);
        }
        return list;
    }
    public static void main(String[] args){
        TopKFrequent tkf = new TopKFrequent();
        int[] nums ={1,1,1,2,2,3,2,3,4,66,1,9,45,99};
        System.out.println(tkf.topKFrequent(nums,4));
    }
}
