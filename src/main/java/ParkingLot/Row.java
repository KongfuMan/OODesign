package ParkingLot;

import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Spot> spots;


    public Row(int n){
        spots = new ArrayList<Spot>();
        while(n-- > 0){
            spots.add(new Spot());
        }
    }

    // TODO: Finish this algorithm
    public List<Spot> findAvailableSpots(Vehicle v){
        int size = v.getSize();
        // find the adjacent n spots
        int index = 0;
        while(index < spots.size() && !spots.get(index).isAvailable()){
            index++;
        }

        //index of  first available spot
        int left = index;
        for (int right = index + 1; right < spots.size(); right++){
            if (spots.get(right).isAvailable()){
                if ((right - left + 1) >= size){
                    return spots.subList(left, right + 1);
                }
            }else{ //

            }
        }
        return null;
    }
}
