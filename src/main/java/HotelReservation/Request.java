package HotelReservation;

import java.util.Date;

/**
 *  Request to query the hotel rooms.
 *
 *
 * */
public class Request {
    private Date startDate;
    private Date endDate;

    public Request(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Request)){
            return false;
        }
        return this.startDate.equals(((Request)o).getStartDate())&&
                this.endDate.equals(((Request)o).getEndDate());
    }

    @Override
    public int hashCode() {
        int res = 17;
        res += res * 31 + startDate.hashCode();
        res += res * 31 + endDate.hashCode();
        return res;
    }
}
