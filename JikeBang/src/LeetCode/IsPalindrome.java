package LeetCode;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x == 0){return true;}//�����0 flase
        if(x < 0 || (x%10) == 0){return false;}
        int count = 0;
        while(count <= x){//�ж�֪���Ѿ������м�λ��
            count+= (x%10);//ÿ�ζ�ȡ���һλ���ۼ�
            if(count == x/10 || count == x){return true;}
            else{
                x = x/10;
                count = count*10;
            }
        }
        return false;
    }
    public static void main(String[] args){
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome(100000001));
    }
}
