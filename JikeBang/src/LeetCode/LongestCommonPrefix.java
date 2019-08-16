package LeetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==1)return strs[0];
        String pre ="";
        for(int i = 0; i < n-1;i++){
            String result ="";
            int j=0;
            while(j < strs[i].length()  && j < strs[i+1].length() && strs[i].charAt(j)==strs[i+1].charAt(j)){
                    result += Character.toString(strs[i].charAt(j));
                    ++j;
                }
            if(j==0)return"";
            if(pre == "")pre=result;
            if(result.length() < pre.length())pre=result;

        }
        return pre;
    }
    public static void main(String[] args){
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] input = {"flooa","flo","fl","fl4"};
        System.out.println(l.longestCommonPrefix(input));
    }
}
