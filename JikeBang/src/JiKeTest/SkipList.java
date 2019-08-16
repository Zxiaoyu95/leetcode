package JiKeTest;

import java.util.Random;

//�����д洢�Ķ��ǲ��ظ���������
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Node head = new Node();
    private Random r = new Random();
    public Node find(int value){
        Node p = head;
        for(int i = levelCount-1;i >= 0;--i){//�������½��жԱȣ�����ԭ˳��������ģ����Խ���С�ڱȽ�
            while(p.forward[i] != null && p.forward[i].data < value){
                p = p.forward[i];//ת����һ��
            }
        }
        if(p.forward[0] != null && p.forward[0].data == value){
            return p.forward[0];
        }
        else{
            return null;
        }
    }
    public class Node{
        private int data = -1;
        private Node forward[] = new Node[MAX_LEVEL];
        private int maxlevel = 0;
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxlevel);
            builder.append(" }");
            return builder.toString();
        }
    }
}
