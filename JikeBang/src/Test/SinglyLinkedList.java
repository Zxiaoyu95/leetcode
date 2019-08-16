package Test;

public class SinglyLinkedList {
	private Node head=null;
	public Node findByValue(int data){
		Node p = head;
		while(p!=null&& p.getData()!=data){
			p=p.getNext();
		}
		return p;
	}
	public Node findByIndex(int index){
		Node p =head;
		int pos =0;
		while(p != null && pos != index){
			pos++;
			p=p.getNext();
		}
		return p;
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
			return data;
		}
		public Node getNext(){
			return next;
		}
	}
	public static void main(String[] args) {
		
	}
}
