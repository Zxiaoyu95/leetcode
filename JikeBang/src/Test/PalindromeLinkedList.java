package Test;

import java.util.Scanner;

import Test.StackBasedOnLinkList.Node;

public class PalindromeLinkedList {
	public boolean isPalindrome(Node head){
		if(head == null || head.getNext()==null){
			return true;
		}
		Node pre =null;
		Node fast =head;
		Node slow =head;
		while(fast !=null && fast.getNext()!=null){
			fast=fast.next.next;
			Node next =null;
			next=slow.next;
			slow.next=pre;
			pre=slow;
			slow=next;
		}
		if(fast != null){//有奇数个节点
			slow=slow.next;
		}
		while(slow != null && pre !=null){
			if(pre.getData() != slow.getData()){
				return false;
			}
			else{
				pre=pre.next;
				slow=slow.next;
			}
			
		}
		return true;
	}
	Node top =null;
	public Node push(String data){
		Node newnode =new Node(data,null);
		if(top == null){
			top=newnode;
		}
			else{
				newnode.setNext(top);
				top=newnode;
			}
		return top;
	}
	public class Node{
		private String data;
		private Node next;
		public Node(String data,Node next){
			this.data=data;
			this.next=next;
		}
		public void setData(String data){
			this.data=data;
		}
		public void setNext(Node next){
			this.next=next;
		}
		public String getData(){
			return data;
		}
		public Node getNext(){
			return next;
		}
	}
	
	public static void main(String[] args) {
		PalindromeLinkedList p=new PalindromeLinkedList();
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			p.push(sc.next());
		}
		while(p.top.next != null){
			System.out.println(p.top.data);
			p.top=p.top.getNext();
		}
		System.out.println(p.isPalindrome(p.top));
	}
}
