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

	}

}
