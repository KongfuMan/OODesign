package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class HasSelectionState implements IState {
    private VendingMachine machine;

    public HasSelectionState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(String itemId, int count) {

    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addCoins(coin);
        machine.setCoinInsertedState();
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
