package com.kh.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Jojang {

	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<Integer>();  
		while(true){
			numbers.add((int)(Math.random() * 9));
			if(numbers.size() == 5){
				break;
			}
		}

		System.out.println("조장이 되실 분의 번호");
		String[] names = {"장건희", "최태영", "박경호", "나신의", "유지상", "김기영", "고재준", "안보람", "하성미"};
		
		Scanner sc = new Scanner(System.in);
		int j = 1;
		for(int i : numbers){
			sc.nextLine();
			System.out.print(j + "번째 조장 번호 : " + names[i]);
			j++;
		}
	}
}