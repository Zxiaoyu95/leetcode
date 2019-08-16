package LeetCode;

import java.util.ArrayList;

public class Zturn {
    public String convert(String s, int numRows) {
        if(numRows == 1)return s;
        String result="";
        int index = 0;
        int mindstep;
        int n = s.length();
        int step = 2*numRows-2;//第0行和n-1行的固定字符串间距 中间行间距根据step-2*行数，2*行数进行交替跳转
      for(int i=0;i<numRows;i++){
          boolean flag =false;
          index = i;
          mindstep=2*i;
          while(index < n){
              result += Character.toString(s.charAt(index));
              if(i == 0 || i == numRows-1){
                  index += step;
              }
              else{
                  if(flag == false)
                  {
                      index += step-mindstep;
                      flag = true;
                  }
                  else if(flag == true){
                      index += mindstep;
                      flag = false;
                  }
              }
          }
      }
      return result;
    }
    public static void main(String[] args){
        Zturn zn = new Zturn();
        System.out.println(zn.convert("LEETCODEISHIRING",4));
    }
}
