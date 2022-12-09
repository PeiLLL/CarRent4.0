package LoginMenu;

import java.util.Scanner;

public class Login {
    public static void showFirstLevelMeun() {
        while (true) {

                UserService userService = new UserServiceImp();
                System.out.println("1��ע��    2����¼");
                Scanner sc = new Scanner(System.in);
                String select = sc.nextLine();
                //ע��
                if (select.equals("1")) {
                    System.out.println("�������û�����");
                    String username = sc.nextLine();
                    System.out.println("���������룺");
                    String password = sc.nextLine();
                    System.out.println("���ٴ��������룺");
                    String password2 = sc.nextLine();
                    if (password.equals(password2)) {
                        boolean isExists = userService.isExists(username);
                        if (isExists) {
                            System.out.println("���û����Ѵ���");
                            showFirstLevelMeun();
                        } else {
                            System.out.println("������绰���룺");
                            String phone = sc.next();
                            userService.regist(username, password, phone);
                        }
                    } else {
                        System.out.println("����������벻һ��");
                        showFirstLevelMeun();
                    }
                } else if (select.equals("2")) {
                    //��¼
                    System.out.println("�������û�����");
                    String username = sc.nextLine();
                    System.out.println("���������룺");
                    String password = sc.nextLine();
                    boolean success = userService.login(username, password);
                    if (success) {
                        System.out.println("��¼�ɹ�!");
                    } else {
                        System.out.println("�û��������������");
                        showFirstLevelMeun();
                    }
                } else {
                    System.out.println("�������ѡ���ȷ");
                    showFirstLevelMeun();
                }
                break;
            }

        }

    }


