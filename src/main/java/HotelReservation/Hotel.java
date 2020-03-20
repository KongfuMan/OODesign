package HotelReservation;

import java.util.*;

public class Hotel {
    // store map of RoomType to all the rooms of this type;
    private Map<RoomType, List<Room>> rooms;
    private Map<RoomType, List<Room>> availableRooms;
    private Map<Room, List<Date>> roomReservation;


    private LinkedHashMap<Request, Map<RoomType, Set<Room>>> cache;



    public Map<RoomType, Integer> findAvailableRooms(Request request){
        Map<RoomType, Integer> res = new HashMap<>();
        for (RoomType type : RoomType.values()){
            res.put(type, rooms.get(type).size());
        }
        for (Room room : roomReservation.keySet()){
            List<Date> dates = roomReservation.get(room);
            if (!isValid(request, dates)){
                int count = res.get(room.getType());
                if (count == 1){
                    res.remove(room.getType());
                }else{
                    res.put(room.getType(), count - 1);
                }
            }
        }
        return res;
    }

    /**
     * Check if the request valid for the reserved dates.
     *
     *
     * */
    private boolean isValid(Request request, List<Date> dates){
        Date start = request.getStartDate();
        Date end = request.getEndDate();
        for (Date date : dates){
            if (date.after(start) && date.before(end)){
                return false;
            }
        }
        return true;
    }

    public Reservation makeReservation(ReservationRequest request){

        return null;
    }

    /**
     * Remove the reservation{room list, startDate, endDate}
     * from roomReservation: Map<Room,
     *
     *
     * */
    public void cancleReservation(Reservation reservation){

    }
}
