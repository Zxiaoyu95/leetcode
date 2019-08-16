package LeetCode;
import java.util.*;

public class NewThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i<nums.length-2; i++){
            if(i==0 || (i > 0 && nums[i] != nums[i-1])){//如果后面与前面有相同元素，直接向后跳
                int low = i+1; int high = nums.length-1;
                int count = -nums[i];
                while(low < high){
                    int sum = nums[low] + nums[high];
                    if(sum == count){
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low < high && nums[low]==nums[low+1])low++;//跳过相同元素
                        while(low < high && nums[high]==nums[high-1])high--;//跳过相同元素
                        //两边指针同时向中间移动
                        low++;
                        high--;
                    }
                    if(sum < count)low++;
                    else if(sum > count)high--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        NewThreeSum nts = new NewThreeSum();
        int[] nums ={-1,0,1,2,-1,-4};
        System.out.println(nts.threeSum(nums));
    }
}
