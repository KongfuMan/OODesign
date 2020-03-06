package ParkingLot;

import ParkingLot.Exceptions.TakeUnavailableSpotException;
import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;
    private float hourlyRate;


    private ParkingLot(int n) {
        levels = new ArrayList<Level>();
        for (int i = 0; i < n; i++) {
            levels.add(new Level());
        }
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot(100);
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicle v) throws TakeUnavailableSpotException {
        List<Spot> spots = null;
        for (Level level : levels) {
            spots = level.findAvailableSpots(v);
            if (spots != null) {
                break;
            }
        }
        if (spots == null) {
            return null;
        }
        for (Spot spot : spots){
            spot.takeSpot();
        }
        return new Ticket(spots, v);
    }

    public List<Integer> getAllLevelAvailableCount() {
        List<Integer> counts = new ArrayList<>();
        for (Level level : levels) {
            counts.add(level.getAvailableCount());
        }
        return counts;
    }

    public void clearSpots(Ticket ticket) {
        List<Spot> spots = ticket.getSpots();
        for (Spot spot : spots) {
            spot.freeSpot();
        }
    }

    public float checkout(Ticket t) {
        List<Spot> spots = t.getSpots();
        float total = 0.f;
        for (Spot spot : spots) {
            spot.freeSpot();
        }
        return total;
    }
}
