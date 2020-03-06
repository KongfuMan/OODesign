package ParkingLot.Vehicle;

public abstract class Vehicle {
    protected int size;

    protected Vehicle(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Vehicle size can not be negative");
        }
        this.size = size;
    }

    public int getSize(){
        return size;
    }
}
