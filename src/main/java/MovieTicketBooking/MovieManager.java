package MovieTicketBooking;

import java.util.List;
import java.util.Map;

public class MovieManager {
    Map<String, List<Movie>> stock;


    public List<Movie> findAllMoviesByName(String name){
        return stock.get(name);
    }
}
