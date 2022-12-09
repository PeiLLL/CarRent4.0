package DataBase;

import Cars.Vehicle;

import java.sql.*;
import java.util.Scanner;

public class DoCar extends JDBC {
    JDBC jdbc = new JDBC();

    PreparedStatement ps = null;
    Vehicle v = new Vehicle();
    Scanner in = new Scanner(System.in);

    //删除
    public void delete(int num) {
        try {
            Connection conn = jdbc.connectionDatabase();
            ps = conn.prepareStatement("delete from car where id = ?");
            ps.setInt(1, num);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功！");
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
    //显示
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
                System.out.printf("编号："+v.getVehicleNum() +".%-8s"+ "%-12s\t" + "%-12s\t" + "%-2d"+"座" + "      \t%-2s\t"+"(t)" + "      %-6.2f"+"元/天\t\n"
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
    //添加
    public void add() {
        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("insert into car values (?,?,?,?,?,?,?)");
            System.out.println("下面开始输入想要添加的车辆的信息：");
            System.out.println("输入编号：");
            ps.setInt(1,in.nextInt());
            System.out.println("输入车辆品牌型号：");
            ps.setString(2,in.next());
            System.out.println("输入车牌号：");
            ps.setString(3,in.next());
            System.out.println("座位数：");
            ps.setInt(4,in.nextInt());
            System.out.println("载重量：");
            ps.setInt(5,in.nextInt());
            System.out.println("日租金：");
            ps.setInt(6,in.nextInt());
            System.out.println("车辆类型：");
            ps.setString(7,in.next());
            int i = ps.executeUpdate();
            if (i > 0){
                System.out.println("插入成功！");
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

    //查找
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
                    System.out.println("你选择的车辆日租金为："+(rs.getDouble(6))+"元");
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
                System.out.println("插入成功！");
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