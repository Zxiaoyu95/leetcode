package LeetCode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ListResult = new ArrayList<List<Integer>>();
        List<Integer> more = new ArrayList<>();
        List<Integer> less = new ArrayList<>();
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(nums[i] >= 0)more.add(nums[i]);
            else{less.add(nums[i]);}
        }
        //两正一负
        for(int i=0; i<more.size();i++){
            for(int j=i+1; j< more.size();j++){
                int count = more.get(i) + more.get(j);
                if(less.contains(-count)){
                    List<Integer> List = new ArrayList<>();
                    List.add(more.get(i));List.add(more.get(j));List.add(-count);
                    ListResult.add(List);
                }
            }

        }
        //两负一正
        for(int i=0; i<less.size();i++) {
            for (int j = i + 1; j < less.size(); j++) {
                int count = less.get(i) + less.get(j);
                if (more.contains(-count)) {
                    List<Integer> List = new ArrayList<>();
                    List.add(less.get(i));List.add(less.get(j));List.add(-count);
                    ListResult.add(List);
                }
            }
        }
        //三个0
        int num=0;
        for(int i=0; i<more.size();i++){
            if(more.get(i)==0)num++;
        }
        if(num>=3){
            List<Integer> Listzero = new ArrayList<>();
            Listzero.add(0);Listzero.add(0);Listzero.add(0);
            ListResult.add(Listzero);
        }
        return ListResult;
    }
    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(ts.threeSum(nums));
    }
}
