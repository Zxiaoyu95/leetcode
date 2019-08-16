package Test;
/**
 *实现单链表的反转 
 * 实现链表中环的检测
 * 两个有序链表的合并
 * 删除链表倒数第n个节点
 * 求链表中间节点
 * 
 * Author:leo zhang
 */
public class LinkedListAlgo {
    //单链表的反转
	public Node reverse(Node list){
		Node headnode=null;
		Node pre=null;
		Node next=null;
		while(list != null){
			next=list.getNext();
			if(next == null){
				headnode=list;//最后只剩一个节点后，将headnode指向该节点，之后通过下面步骤连接到表头
			}
			list.setNext(pre);
			pre=list;
			list=next;//最后list变为null，循环结束
		}
		return headnode;
	}
	//检测环
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
	//两个有序链表的合并
	public Node mergeSortedLists(Node la, Node lb) {
		if(la==null)return lb;
		if(lb==null)return la;
		Node p=la;
		Node q=lb;
		Node head;
		//确定表头
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
		if(p != null){//那么q一定为空
			tmp.next=p;
		}
		else{
			tmp.next=q;
		}
		return head;
	}
	//删除倒数第K的节点
	//利用对称原理，快指针先走k，然后与慢指针一起走，直到快指针走到头 1-------k-----n-k-------n
	public Node deleteLastKth(Node list,int k){
		Node fast = list;
		Node slow = list;
		Node pre = null;
		int count =1;
		while(fast != null && count < k){
			fast=fast.next;
			count++;
		}
		if(fast == null){//k超过了链表长度
			return list;
		}
		while(fast.next != null){
			fast=fast.next;
			pre=slow;
			slow=slow.next;
		}
		//注意如果k==n，即要删除的是第一个节点，此时pre=null，只需要将list指针往后移一位
		if(pre == null){
			list=list.next;
		}
		else{
			pre.next=pre.next.next;
		}
		return list;
	}
	//查找链表中间位置
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
