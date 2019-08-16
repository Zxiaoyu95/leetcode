package Test;

import java.util.Scanner;

public class ArrayQueue {
	private String[] Queue;
	private int n =0;
	private int head;
	private int tail;
	public ArrayQueue(int capacity){
		this.Queue = new String[capacity];
		this.n=capacity;
	}
	public boolean enqueue(String s){
		//如果数据无法插入，可以用到数据搬移技术，重新分配head与tail
		if(tail==n){
			if(head==0)
			{return false;}
			for(int i=head;i<tail;i++){
				Queue[i-head]=Queue[i];
			}
			tail-=head;///么想到！其实可以归纳出来
			head=0;
		}
		Queue[tail]=s;
		tail++;
		return true; 
	}
	public String dequeue(){
		if(head == tail){
			System.out.println("没有数据可以删除！");
		}
		String tmp = Queue[head];
		head++;
		return tmp;
		
	}
	public void printAll(){
		for(int i=head;i<=tail;i++){
			System.out.println(Queue[i]);
		}
	}
	public static void main(String[] args) {
		ArrayQueue aq =new ArrayQueue(10);
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			aq.enqueue(sc.next());
		}
		System.out.println("\n");
		aq.dequeue();
		aq.dequeue();
		aq.printAll();
	}
}
