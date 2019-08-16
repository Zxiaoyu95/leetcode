package JiKeTest;

public class BinarySearchTree {
    private Node tree;
    public Node find(int data){
        Node p = tree;
        while(p != null){
            if (p.data > data){p = p.left;}
            else if(p.data < data){
                p = p.right;
            }
            else{return p;}
        }
        return null;
    }
    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while(p != null){
            if(p.data > data){
                if(p.left == null){
                    p.left = new Node(data);
                    return;}
                else{p = p.left;}
            }
            else{
                if(p.right == null){
                    p.right = new Node(data);
                    return;}
                else{p = p.right;}
            }
        }
    }
    public void delete(int data){
        Node p = tree;
        Node pp = null;
        //����Ҫɾ���Ľڵ�
        while(p.data != data && p != null){
            pp = p;
            if(data > p.data)p=p.right;
            else {p = p.left;}
        }
        if(p == null){return;}
        //Ҫɾ���Ľڵ��������ӽڵ㣿������
        if(p.left != null && p.right !=null){
            Node minP = p.right;
            Node minPP = p;
            while(minP.left != null){
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;

        }
        //Ҫɾ���Ľڵ���Ҷ�ӽڵ���߽���һ���ӽڵ�
        Node child;
        if(p.left != null)child = p.left;
        else if (p.right != null)child = p.right;
        else child = null;
        if(pp == null){tree = child;}//ɾ�����Ǹ��ڵ�
        else if (pp.left == p){pp.left = child;}//ɾ������pp���ڵ����ڵ�
        else pp.right = child;//ɾ������pp���ڵ���ҽڵ�
    }
    public static class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data = data;
        }
    }
}
