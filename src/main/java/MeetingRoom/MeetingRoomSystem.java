package MeetingRoom;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MeetingRoomSystem {
    private Map<Room, Set<Reservation>> reservation;

    public MeetingRoomSystem() {
        this.reservation = new TreeMap<>();
    }

    /**
     * binary search  for the smallest room  with capacity
     * larger than the number of request.participants
     */
    public void makeReservation(Request request) {

    }
}
