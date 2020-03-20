package VendingMachine;

import VendingMachine.Exception.NotEnoughStockException;
import VendingMachine.Exception.UnknownItemInforamtionException;

import java.util.List;
import java.util.Map;

public class Stock {
    /** 两种设计方案：
     *  1.可以将每种ItemInfo对应的货物保存为List<Item>, 例如ItemInfo是可口可乐， Item就是某一罐可口可乐
     *  2. 也可不用保存List<Item>， 直接保存一个数量就行，
     *
     *  取决于我们是否关心每个Item的差异，比如每个Item都有自己的ID, 比如在线商点买的是Macbook pro, 每台需要唯一标识。
     *
     * */
    private Map<ItemInfo, List<Item>> stocks;


    public void refill(ItemInfo itemInfo, List<Item> items){
        if (!stocks.containsKey(itemInfo)){
            stocks.put(itemInfo, items);
        }else{
            stocks.get(itemInfo).addAll(items);
        }
    }

    /**
     * Remove count items and return
     *
     *
     * */
    public List<Item> getAndUpdateItems(ItemInfo itemInfo, int count) throws UnknownItemInforamtionException, NotEnoughStockException {
        if (!stocks.containsKey(itemInfo)){
            throw new UnknownItemInforamtionException();
        }
        if (stocks.get(itemInfo).size() < count){
            throw new NotEnoughStockException();
        }
        List<Item> items = stocks.get(itemInfo);
        List<Item> res = items.subList(0, count);
        stocks.put(itemInfo, items.subList(count, items.size()));
        return res;
    }
}
