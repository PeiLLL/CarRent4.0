package Cars;

//轿车
public class Car extends Vehicle {
    //日租金

    //轿车构造方法

    //车名，品牌，数量，日租金
    public Car(int vehicleNum, String car_Brand, String car_Name, String vehicled, double perRent) {
        this.setCar_Brand(car_Brand);
        this.setCar_Name(car_Name);

        this.setPerRent(perRent);
        this.setVehicleld(vehicled);
        this.setVehicleNum(vehicleNum);
    }

    public Car() {
    }

    public double getPerRent() {
        return getPerRent();
    }

    public void setPerRentcar(double perRent) {
        this.setPerRent(perRent);
    }

    //重写父类计算租金价格方法
    public double calRent(int days, double perRentcar) {
        double calRent = 0;
        if (days > 7 && days <= 30)
            calRent = perRentcar * days * 0.9;
        else if (days > 30 && days <= 150)
            calRent = perRentcar * days * 0.8;
        else if (days > 150)
            calRent = perRentcar * days * 0.7;
        else if (days >= 0 && days <= 7)
            calRent = perRentcar * days;
        return calRent;
    }
}
