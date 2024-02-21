package com.selenium;

import java.util.Scanner;

import org.testng.annotations.Test;

public class TestNG {
	
	Scanner scanner = new Scanner(System.in);
	int a ,b;
	
	
	@Test
	public void print() {
		System.out.println("Enter First value");
		a = scanner.nextInt();
		
		System.out.println("Enter second value");
		b = scanner.nextInt();
	}
	
	@Test (priority = 2)
	public void eveodd() {
		int c = a+b;
		System.out.println("sum of two numbers is: "+c);
		if(c%2==0){
			System.out.println("sum is even");
			
		}else {
			System.out.println("sum is odd");
		}
		
	}
	
	@Test (enabled = false)
	public void test2() {
		
		int c = a+b;
		
		System.out.println("sum of two numbers: "+c);
		
	}
	
	@Test (priority = 3)
	public void prime() {
		int c = a+b;
		boolean isprime = true;
		
		for(int i = 2; i<=c/2; i++) {
			if(c%i==0) {
				isprime = false;
				break;
				
			}
		}
		if(isprime==true) {
			System.out.println(c+ " is a prime number");
		}else {
			System.out.println(c+ " is a non prime number");
		}
		
		
	}

}
