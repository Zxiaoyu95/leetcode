package JiKeTest;

import java.util.Scanner;

/*
 * LRU:插入数据，查找该data是否在该链表中，
 * 如果在该链表中，则现将该数据删除，然后插入数据到链表的头部
 * 如果不在，判断链表是否溢出，溢出则将尾节点删除，然后插入数据到链表的头部
 * **/
public class LRUBaseLinkedList<T> {
	private static final Integer DefaultLen=10;
	private SNode<T> headnode;
	private Integer capacity;
	private Integer length;
	public LRUBaseLinkedList(){
		this.headnode=new SNode<T>(null,null);
		this.capacity=DefaultLen;
		this.length=0;
	}
	public LRUBaseLinkedList(Integer capacity){
		this.headnode=new SNode<T>(null,null);
		this.capacity=capacity;
		this.length=0;
	}
	public void add(T data){
		SNode preNode =findPreNode(data);
		if(preNode !=null){
			delPreElem(preNode);
			insertHead(data);
		}
		else{
				if(length >= this.capacity){delLastElem();}
				insertHead(data);
			}
	}
	//删除prenode节点之后的节点
	private void delPreElem(SNode preNode){
		SNode tmp =preNode.getNext();
		preNode.setNext(tmp.getNext());
		tmp=null;
		length--;
	}
	//添加数据到链表头部
	private void insertHead(T data){
		SNode next = headnode.getNext();
		headnode.setNext(new SNode(data,next));
		length++;
	}
	//删除尾节点
	private void delLastElem(){
		SNode ptr =headnode;
		if(ptr.getNext()==null){
			return;
		}
		while(ptr.getNext().getNext() != null){
			ptr=ptr.getNext();
		}
		SNode tmp =ptr.getNext();
		ptr.setNext(null);
		tmp=null;
		length--;
	}
	//查找data数据之前节点
	private SNode findPreNode(T data){
		SNode node =headnode;
		while(node.getNext()!=null){
			if(data.equals(node.getNext().getElement())){
				return node;
			}
			node=node.getNext();
		}
		return null;
	}
	//遍历链表
	private void printAll(){
		SNode node =headnode.getNext();
		while(node !=null){
			System.out.println(node.getElement());
			node=node.getNext();
		}
		System.out.println();
		
	}
	public class SNode<T>{
		private T element;
		private SNode next;
		public SNode(T element,SNode next){
			this.element=element;
			this.next=next;
		}
		public SNode(T element){
			this.element=element;
		}
		public SNode(SNode next){
			this.next=next;
		}
		public void setElement(T element){
			this.element=element;
		}
		public void setNext(SNode next){
			this.next=next;
		}
		public T getElement(){
			return element;
		}
		public SNode getNext(){
			return next;
		}
	}
	public static void main(String[] args) {
		LRUBaseLinkedList list =new LRUBaseLinkedList();
		Scanner sc = new Scanner(System.in);
		while(true){
			list.add(sc.nextInt());
			list.printAll();
		}
		
	}
}
