package JiKeTest;

public class Array {
	private int data[];
	private int n;
	private int count;
	public Array(int num){
		this.count=0;
		this.n=num;
		this.data=new int[num];
	}
	//根据索引index查找元素
	public int find(int index){
		if( index<0 || index>=count){
			return -1;
		}
		return data[index] ;
	}
	//插入元素 头部插入，尾部插入
	public boolean insert(int index,int value){
		if(count == n){
			System.out.println("没有多余的位置可以插入!");
			return false;
		}
		if(index<0 || index > count){
			System.out.println("插入位置不合法");
			return false;
		}
		for(int i=count;i>index;i--){
			data[i]=data[i-1];
		}
		data[index]=value;
		count++;
		return true;
	}
	//根据索引 删除位置上数据
	public boolean delete(int index){
		if(count == 0){
			System.out.println("没有的数据可以删除!");
			return false;
		}
		if(index<0 || index >= count){
			System.out.println("删除位置不合法");
			return false;
		}
		for(int i=index;i<count;i++){
			data[i]=data[i+1];
		}
		count--;
		return true;
	}
	public void printRes(){
		for(int i=0;i<count;i++){
			System.out.println(data[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Array a =new Array(10);
		a.printRes();
		a.insert(0, 99);
		a.insert(1, 66);
		a.insert(2, 77);
		a.insert(3, 25);
		a.insert(4, 34);
		a.insert(5, 23);
		a.printRes();
		a.insert(3, 111);
		a.printRes();
	}
}
