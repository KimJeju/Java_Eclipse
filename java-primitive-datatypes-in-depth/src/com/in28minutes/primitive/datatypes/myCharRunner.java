package com.in28minutes.primitive.datatypes;

public class myCharRunner {

	public static void main(String[] args) {
		
	  myChar myChar = new myChar('c');
	  System.out.println(myChar.isVowel());
	  
	  
	  // myChar���� ���� ���ͷ����� �������� ���ĺ����� boolean ������ ���
	  System.out.println(myChar.isNumber());
	  System.out.println(myChar.isAlphabet());
	  
	  // ��ȯ�Ǵ� ���ͷ����� �ҹ��ڰų� �빮���� ��� ������ �ٲ��ְ� ���
	  System.out.println("");
	  myChar.printLowerCaseAlphabets();
	  myChar.printUpperCaseAlphabets();
	}

}
