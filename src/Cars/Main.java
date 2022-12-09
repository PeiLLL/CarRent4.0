package Cars;

import DataBase.DoCar;
import DataBase.DoUserCar;
import LoginMenu.Login;
import User.Admin;

import java.util.Scanner;

//租赁系统
public class Main {
Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //新建一个服务器系统
        Main service = new Main();
        Scanner scanner = new Scanner(System.in);
        DoCar d = new DoCar();
        while (true) {
            System.out.println("欢迎来到汽车租赁系统，请选择：");
            System.out.println("ceshi");
            System.out.println("");

            System.out.println("0.管理员     1.用户");
            System.out.println("");
            System.out.print("请输入您的选择:");
            int choice = scanner.nextInt();

            if (choice == 0) {
                Admin admin = new Admin();

                while (true) {
                    int choose = admin.menu();

                    if (choose == 1) {
                        d.display();
                        continue;
                    } else if (choose == 2) {
                        System.out.println("下面是现在拥有的车辆：");
                        d.display();
                        d.add();
                    }else if(choose == 3){
                        System.out.println("下面是现在拥有的车辆：");
                        d.display();
                        System.out.println("输入你想删除的车辆编号:");
                        int delete = scanner.nextInt();
                        d.delete(delete);
                    }else if(choose == 4) {
                        DoUserCar duc = new DoUserCar();
                        System.out.println("已租出的车辆有：");
                        duc.displayUserCar();
                        System.out.println("总营业额为：");
                        double totolmoney = duc.money();
                        System.out.println(totolmoney);
                    }else if (choose == 0)
                        break;
                }
            }
         else if (choice == 1) {
            Login.showFirstLevelMeun();
            service.menu();

            int chooseNum = scanner.nextInt();

            while (true) {
                if (chooseNum == 1) {
                    service.rentCar();
                    break;
                } else if (chooseNum == 2) {
                        service.sendBack();
                        break;
                } else if (chooseNum == 3){
                    DoUserCar duc = new DoUserCar();
                    duc.displayUserCar();
                    break;
                }else if (chooseNum == 0) {
                    System.out.println("您已退出该系统");
                    System.exit(0);
                } else {
                    System.out.println("输入错误，请重新输入");
                    continue;
                }
            }

        } else {
            System.out.println("请重新输入：");
            continue;
        }
        break;
    }}


                void menu () {
                    System.out.println("====欢迎来到1" + "汽车租赁中心====");
                    System.out.println("====请选择你需要的服务====");
                    System.out.println("1.租赁车辆 2.退换车辆 3.显示最近租赁的车辆 0.退出该系统");
                }

                //租赁车辆服务内容
                double rentCar () {
                    double totalRent = 0;
                    Scanner scanner = new Scanner(System.in);
                    DoCar d = new DoCar();
                    DoUserCar duc = new DoUserCar();

                    while (true) {
                        System.out.println("====请选择您需要的汽车类型====");
                        System.out.println("1.轿车  2.客车  3.货车");
                        System.out.println("（不同类型车辆优惠方法不同）");
                        int carType = scanner.nextInt();
                        if (carType == 1) {

                            System.out.println("下面是目前拥有的车辆：");
                            d.display();
                            System.out.println("请输入您选择要租的汽车编号");
                            int carNumber = scanner.nextInt();
                            Vehicle c = d.sercth(carNumber);

                            if ( c != null) {
                                //如果存在这辆车，并且数量大于零。就输入租用天数，计算总租金
                                Car car = new Car();
                                System.out.println("请选择您要租用轿车的时长(天)");
                                int days = scanner.nextInt();
                                 totalRent = car.calRent(days,c.getPerRent());
                                System.out.println("您本次租车的总租金为 " + totalRent + "元");

                                d.delete(carNumber);
                                duc.addUserCar(c.getVehicleNum(),c.getCar_Brand(),c.getVehicleld(),c.getSeatCount(),c.getWeight(),totalRent,c.getType(),days,c.getPerRent());
                            } else {
                                //车辆不存在或者数量不够
                                System.out.println("对不起，您选择的车辆不存在或数量不足，请重新输入");
                                continue;
                            }
                        } else if (carType == 2) {
                            while (true) {

                                System.out.println("下面是目前拥有的车辆：");
                                d.display();
                                System.out.println("请输入您选择要租的客车编号");
                                int busNumber = scanner.nextInt();
                                Vehicle b= d.sercth(busNumber);

                                if (b != null) {
                                    //如果存在这辆车，并且数量大于零。就输入租用天数，计算总租金
                                    Bus bus= new Bus();
                                    //bus.setPerRentbus(perRentbus);
                                    System.out.println("请选择您要租用客车的时长(天)");
                                    int days = scanner.nextInt();
                                     totalRent = bus.calRent(days,b.getPerRent());
                                    System.out.println("您本次租车的总租金为 " + totalRent + "元");
                                    d.delete(busNumber);
                                    duc.addUserCar(b.getVehicleNum(),b.getCar_Brand(),b.getVehicleld(),b.getSeatCount(),b.getWeight(),totalRent,b.getType(),days,b.getPerRent());

                                    break;

                                } else {
                                    //车辆不存在或者数量不够
                                    System.out.println("对不起，您选择的车辆不存在或数量不足，请重新输入");
                                    continue;
                                }
                            }
                        } else if (carType == 3) {
                            while (true) {

                                System.out.println("下面是目前拥有的车辆：");
                                d.display();
                                //CarData.display();
                                System.out.println("请输入您选择要租的货车编号");
                                int trunkNumber = scanner.nextInt();
                                Vehicle t = d.sercth(trunkNumber);
                                //Vehicle rentalCar = CarData.getCar(trunkNumber);
                                if (t != null) {
                                    //如果存在这辆车，并且数量大于零。就输入租用天数，计算总租金
                                    Trunk trunk = new Trunk();
                                    //trunk.setPerRentTrunk(perRenttrunk);
                                    System.out.println("请选择您要租用货车的时长(天)");
                                    int days = scanner.nextInt();
                                     totalRent = trunk.calRent(days,t.getPerRent());
                                    System.out.println("您本次租车的总租金为 " + totalRent + "元");
                                    d.delete(trunkNumber);
                                    duc.addUserCar(t.getVehicleNum(),t.getCar_Brand(),t.getVehicleld(),t.getSeatCount(),t.getWeight(),totalRent,t.getType(),days,t.getPerRent());


                                break;
                                } else {
                                    //车辆不存在或者数量不够
                                    System.out.println("对不起，您选择的车辆不存在或数量不足，请重新输入");
                                    continue;
                                }
                            }
                        }
                        System.out.println("是否继续租车？(Y/N)");
                        String st = input.next();
                        if(st.equals("Y")  || st.equals("y")){
                            continue;
                        }else
                        break;
                    }

                    return totalRent;
                }
                void sendBack() {
                    Scanner scanner = new Scanner(System.in);
                    DoUserCar duc = new DoUserCar();
                    DoCar d = new DoCar();
                    while (true) {
                    System.out.println("下面是你最近租赁的车辆：");
                    duc.displayUserCar();
                    System.out.println("");
                    System.out.println("选择你要退还的车辆编号:");
                    int carnum = scanner.nextInt();
                    Vehicle v = duc.sercthUserCar(carnum);

                    if (v != null) {
                        duc.deleteUserCar(v.getVehicleNum());
                        d.addCar(v.getVehicleNum(),v.getCar_Brand(),v.getVehicleld(),v.getSeatCount(),v.getWeight(),v.getPerRent(),v.getType());
                        System.out.println("是否继续退还（Y/N）");
                        String s = input.next();
                    if(s.equals("Y")  || s.equals("y")){
                        continue;
                    }else
                        break;

                    } else {
                         System.out.println("您输入的车辆信息不存在,请重新输入");
                        continue;
                    }
                    }
            System.out.println("退还成功");

            scanner.close();
    }
}



