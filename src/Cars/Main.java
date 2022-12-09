package Cars;

import DataBase.DoCar;
import DataBase.DoUserCar;
import LoginMenu.Login;
import User.Admin;

import java.util.Scanner;

//����ϵͳ
public class Main {
Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //�½�һ��������ϵͳ
        Main service = new Main();
        Scanner scanner = new Scanner(System.in);
        DoCar d = new DoCar();
        while (true) {
            System.out.println("��ӭ������������ϵͳ����ѡ��");
            System.out.println("ceshi");
            System.out.println("");

            System.out.println("0.����Ա     1.�û�");
            System.out.println("");
            System.out.print("����������ѡ��:");
            int choice = scanner.nextInt();

            if (choice == 0) {
                Admin admin = new Admin();

                while (true) {
                    int choose = admin.menu();

                    if (choose == 1) {
                        d.display();
                        continue;
                    } else if (choose == 2) {
                        System.out.println("����������ӵ�еĳ�����");
                        d.display();
                        d.add();
                    }else if(choose == 3){
                        System.out.println("����������ӵ�еĳ�����");
                        d.display();
                        System.out.println("��������ɾ���ĳ������:");
                        int delete = scanner.nextInt();
                        d.delete(delete);
                    }else if(choose == 4) {
                        DoUserCar duc = new DoUserCar();
                        System.out.println("������ĳ����У�");
                        duc.displayUserCar();
                        System.out.println("��Ӫҵ��Ϊ��");
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
                    System.out.println("�����˳���ϵͳ");
                    System.exit(0);
                } else {
                    System.out.println("�����������������");
                    continue;
                }
            }

        } else {
            System.out.println("���������룺");
            continue;
        }
        break;
    }}


                void menu () {
                    System.out.println("====��ӭ����1" + "������������====");
                    System.out.println("====��ѡ������Ҫ�ķ���====");
                    System.out.println("1.���޳��� 2.�˻����� 3.��ʾ������޵ĳ��� 0.�˳���ϵͳ");
                }

                //���޳�����������
                double rentCar () {
                    double totalRent = 0;
                    Scanner scanner = new Scanner(System.in);
                    DoCar d = new DoCar();
                    DoUserCar duc = new DoUserCar();

                    while (true) {
                        System.out.println("====��ѡ������Ҫ����������====");
                        System.out.println("1.�γ�  2.�ͳ�  3.����");
                        System.out.println("����ͬ���ͳ����Żݷ�����ͬ��");
                        int carType = scanner.nextInt();
                        if (carType == 1) {

                            System.out.println("������Ŀǰӵ�еĳ�����");
                            d.display();
                            System.out.println("��������ѡ��Ҫ����������");
                            int carNumber = scanner.nextInt();
                            Vehicle c = d.sercth(carNumber);

                            if ( c != null) {
                                //����������������������������㡣�������������������������
                                Car car = new Car();
                                System.out.println("��ѡ����Ҫ���ýγ���ʱ��(��)");
                                int days = scanner.nextInt();
                                 totalRent = car.calRent(days,c.getPerRent());
                                System.out.println("�������⳵�������Ϊ " + totalRent + "Ԫ");

                                d.delete(carNumber);
                                duc.addUserCar(c.getVehicleNum(),c.getCar_Brand(),c.getVehicleld(),c.getSeatCount(),c.getWeight(),totalRent,c.getType(),days,c.getPerRent());
                            } else {
                                //���������ڻ�����������
                                System.out.println("�Բ�����ѡ��ĳ��������ڻ��������㣬����������");
                                continue;
                            }
                        } else if (carType == 2) {
                            while (true) {

                                System.out.println("������Ŀǰӵ�еĳ�����");
                                d.display();
                                System.out.println("��������ѡ��Ҫ��Ŀͳ����");
                                int busNumber = scanner.nextInt();
                                Vehicle b= d.sercth(busNumber);

                                if (b != null) {
                                    //����������������������������㡣�������������������������
                                    Bus bus= new Bus();
                                    //bus.setPerRentbus(perRentbus);
                                    System.out.println("��ѡ����Ҫ���ÿͳ���ʱ��(��)");
                                    int days = scanner.nextInt();
                                     totalRent = bus.calRent(days,b.getPerRent());
                                    System.out.println("�������⳵�������Ϊ " + totalRent + "Ԫ");
                                    d.delete(busNumber);
                                    duc.addUserCar(b.getVehicleNum(),b.getCar_Brand(),b.getVehicleld(),b.getSeatCount(),b.getWeight(),totalRent,b.getType(),days,b.getPerRent());

                                    break;

                                } else {
                                    //���������ڻ�����������
                                    System.out.println("�Բ�����ѡ��ĳ��������ڻ��������㣬����������");
                                    continue;
                                }
                            }
                        } else if (carType == 3) {
                            while (true) {

                                System.out.println("������Ŀǰӵ�еĳ�����");
                                d.display();
                                //CarData.display();
                                System.out.println("��������ѡ��Ҫ��Ļ������");
                                int trunkNumber = scanner.nextInt();
                                Vehicle t = d.sercth(trunkNumber);
                                //Vehicle rentalCar = CarData.getCar(trunkNumber);
                                if (t != null) {
                                    //����������������������������㡣�������������������������
                                    Trunk trunk = new Trunk();
                                    //trunk.setPerRentTrunk(perRenttrunk);
                                    System.out.println("��ѡ����Ҫ���û�����ʱ��(��)");
                                    int days = scanner.nextInt();
                                     totalRent = trunk.calRent(days,t.getPerRent());
                                    System.out.println("�������⳵�������Ϊ " + totalRent + "Ԫ");
                                    d.delete(trunkNumber);
                                    duc.addUserCar(t.getVehicleNum(),t.getCar_Brand(),t.getVehicleld(),t.getSeatCount(),t.getWeight(),totalRent,t.getType(),days,t.getPerRent());


                                break;
                                } else {
                                    //���������ڻ�����������
                                    System.out.println("�Բ�����ѡ��ĳ��������ڻ��������㣬����������");
                                    continue;
                                }
                            }
                        }
                        System.out.println("�Ƿ�����⳵��(Y/N)");
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
                    System.out.println("��������������޵ĳ�����");
                    duc.displayUserCar();
                    System.out.println("");
                    System.out.println("ѡ����Ҫ�˻��ĳ������:");
                    int carnum = scanner.nextInt();
                    Vehicle v = duc.sercthUserCar(carnum);

                    if (v != null) {
                        duc.deleteUserCar(v.getVehicleNum());
                        d.addCar(v.getVehicleNum(),v.getCar_Brand(),v.getVehicleld(),v.getSeatCount(),v.getWeight(),v.getPerRent(),v.getType());
                        System.out.println("�Ƿ�����˻���Y/N��");
                        String s = input.next();
                    if(s.equals("Y")  || s.equals("y")){
                        continue;
                    }else
                        break;

                    } else {
                         System.out.println("������ĳ�����Ϣ������,����������");
                        continue;
                    }
                    }
            System.out.println("�˻��ɹ�");

            scanner.close();
    }
}



