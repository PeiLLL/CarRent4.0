package User;

import java.util.Scanner;

public class Admin extends User{
    public Admin() {
    }

    public int menu() {
        System.out.println("=====================");
        System.out.println("1.查看车辆信息");
        System.out.println("2.添加车辆");
        System.out.println("3.删除车辆");
        System.out.println("4.查看已租出车辆和营业额");
        System.out.println("0.退出");
        System.out.println("=====================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的选择的操作: ");
        int choice = scanner.nextInt();
        return choice;
    }
}
