﻿package ex;
/*
 * Topic: 請設計 Person 類別 (姓名,性別,身高,體重)，使用者可以新增個人資料，每新增一筆就會列出目前的資料串有哪些人，而這些資料請用插入排序法依每一個人的 BMI 值由大到小排序。
 * Date: 2016/12/05
 * Author: 103051089 林冠磊
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ex03_103051089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> perList = new ArrayList<Person>();
		boolean sw =true;
		while(sw){
			System.out.println("(姓名,性別,身高,體重)");
			String name = sc.next();
			String sex = sc.next();
			float hight = sc.nextFloat();
			float weight = sc.nextFloat();
			while(true){
				if(hight>0){
					break;
				}else{
					System.out.println("身高Error");
					hight = sc.nextFloat();
				}
			}
			while(true){
				if(weight>0){
					break;
				}else{
					System.out.println("體重Error");
					weight = sc.nextFloat();
				}
			}
			perList.add(new Person(name,sex,hight,weight));
			System.out.println("more?");
			char chk =sc.next().charAt(0) ;
			if(chk=='N'||chk=='n'){
				sw=false;
			}
		}
		showPerson(perList);
	}
		
		private static void showPerson(ArrayList list){
			for(int i =0;i<list.size();i++){
				System.out.println(list.get(i));
			}
		}
	
}
class Person{
	private String name, sex;
	private float hight , weight;
	public Person(String name1, String sex1 , float hight1, float weight1){
		name = name1;
		sex = sex1;
		hight = hight1;
		weight = weight1;
	}
	public double getBMI(){
		return weight/Math.pow(hight*0.1, 2);
	}
	public void ShowInfo(){
		System.out.println(name+"\t"+sex+"\t"+hight+"\t"+weight+"\t"+getBMI());
	}
}
