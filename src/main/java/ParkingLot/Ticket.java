package ParkingLot;


import ParkingLot.Vehicle.Vehicle;

import java.sql.Time;
import java.util.List;

// find all the spots the vehicle use
public class Ticket {
    List<Spot> spots;
    Vehicle v;
    Time startTime;

    public Ticket(List<Spot> spots, Vehicle v){
        this.spots = spots;
        this.v = v;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public Vehicle getV() {
        return v;
    }
}
