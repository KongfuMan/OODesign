package WareHouse;

import WareHouse.Exceptions.ExceedsMaxSizeException;
import WareHouse.Exceptions.ExceedsMaxWeightException;
import WareHouse.Filters.IFilter;
import WareHouse.Filters.SizeFilter;
import WareHouse.Filters.WeightFilter;

public class main {
    public static void main(String[] args) {
        IFilter filter = new SizeFilter(10);
        filter = new WeightFilter(100, filter);
        WareHouse wareHouse = new WareHouse(filter);

        IProduct product = new Product(101,10, false);
        try {
            wareHouse.addProduct(product);
        }catch (ExceedsMaxSizeException e){
            System.out.println(e.getMessage());
        }catch (ExceedsMaxWeightException e){
            System.out.println(e.getMessage());
        }
    }
}
