package Cars;

public  class Vehicle {
     private String car_Name;//车名
     private String car_Brand;//车的品牌
     private String vehicleld;//车牌号
     private int vehicleNum;//车辆编号
     private double perRent;
     private int seatCount;
     private int weight;
     private String type;
    private int days;
    private double totalrent;

    public double getTotalrent() {
        return totalrent;
    }

    public void setTotalrent(double totalrent) {
        this.totalrent = totalrent;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCar_Name() {
        return car_Name;
    }

    public void setCar_Name(String car_Name) {
        this.car_Name = car_Name;
    }

    public String getCar_Brand() {
        return car_Brand;
    }

    public void setCar_Brand(String car_Brand) {
        this.car_Brand = car_Brand;
    }


    public String getVehicleld() {
        return vehicleld;
    }

    public void setVehicleld(String vehicleld) {
        this.vehicleld = vehicleld;
    }

    public int getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(int vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public double getPerRent() {
        return perRent;
    }

    public void setPerRent(double perRent) {
        this.perRent = perRent;
    }

    public Vehicle() {
     }

     public Vehicle(String car_Name, String car_Brand, String vehicleld, int vehicleNum) {
        this.car_Name = car_Name;
        this.car_Brand = car_Brand;

        this.vehicleld = vehicleld;
        this.vehicleNum = vehicleNum;
     }

     public Vehicle(String car_brand, int car_num, String vehicled, int vehicleNum) {
     }
      //计算租金
     public double calRent(int days, double perRent){
         double carRent = days*perRent;
         return carRent;
     }


     //打印车辆的信息
     public void printCarInfo(){

     }

     public void addCar(){

     }

     public void addBus(){

     }

     public void addTrunk(){

     }

}
