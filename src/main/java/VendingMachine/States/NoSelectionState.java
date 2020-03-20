package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.Exception.NotEnoughStockException;
import VendingMachine.Exception.UnknownItemInforamtionException;
import VendingMachine.VendingMachine;

public class NoSelectionState implements IState {
    private VendingMachine vendingMachine;

    public NoSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemId, int count) throws NotEnoughStockException, UnknownItemInforamtionException {
        vendingMachine.selectCurrItemInfo(itemId, count);
        vendingMachine.setHasSelectionState();

    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public void executeTransaction() {

    }

    @Override
    public void cancelTransaction() {

    }

    @Override
    public void printReceipt(boolean print) {
        System.out.println("cannot print receipt");
    }
}
