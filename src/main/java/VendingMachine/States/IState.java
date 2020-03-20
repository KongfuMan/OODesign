package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.Exception.NotEnoughMoneyException;
import VendingMachine.Exception.NotEnoughStockException;
import VendingMachine.Exception.UnknownItemInforamtionException;

import java.util.List;

public interface IState {
    void selectItem(String itemId, int count) throws NotEnoughStockException, UnknownItemInforamtionException;

    void insertCoin(Coin coins);

    void executeTransaction() throws NotEnoughMoneyException;

    void cancelTransaction();

    void printReceipt(boolean print);
}
