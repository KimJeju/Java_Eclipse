package loops;

import java.util.Scanner;

public class NavigateNumberRunner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// ����ڿ��� �Է¹��� �ޱ����� scanner Ŭ���� ȣ��
		int Number = -1;

		do {
			if (Number != -1) {
				System.out.println("Cube is " + (Number * Number * Number));
			}
			System.out.print("Enter the Number : ");
			// �������� �޾ƿ��� ���������� ��ȯ
			Number = scanner.nextInt();
		} while (Number >= 0);
		System.out.println("Thank you Have Fun");

	}

}
