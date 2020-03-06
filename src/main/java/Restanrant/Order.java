package Restanrant;

import java.util.List;

public class Order {
    private Party party;
    private List<Meal> meals;
    private Table table;

    public Order(Party party, List<Meal> meals, Table table) {
        this.party = party;
        this.meals = meals;
        this.table = table;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
