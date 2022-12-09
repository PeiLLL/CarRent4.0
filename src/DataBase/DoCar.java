package DataBase;

import Cars.Vehicle;

import java.sql.*;
import java.util.Scanner;

public class DoCar extends JDBC {
    JDBC jdbc = new JDBC();

    PreparedStatement ps = null;
    Vehicle v = new Vehicle();
    Scanner in = new Scanner(System.in);

    //ɾ��
    public void delete(int num) {
        try {
            Connection conn = jdbc.connectionDatabase();
            ps = conn.prepareStatement("delete from car where id = ?");
            ps.setInt(1, num);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("ɾ���ɹ���");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //��ʾ
    public void display() {

        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("select * from car");
            rs = ps.executeQuery();
            while(rs.next()) {
                v.setVehicleNum(rs.getInt(1));
                v.setCar_Brand(rs.getString(2));
                v.setVehicleld(rs.getString(3));
                v.setSeatCount(rs.getInt(4));
                v.setWeight(rs.getInt(5));
                v.setPerRent(rs.getInt(6));
                v.setType(rs.getString(7));
                //System.out.println("%d"+"\t"+ name+"      \t "+vehicleId+"      \t"+seats+"      \t"+weight+"      \t"+perRent);
                System.out.printf("��ţ�"+v.getVehicleNum() +".%-8s"+ "%-12s\t" + "%-12s\t" + "%-2d"+"��" + "      \t%-2s\t"+"(t)" + "      %-6.2f"+"Ԫ/��\t\n"
                        ,v.getType(), v.getCar_Brand(),v.getVehicleld(),v.getSeatCount(), v.getWeight(), v.getPerRent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //���
    public void add() {
        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("insert into car values (?,?,?,?,?,?,?)");
            System.out.println("���濪ʼ������Ҫ��ӵĳ�������Ϣ��");
            System.out.println("�����ţ�");
            ps.setInt(1,in.nextInt());
            System.out.println("���복��Ʒ���ͺţ�");
            ps.setString(2,in.next());
            System.out.println("���복�ƺţ�");
            ps.setString(3,in.next());
            System.out.println("��λ����");
            ps.setInt(4,in.nextInt());
            System.out.println("��������");
            ps.setInt(5,in.nextInt());
            System.out.println("�����");
            ps.setInt(6,in.nextInt());
            System.out.println("�������ͣ�");
            ps.setString(7,in.next());
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("����ɹ���");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //����
    public Vehicle sercth(int carNumber) {
        try {
            Connection conn = jdbc.connectionDatabase();
            ps = conn.prepareStatement("select * from car ");
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setVehicleNum(rs.getInt(1));
                v.setCar_Brand(rs.getString(2));
                v.setVehicleld(rs.getString(3));
                v.setSeatCount(rs.getInt(4));
                v.setWeight(rs.getInt(5));
                v.setPerRent(rs.getDouble(6));
                v.setType(rs.getString(7));

                if((rs.getInt(1)) == carNumber ){
                    System.out.println("��ѡ��ĳ��������Ϊ��"+(rs.getDouble(6))+"Ԫ");
                    return v;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public void addCar(int id,String brand, String vehilded, int seats, int weight, double perrent, String type) {

        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("insert into car values (?,?,?,?,?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,brand);
            ps.setString(3,vehilded);
            ps.setInt(4,seats);
            ps.setInt(5,weight);
            ps.setDouble(6,perrent);
            ps.setString(7,type);

            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("����ɹ���");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}