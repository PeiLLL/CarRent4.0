package User;

import java.util.Scanner;

public class Admin extends User{
    public Admin() {
    }

    public int menu() {
        System.out.println("=====================");
        System.out.println("1.�鿴������Ϣ");
        System.out.println("2.��ӳ���");
        System.out.println("3.ɾ������");
        System.out.println("4.�鿴�����������Ӫҵ��");
        System.out.println("0.�˳�");
        System.out.println("=====================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("���������ѡ��Ĳ���: ");
        int choice = scanner.nextInt();
        return choice;
    }
}
