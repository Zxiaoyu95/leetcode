package JiKeTest;

import java.util.Scanner;

/*
 * LRU:�������ݣ����Ҹ�data�Ƿ��ڸ������У�
 * ����ڸ������У����ֽ�������ɾ����Ȼ��������ݵ������ͷ��
 * ������ڣ��ж������Ƿ�����������β�ڵ�ɾ����Ȼ��������ݵ������ͷ��
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
	//ɾ��prenode�ڵ�֮��Ľڵ�
	private void delPreElem(SNode preNode){
		SNode tmp =preNode.getNext();
		preNode.setNext(tmp.getNext());
		tmp=null;
		length--;
	}
	//������ݵ�����ͷ��
	private void insertHead(T data){
		SNode next = headnode.getNext();
		headnode.setNext(new SNode(data,next));
		length++;
	}
	//ɾ��β�ڵ�
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
	//����data����֮ǰ�ڵ�
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
	//��������
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
