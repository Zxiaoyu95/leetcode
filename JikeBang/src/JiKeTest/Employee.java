package JiKeTest;

public class Employee {
	String name;
	   int age;
	   String designation;
	   double salary;
	   // Employee ��Ĺ�����
	   public Employee(String name){
	      this.name = name;
	   }
	   // ����age��ֵ
	   public void empAge(int empAge){
	      this.age =  empAge;
	   }
	   /* ����designation��ֵ*/
	   public void empDesignation(String empDesig){
	      this.designation = empDesig;
	   }
	   /* ����salary��ֵ*/
	   public void empSalary(double empSalary){
	      this.salary = empSalary;
	   }
	   /* ��ӡ��Ϣ */
	   public void printEmployee(){
	      System.out.println("����:"+ name );
	      System.out.println("����:" + age );
	      System.out.println("ְλ:" + designation );
	      System.out.println("нˮ:" + salary);
	   }
}
