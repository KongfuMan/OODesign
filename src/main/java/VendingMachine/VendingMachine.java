package VendingMachine;

import VendingMachine.Exception.NotEnoughMoneyException;
import VendingMachine.Exception.NotEnoughStockException;
import VendingMachine.Exception.UnknownItemInforamtionException;
import VendingMachine.States.*;

import java.util.List;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;

    private Map<Coin, Integer> changes;
    private Stock stock;
    private Map<String, ItemInfo> itemInfoMap;
    private Map<ItemInfo, Integer> selectedItemInfo;
    //    private List<Coin> coins;
    private int currValue;

    private IState hasSelectionState = new HasSelectionState(this);
    private IState noSelectionState = new NoSelectionState(this);
    private IState coinInsertedState = new CoinInsertedState(this);
    private IState soldState = new SoldState(this);

    private IState currState = null;

    private VendingMachine() {
        setNoSelectionState();
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setHasSelectionState() {
        currState = hasSelectionState;
    }

    public void setNoSelectionState() {
        currState = noSelectionState;
    }

    public void setCoinInsertedState() {
        currState = coinInsertedState;
    }

    public void setSoldState() {
        currState = soldState;
    }


    /**
     * user press the button on the panel to input the item info id
     * and count of item.
     */
    public void selectItemInfo(String info, int count) throws NotEnoughStockException, UnknownItemInforamtionException {
        currState.selectItem(info, count);
    }

    public void selectCurrItemInfo(String info, int count) throws NotEnoughStockException, UnknownItemInforamtionException {
        ItemInfo itemInfo = itemInfoMap.get(info);
        stock.getAndUpdateItems(itemInfo, count);
        selectedItemInfo.put(itemInfo, count);
    }

    public void insertCoin(Coin coin) {
        currState.insertCoin(coin);
    }

    public void addCoins(Coin coin) {
        currValue += coin.getValue();
    }

    /**
     * user insert the changes and confirm purchase
     */
    public void executeTransaction() throws NotEnoughMoneyException {
        currState.executeTransaction();
    }

    public void purchase() throws NotEnoughMoneyException {
        int price = calculatePrice();
        if (currValue < price) {
            throw new NotEnoughMoneyException();
        }
        returnChange(currValue - price);
        reset();
    }

    public void cancelTransaction() {
        currState.cancelTransaction();
    }

    /**
     * The min count of changes to return for exactly exchange.
     * Assume for each denomination, there are unlimited amount
     *
     * @return: amount for each denomination.
     */
    public List<List<Coin>> returnChange(int amount) {

        return null;
    }

    /**
     * Cancel the transaction and reset the state to no selection
     */
    public void cancelCurrTransaction() {
        int total = calculatePrice();
        returnChange(total);
        reset();
    }

    public void printReceipt(boolean print) {
        currState.printReceipt(print);
    }

    public void printCurrReceipt(boolean print) {

    }

    /**
     *  After user select the items, calculate total price
     */
    private int calculatePrice() {
        int total = 0;
        for (ItemInfo info : selectedItemInfo.keySet()) {
            total += selectedItemInfo.get(info) * info.getPrice();
        }
        return total;
    }

    private void reset() {
        selectedItemInfo.clear();
        currValue = 0;
    }
}
