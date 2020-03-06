package Restanrant;

import Restanrant.Exceptions.NoTableException;
import Restanrant.Exceptions.NotEnoughSeatsException;
import Restanrant.Exceptions.TakeUnavailableTableException;

import java.util.List;

public class Restaurant {
    private List<Meal> menue;
    private List<Table> tables;


    /**
     * find a table that have enough seats for the party.
     * So Table class should have two attributes:
     *  available,  size(suppose we don't consider the size for now)
    *
    * */
    private Table findTable(Party party) throws NoTableException{
        for (Table table : tables){
            if (table.isAvailable() && party.getCapacity() <= table.getAvailableCnt()){
                return table;
            }
        }
        throw new NoTableException();
    }

    public Order orderMeal(Party party, List<Meal> meals) throws NoTableException, TakeUnavailableTableException, NotEnoughSeatsException {
        Table table = findTable(party);
        table.takeSeats(party.getCapacity());
        table.markUnavailable();
        return new Order(party, meals, table);
    }

    /** Take the order from a party and return an order
     * step1:  find a table for the part
     * step2: Generate an order for the party
     *
    * */
    public void takeOrder(Order order){

    }

    /** Check out the order.
     * Step1. calculate the fees
     * Step2. Clear talbe and marked it as available
     *
    * */
    public float checkOut(Order order){
        float total = 0.f;
        List<Meal> meals = order.getMeals();
        for (Meal meal : meals){
            total += meal.getPrice();
        }
        Table table = order.getTable();
        table.markAvaiable();
        return total;
    }
}
