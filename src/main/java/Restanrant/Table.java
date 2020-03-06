package Restanrant;

import Restanrant.Exceptions.NotEnoughSeatsException;
import Restanrant.Exceptions.TakeUnavailableTableException;

public class Table {
    private boolean available;
    private int capacity;
    private int availableCnt;

    public Table(int capacity) {
        this.capacity = capacity;
        availableCnt = capacity;
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markAvaiable(){
        available = true;
    }

    public void markUnavailable() throws TakeUnavailableTableException {
        if (!available){
            throw new TakeUnavailableTableException();
        }
        available = false;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCnt() {
        return availableCnt;
    }

    public void takeSeats(int n) throws NotEnoughSeatsException{
        if (n > availableCnt){
            throw new NotEnoughSeatsException();
        }
        availableCnt -= n;
    }
}
