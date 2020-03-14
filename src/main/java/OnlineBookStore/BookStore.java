package OnlineBookStore;


import OnlineBookStore.Item.Item;

import java.util.List;
import java.util.Map;

/** 1.User select a {@BookInfo} and specify the amount, add them in the shopping cart
 *  2.User hit purchase to generate an order
 *  3.User pay for the order, multiple payment method available(paypal, credit card...)
 *
 * */
public class BookStore {
    private Stock stock;
    private Map<Item, Integer> selected;

    public void selectItems(Map<Item, Integer> select){

    }
}
