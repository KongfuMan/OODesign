package ParkingLot;

import ParkingLot.Vehicle.Vehicle;

import java.util.List;

public class Level {
    private List<Row> rows;
    private int availableCount;

    public List<Spot> findAvailableSpots(Vehicle v){
        // find first row with available spots
        for (Row row : rows){
            List<Spot> spots = row.findAvailableSpots(v);
            if (spots != null){
                return spots;
            }
        }
        return null;
    }

    public int getAvailableCount(){
        return availableCount;
    }
}
