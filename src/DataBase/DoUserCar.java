package DataBase;

import Cars.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DoUserCar extends JDBC {
    JDBC jdbc = new JDBC();

    PreparedStatement ps = null;
    Vehicle v = new Vehicle();
    Scanner in = new Scanner(System.in);

    //删除
    public void deleteUserCar(int num) {
        try {
            Connection conn = jdbc.connectionDatabase();
            ps = conn.prepareStatement("delete from usercar where id = ?");
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

    public void displayUserCar() {

        //ResultSet rs = null;
        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("select * from usercar");
            rs = ps.executeQuery();
            while(rs.next()) {
                v.setVehicleNum(rs.getInt(1));
                v.setCar_Brand(rs.getString(2));
                v.setVehicleld(rs.getString(3));
                v.setSeatCount(rs.getInt(4));
                v.setWeight(rs.getInt(5));
                v.setTotalrent(rs.getInt(6));
                v.setType(rs.getString(7));
                v.setDays(rs.getInt(8));
                //System.out.println("%d"+"\t"+ name+"      \t "+vehicleId+"      \t"+seats+"      \t"+weight+"      \t"+perRent);
                System.out.printf("编号："+v.getVehicleNum() +".%-8s"+ "%-12s\t" + "%-12s\t" + "%-2d"+"座" + "      \t%-2s"+"(t)\t\t" + "%-4d"+"天"+" \t"+"      共%-6.2f"+"元\t\n"
                        ,v.getType(), v.getCar_Brand(),v.getVehicleld(),v.getSeatCount(), v.getWeight(), v.getDays(),v.getTotalrent());
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

    public void addUserCar(int id,String brand, String vehilded, int seats, int weight, double totalrent, String type,int day,double perrent) {

        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("insert into usercar values (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,brand);
            ps.setString(3,vehilded);
            ps.setInt(4,seats);
            ps.setInt(5,weight);
            ps.setDouble(6,totalrent);
            ps.setString(7,type);
            ps.setInt(8,day);
            ps.setDouble(9,perrent);

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

    public Vehicle sercthUserCar(int carNumber) {

        try {
            Connection conn = jdbc.connectionDatabase();
            ps = conn.prepareStatement("select * from usercar ");
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setVehicleNum(rs.getInt(1));
                v.setCar_Brand(rs.getString(2));
                v.setVehicleld(rs.getString(3));
                v.setSeatCount(rs.getInt(4));
                v.setWeight(rs.getInt(5));
                v.setTotalrent(rs.getDouble(6));
                v.setType(rs.getString(7));
                v.setDays(rs.getInt(8));
                v.setPerRent(rs.getDouble(9));


                if((rs.getInt(1)) == carNumber ){
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
    public double money() {

        //ResultSet rs = null;
        double money = 0;
        try {
            Connection conn = jdbc.connectionDatabase();
            ps =conn.prepareStatement("select * from usercar");
            rs = ps.executeQuery();

            while(rs.next()) {
                v.setVehicleNum(rs.getInt(1));
                v.setCar_Brand(rs.getString(2));
                v.setVehicleld(rs.getString(3));
                v.setSeatCount(rs.getInt(4));
                v.setWeight(rs.getInt(5));
                v.setPerRent(rs.getInt(6));
                v.setType(rs.getString(7));
               money += v.getPerRent();
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
        return money;
    }

}