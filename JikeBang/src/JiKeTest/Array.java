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
	//��������index����Ԫ��
	public int find(int index){
		if( index<0 || index>=count){
			return -1;
		}
		return data[index] ;
	}
	//����Ԫ�� ͷ�����룬β������
	public boolean insert(int index,int value){
		if(count == n){
			System.out.println("û�ж����λ�ÿ��Բ���!");
			return false;
		}
		if(index<0 || index > count){
			System.out.println("����λ�ò��Ϸ�");
			return false;
		}
		for(int i=count;i>index;i--){
			data[i]=data[i-1];
		}
		data[index]=value;
		count++;
		return true;
	}
	//�������� ɾ��λ��������
	public boolean delete(int index){
		if(count == 0){
			System.out.println("û�е����ݿ���ɾ��!");
			return false;
		}
		if(index<0 || index >= count){
			System.out.println("ɾ��λ�ò��Ϸ�");
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
