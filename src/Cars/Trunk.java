package Cars;



public class Trunk extends Vehicle {
    private int weight;//ÔØÖØÁ¿
    private double perRentTrunk;

    public Trunk() {

    }

    public int getWeight() {
        return weight;
    }

    public double getPerRentTrunk() {
        return perRentTrunk;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public void setPerRentTrunk(double perRentTrunk) {
        this.perRentTrunk = perRentTrunk;
    }

    public Trunk(int vehicleNum, String car_Brand, double perRentTrunk, String vehicled, int weight) {
        this.setVehicleNum(vehicleNum);
        this.setCar_Brand(car_Brand);
        this.setVehicleld(vehicled);
        this.weight = weight;
        this.perRentTrunk = perRentTrunk;
    }

    @Override
    public double calRent(int days, double perRentTrunk) {
       // double perRent = 0;
        double calRent = 0;

        if (days >= 3 && days < 7) {
            calRent= perRentTrunk * days * 0.9;
        } else if (days >= 7 && days < 30)
            calRent= perRentTrunk * days * 0.8;
        else if (days >= 30 && days < 150)
            calRent= perRentTrunk * days * 0.7;
        else if (days >= 150)
            calRent= perRentTrunk * days * 0.6;
        else if(days >= 0 && days < 3)
            calRent= perRentTrunk * days;

        return calRent;
    }




}
