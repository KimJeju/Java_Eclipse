package com.in28minutes.ifstatement.examples;

//����� �Է°��� �޾� �׿� �´� �Լ��� ȣ�����ִ� ����

import java.util.Scanner;  // ��Ʈ�� + 1 �� ���� ����Ʈ �� �� �ִ�. 
                           // ��ĳ�ʴ� �ڹ� ���� Ŭ���� �̱� ������ ����Ʈ�� �ؾ��Ѵ�.
public class MenuRunner {

	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in); //�ν���Ʈ ��ü ���� 
		
		System.out.println("Enter Number1 : ");
		int Number1 = scanner.nextInt();  //����� �Է°��� �޾��ش�.
		
		System.out.println("The Number you Entered is = " + Number1); // ���ڿ� �ڿ� + �� �ٿ��ָ� ������ �ٿ��� ������ش�.
		
		System.out.println("Enter Number2 :");
		int Number2 = scanner.nextInt();
		
		System.out.println("The Number you Enter ed is = " + Number2);
		
		System.out.println("Enter the Menu" + '\n' + "1.add" + '\n' + "2.Multyply");
		int Menu = scanner.nextInt();
		
		if(Menu == 1) {
			int add = Number1 + Number2;
			System.out.println("add = " + add);
		}else if(Menu == 2) {
			int Multiply = Number1 * Number2;
			System.out.println("Multlply =" + Multiply);
		}
		
		
		
		
		
		
		

	}

}
