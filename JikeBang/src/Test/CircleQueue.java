package Test;

public class CircleQueue {
	private String[] CQ;
	private int n;
	private int head=0;
	private int tail=0;
	public CircleQueue(int capacity){
		this.CQ=new String[capacity];
		this.n=capacity;
	}
	public boolean enqueue(String data){
		//�ж϶�����������
		if(head==(tail+1)%n){
			return false;
		}
		else{
			CQ[tail]=data;
			tail=(tail+1)%n;
			return true;
		}
	}
	public String dequeue(){
		//�ж϶���Ϊ�յ�����
		if(head==tail){
			return null;
		}
		else{
			String tmp=CQ[head];
			head=(head+1)%n;
			return tmp;
		}
	}
	public void PrintAll(){
		for(int i=head;i%n < tail;i++){
			System.out.println(CQ[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		CircleQueue cq =new CircleQueue(10);
		cq.enqueue("1");
		cq.enqueue("b");
		cq.PrintAll();
		
	}

}
