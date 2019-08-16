package LeetCode;

public class LongestHuiWen {
    public String MindSearch(String s,int mind){
        int len = s.length();
        int left = mind - 1;
        int right = mind + 1;
        char []ss=s.toCharArray();
        String result = "";
        boolean flag = false;
        int num = 0;
        //如果有重复的  右边可以后退
        while(right < len && ss [mind]== ss[right]){
            num++;
            right++;
            flag = true;
        }

        while(left >= 0 && right < len && ss[left] == ss[right]){
            --left;
            ++right;
        }
        left++;right--;
        if(left >= 0 && right < len && ss[left] == ss[right]){
            flag = false;
            for(int i = left;i <= right;i++){
                result = result + ss[i];
            }
        }
        if(flag == true){//如果有重复
            for(int i =0;i <= num;i++){
                result = result + ss[mind];
            }
        }
        return result;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1)return s;
        String longestStr = "";
        longestStr = ""+s.toCharArray()[s.length()-1];
        for(int i=0;i<len;i++){
            String rel = MindSearch(s,i);
            if( rel.length() > longestStr.length()){
                longestStr=rel;
            }
        }
        //if(longestStr == null)return ""+s.toCharArray()[s.length()-1];
        return longestStr;
    }
    public static void main(String[] args){
        LongestHuiWen lhw = new LongestHuiWen();
        System.out.println(lhw.longestPalindrome("sdfffghjjhghgg"));
    }
}
