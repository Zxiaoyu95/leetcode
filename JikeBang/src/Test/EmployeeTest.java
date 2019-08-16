package Test;

import java.util.Scanner;

public class EmployeeTest {
	public static void main(String []args){
		 Integer a=3;
		 Character b='q';
		 System.out.println(Character.isDigit(b));
		 System.out.println(a.byteValue());
		 System.out.println(a.compareTo(2));
		 System.out.println(a.compareTo(3));
		 System.out.println(a.compareTo(4));
		 System.out.println(a.equals(5));
		 String w="qweqewqeqweqw";
		 String str="";
		 char[] ss={'1','w','e','r'};
		 StringBuffer sb=new StringBuffer("qweq");
		 System.out.println(w.charAt(3));
		 System.out.println(w.compareTo("2222"));
		 System.out.println(w.contentEquals(sb));
		 System.out.println(str.copyValueOf(ss, 1, 2));
		 Scanner sc =new Scanner(System.in);
		 String str1 = null;
		 if (sc.hasNext()){
			 str1=sc.next();
		 }
	      /* 使用构造器创建两个对象 */
	      Employee empOne = new Employee("RUNOOB1");
	      Employee empTwo = new Employee("RUNOOB2");
	 
	      // 调用这两个对象的成员方法
	      empOne.empAge(26);
	      empOne.empDesignation(str1);
	      empOne.empSalary(100000);
	      empOne.printEmployee();
	 
	      empTwo.empAge(21);
	      empTwo.empDesignation("菜鸟程序员");
	      empTwo.empSalary(500);
	      empTwo.printEmployee();
	   }
}
