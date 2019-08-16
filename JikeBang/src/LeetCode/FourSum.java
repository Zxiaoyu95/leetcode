package LeetCode;
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int len = nums.length;
        for(int i=0; i<len-3; i++){
            if(i == 0 ||(i>0 && nums[i] != nums[i-1])){
                for(int j=i+1; j<len-2; j++){
                    if(j==i+1 || (j !=i+1 && nums[j] != nums[j-1])){//如果i与j相邻时无需考虑重复
                        int low = j+1; int high = len-1; int sum= target - nums[i];
                        while(low < high){
                            int count = nums[j] + nums[low] + nums[high];
                            if(count == sum){
                                result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                                while(low<high && nums[low] == nums[low+1])low++;
                                while(low<high && nums[high] == nums[high-1])high--;
                                low++;high--;
                            }
                            if(count < sum)low++;
                            else if(count > sum)high--;
                        }
                    }

                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        FourSum fs = new FourSum();
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fs.fourSum(nums,0));
    }
}
