package JiKeTest;

import java.util.Scanner;

public class StackBasedOnLinkList {
	private Node top;
	private int n;
	private int size;
	public StackBasedOnLinkList(int size){
		this.top=null;
		this.size=size;
		this.n=0;
	}
	public void push(String data){
		Node newnode =new Node(data,null);
		if(n == size){
			System.out.println("栈中没有空间可以插入");
		}
		if(top == null){
			top=newnode;
		}
			else{
				newnode.setNext(top);
				top=newnode;
				n++;}
		
	}
	public String pop(){
		if( n<=0 || top ==null){System.out.println("没有数据了");}
		String tmpdata=top.getData();
		top=top.getNext();
		n--;
		return tmpdata;
	}
	public void printAll(){
		Node p =top;
		while(p!=null){
			System.out.println(p.getData());
			p=p.getNext();
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
		public String getData(){
			return data;
		}
		public Node getNext(){
			return next;
		}
		public void setData(String data){
			this.data=data;
		}
		public void setNext(Node next){
			this.next=next;
		}
	}
	public static void main(String[] args) {
	StackBasedOnLinkList sbol =new StackBasedOnLinkList(10);
	Scanner sc =new Scanner(System.in);
	while(sc.hasNext()){
		sbol.push(sc.next());
		sbol.printAll();
	}
	sbol.pop();
	sbol.printAll();
}
}
