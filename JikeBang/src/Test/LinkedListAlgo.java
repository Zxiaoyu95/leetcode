package Test;
/**
 *ʵ�ֵ�����ķ�ת 
 * ʵ�������л��ļ��
 * ������������ĺϲ�
 * ɾ����������n���ڵ�
 * �������м�ڵ�
 * 
 * Author:leo zhang
 */
public class LinkedListAlgo {
    //������ķ�ת
	public Node reverse(Node list){
		Node headnode=null;
		Node pre=null;
		Node next=null;
		while(list != null){
			next=list.getNext();
			if(next == null){
				headnode=list;//���ֻʣһ���ڵ�󣬽�headnodeָ��ýڵ㣬֮��ͨ�����沽�����ӵ���ͷ
			}
			list.setNext(pre);
			pre=list;
			list=next;//���list��Ϊnull��ѭ������
		}
		return headnode;
	}
	//��⻷
	public boolean checkCircle(Node list){
		if(list==null){
			return false;
		}
		Node slow=list;
		Node fast=list.getNext();
		while(fast != null&& fast.getNext() != null){
			fast=fast.getNext().getNext();
			slow=slow.getNext();
			if(fast==slow){
				return true;
			}
		}
		return false;
	}
	//������������ĺϲ�
	public Node mergeSortedLists(Node la, Node lb) {
		if(la==null)return lb;
		if(lb==null)return la;
		Node p=la;
		Node q=lb;
		Node head;
		//ȷ����ͷ
		if(p.getData()<q.getData()){
			head=p;
			p=p.getNext();
		}
		else{
			head=q;
			q=q.getNext();
		}
		Node tmp=head;
		while(q !=null && p != null){
			if(p.getData()<q.getData()){
				tmp.next=p;
				p=p.getNext();
				tmp=tmp.next;
			}
			else{
				tmp.next=q;
				q=q.getNext();
				tmp=tmp.next;
			}
		}
		if(p != null){//��ôqһ��Ϊ��
			tmp.next=p;
		}
		else{
			tmp.next=q;
		}
		return head;
	}
	//ɾ��������K�Ľڵ�
	//���öԳ�ԭ����ָ������k��Ȼ������ָ��һ���ߣ�ֱ����ָ���ߵ�ͷ 1-------k-----n-k-------n
	public Node deleteLastKth(Node list,int k){
		Node fast = list;
		Node slow = list;
		Node pre = null;
		int count =1;
		while(fast != null && count < k){
			fast=fast.next;
			count++;
		}
		if(fast == null){//k������������
			return list;
		}
		while(fast.next != null){
			fast=fast.next;
			pre=slow;
			slow=slow.next;
		}
		//ע�����k==n����Ҫɾ�����ǵ�һ���ڵ㣬��ʱpre=null��ֻ��Ҫ��listָ��������һλ
		if(pre == null){
			list=list.next;
		}
		else{
			pre.next=pre.next.next;
		}
		return list;
	}
	//���������м�λ��
    public Node findMind(Node list){
		Node fast=list;
		Node slow =list;
		while(fast.next != null && fast.next.next != null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	public class Node{
		private int data;
		private Node next;
		public Node(int data,Node next){
			this.data=data;
			this.next=next;
		}
		public void setData(int data){
			this.data=data;
		}
		public void setNext(Node next){
			this.next=next;
		}
		public int getData(){
			return this.data;
		}
		public Node getNext(){
			return this.next;
		} 
	}
	public static void main(String[] args) {
		
	}
}
