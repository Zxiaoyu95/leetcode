package JiKeTest;

import LeetCode.ThreeSum;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int result=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<len-2; i++){
                int low = i+1; int high = len-1;
                while(low < high){
                    int sum = nums[i]+nums[low]+nums[high];
                    int compare = Math.abs(target-sum);
                    if(len == 3){
                        return sum;
                    }
                    if(compare < min){
                        min=compare;
                        result=sum;
                    }
                    if(sum > target){//ÓÀÔ¶Ïòtarget¿¿½ü
                        high--;
                    }
                    else if(sum < target){
                        low++;
                    }
                }
            }
        return result;
    }
    public static void main(String[] args){
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums ={-1,2,1,-4};
        System.out.println(tsc.threeSumClosest(nums,1));
    }
}
