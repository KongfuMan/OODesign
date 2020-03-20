package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class SoldState implements IState {
    private VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemId, int count) {

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
        vendingMachine.printCurrReceipt(print);
        vendingMachine.setNoSelectionState();
    }
}
