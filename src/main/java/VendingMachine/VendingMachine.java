package VendingMachine;

import VendingMachine.Exception.NotEnoughMoneyException;
import VendingMachine.Exception.UnknownItemInforamtionException;

import java.util.List;
import java.util.Map;

public class VendingMachine {
    private List<Coin> coins;
    private Stock stock;
    private Map<String, ItemInfo> itemInfoMap;
    private Map<ItemInfo, Integer> selectedItemInfo;
    private List<Coin> currCoins;


    /** user press the button on the panel to input the item info id
     *  and count of item.
     *
     *
     * */
    public void selectItemInfo(String info, int count) throws UnknownItemInforamtionException {
        if (!itemInfoMap.containsKey(info)){
            throw new UnknownItemInforamtionException();
        }
        ItemInfo itemInfo = itemInfoMap.get(info);
        selectedItemInfo.put(itemInfo, count);
    }

    /** After user select the items, calculate total price
     *
     * */
    public int calculatePrice(){
        int total = 0;
        for (ItemInfo info : selectedItemInfo.keySet()){
            total += selectedItemInfo.get(info) * info.getPrice();
        }
        return total;
    }

    public void insertCoin(Coin coin){
        currCoins.add(coin);
    }

    /**calculate the amount of all inserted coins
     *
     * */
    public int getCoinValue(){
        int value = 0;
        for (Coin coin : currCoins){
            value += coin.getValue();
        }
        return value;
    }

    /**user insert the coins and confirm purchase
     *
     * */
    public void purchase() throws NotEnoughMoneyException {
        int price = calculatePrice();
        int value = getCoinValue();
        if (value < price){
            throw new NotEnoughMoneyException();
        }
        returnExchange(value - price);
    }

    /**The min count of coins to return for exactly exchange.
     * Assume for each denomination, there are unlimited amount
     *
     *
     * @return: amount for each denomination.
     * */
    public List<List<Coin>> returnExchange(int amount){

        return null;
    }


}
