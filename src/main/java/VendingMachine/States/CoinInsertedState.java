package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.Exception.NotEnoughMoneyException;
import VendingMachine.VendingMachine;

public class CoinInsertedState implements IState {
    private VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemId, int count) {
        System.out.println("Cannot select item after insert coins");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Coin has been inserted");

    }

    @Override
    public void executeTransaction() throws NotEnoughMoneyException {
        vendingMachine.purchase();
        vendingMachine.setSoldState();

    }

    @Override
    public void cancelTransaction() {
        vendingMachine.cancelCurrTransaction();
        vendingMachine.setNoSelectionState();

    }

    @Override
    public void printReceipt(boolean print) {
        System.out.println("throw cannot print receipt");
    }
}
