package Test;

public class AllSortPrint {
    public void printPermutations(int[] data,int n,int k){
        //k表示有几个子组
        if(k == 1){
            for(int i=0;i < n; i++){
                System.out.println(data[i]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<k;++i){
            int tmp =data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

        printPermutations(data,n,k-1);
        tmp = data[i];
        data[i] = data[k-1];
        data[k-1] = tmp;
        }
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4};
        AllSortPrint asp = new AllSortPrint();
        asp.printPermutations(a,4,4);
    }
}
