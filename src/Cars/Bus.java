package Cars;

//�ͳ�
public class Bus extends Vehicle {
    //�ͳ����췽��
    //������Ʒ�ƣ���������λ�������Ϳͳ������С�Ϳͳ������
    public Bus(int vehicleNum, String car_Brand, String vehicled, int seatCount, double perRentbus) {
        this.setCar_Brand(car_Brand);
        this.setSeatCount(seatCount);
        this.setPerRent(perRentbus);
        this.setVehicleld(vehicled);
        this.setVehicleNum(vehicleNum);
    }

    public Bus() {

    }

    public int getSeatCount() {
        return getSeatCount();
    }

    public void setSeatCount(int seatCount) {
        setSeatCount(seatCount);
    }

    public double getPerRentbus() {
        return getPerRent();
    }

    public void setPerRentbus(double perRentbus) {
        setPerRent(perRentbus);
    }

    //��д����������۸񷽷�
    @Override
    public double calRent(int days, double perRentbus) {

        double calRent = 0;


        if (days >= 3 && days < 7) {
            calRent= perRentbus * days * 0.9;
        } else if (days >= 7 && days < 30)
            calRent= perRentbus * days * 0.8;
        else if (days >= 30 && days < 150)
            calRent= perRentbus * days * 0.7;
        else if (days >= 150)
            calRent= perRentbus * days * 0.6;
        else if(days >= 0 && days < 3)
            calRent= perRentbus * days;

        return calRent;
    }

}
