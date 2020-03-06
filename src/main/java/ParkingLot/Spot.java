package ParkingLot;

import ParkingLot.Exceptions.TakeUnavailableSpotException;

public class Spot {
    private boolean isAvailable;

    public Spot(){

    }

    public void takeSpot() throws TakeUnavailableSpotException{
        if (!isAvailable){
            throw new TakeUnavailableSpotException();
        }
        isAvailable = false;
    }

    public void freeSpot(){
        isAvailable = true;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
}
