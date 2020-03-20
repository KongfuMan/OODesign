package HotelReservation;

import java.util.Date;
import java.util.Map;

public class ReservationRequest {
    private Map<RoomType, Integer> roomNeeds;
    private Date startDate;
    private Date endDate;

    public Map<RoomType, Integer> getRoomNeeds() {
        return roomNeeds;
    }

    public void setRoomNeeds(Map<RoomType, Integer> roomNeeds) {
        this.roomNeeds = roomNeeds;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
