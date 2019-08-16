package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IntToLuoma {
    public String intToRoman(int num){
        String result = "";
        Map<String,Integer> RomanMap = new HashMap<String,Integer>();
        RomanMap.put("I",1);RomanMap.put("V",5);RomanMap.put("X",10);RomanMap.put("L",50);
        RomanMap.put("C",100);RomanMap.put("D",500);RomanMap.put("M",1000);
        RomanMap.put("IV",4);RomanMap.put("IX",9);RomanMap.put("XL",40);RomanMap.put("XC",90);
        RomanMap.put("CD",400);RomanMap.put("CM",900);
        int min = 3000;
        String key = "";
        while(num !=0){
            for(Map.Entry<String,Integer> entry : RomanMap.entrySet()){
                if(num >= entry.getValue() && (num-entry.getValue())<min){
                    min = num-entry.getValue();
                    key = entry.getKey();
                }
            }
            result=result+key;
            num = min;
        }
        return result;
    }
        public int romanToInt(String s) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int ans = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                //从后开始遍历，如果前一个小于后一个 则是特殊情况 需要减去小的值
                if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) ans -= map.get(s.charAt(i));//判断特殊情况
                else ans += map.get(s.charAt(i));
            }
            return ans;
        }
    public static void main(String[] args){
        IntToLuoma itl = new IntToLuoma();
        System.out.println(itl.intToRoman(2894));
        System.out.println(itl.romanToInt("MMDCCCXCIV"));
    }
}
