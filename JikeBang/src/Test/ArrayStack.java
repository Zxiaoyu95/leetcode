package Test;

import java.util.Scanner;

public class ArrayStack {
	private String[] ss;
	private int n;
	private int count;
	public ArrayStack(int num){
		this.ss=new String[num];
		this.n=num;
		this.count=0;
	}
	public boolean push(String s){
		if(count == n)return false;
		ss[count]=s;
		count++;
		return true;
	}
	public String pop(){
		if(count == 0){
			System.out.println("没有数据可以取出");}
		String tmp = ss[count-1];
		count--;
		return tmp;
	}
	public void printAll(){
		if(ss ==null){System.out.println("该栈空间为空");}
		for(int i=0;i<count;i++){
			System.out.println(ss[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayStack as =new ArrayStack(10);
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			as.push(sc.next());
			as.printAll();
		}
		as.pop();
		as.printAll();
	}

}
