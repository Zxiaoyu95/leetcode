package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
//»¬¶¯´°¿Ú
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if(s.equals(""))return 0;
        int Max = 0;
        int len = s.length();
        Set<Character> l = new HashSet<>();
        int start =0;
        int end =0;
        while(start < len && end < len){
            if(!l.contains(s.charAt(end))){
                l.add(s.charAt(end++));
                if((end -start) > Max){
                    Max = (end -start);
                }
            }
            else{
                l.remove(s.charAt(start++));
            }
        }

        return Max;
    }
    public static void main(String[] args){
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        System.out.println(lols.lengthOfLongestSubstring("addddddddbc"));
    }
}
