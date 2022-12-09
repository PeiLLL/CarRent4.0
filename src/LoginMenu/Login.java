package LoginMenu;

import java.util.Scanner;

public class Login {
    public static void showFirstLevelMeun() {
        while (true) {

                UserService userService = new UserServiceImp();
                System.out.println("1、注册    2、登录");
                Scanner sc = new Scanner(System.in);
                String select = sc.nextLine();
                //注册
                if (select.equals("1")) {
                    System.out.println("请输入用户名：");
                    String username = sc.nextLine();
                    System.out.println("请输入密码：");
                    String password = sc.nextLine();
                    System.out.println("请再次输入密码：");
                    String password2 = sc.nextLine();
                    if (password.equals(password2)) {
                        boolean isExists = userService.isExists(username);
                        if (isExists) {
                            System.out.println("此用户名已存在");
                            showFirstLevelMeun();
                        } else {
                            System.out.println("请输入电话号码：");
                            String phone = sc.next();
                            userService.regist(username, password, phone);
                        }
                    } else {
                        System.out.println("您输入的密码不一致");
                        showFirstLevelMeun();
                    }
                } else if (select.equals("2")) {
                    //登录
                    System.out.println("请输入用户名：");
                    String username = sc.nextLine();
                    System.out.println("请输入密码：");
                    String password = sc.nextLine();
                    boolean success = userService.login(username, password);
                    if (success) {
                        System.out.println("登录成功!");
                    } else {
                        System.out.println("用户名或者密码错误");
                        showFirstLevelMeun();
                    }
                } else {
                    System.out.println("您输入的选项不正确");
                    showFirstLevelMeun();
                }
                break;
            }

        }

    }


