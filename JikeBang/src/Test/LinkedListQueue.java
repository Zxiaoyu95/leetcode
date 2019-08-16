package Test;

import java.util.Scanner;

public class LinkedListQueue {
	private Node head;
	private Node tail;
	private int n=0;
	private int count=0;
	public LinkedListQueue(int capacity){
		this.head=this.tail=null;
		this.n=capacity;
	}
	public boolean enqueue(String data){
		if(count==n){return false;}
		if(tail==null){head=tail=new Node(data,null);}
		else{
			tail.setNext(new Node(data,null));
			tail=tail.getNext();
			count++;
		}
		return true;
	}
	public String dequeue(){
		if(count==0){System.out.println("没有数据出队！");}
		String data =head.getData();
		head=head.getNext();
		count--;
		if (head == null) {//初始化队列
		      tail = null;
		    }
		return data;
	}
	public void printAll(){
		Node p=head;
		while(p != null){
			System.out.println(p.data);
			p=p.next;
		}
		System.out.println();
	}
	public class Node{
		private String data;
		private Node next;
		public Node(String data,Node next){
			this.data=data;
			this.next=next;
		}
		public void setNext(Node next){
			this.next=next;
		}
		public void setData(String data){
			this.data=data;
		}
		public Node getNext(){
			return next;
		}
		public String getData(){
			return data;
		}
	}
	public static void main(String[] args) {
		LinkedListQueue lq =new LinkedListQueue(10);
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			lq.enqueue(sc.next());
		}
		System.out.println("\n");
		lq.dequeue();
		lq.dequeue();
		lq.printAll();
	}
}
