package WareHouse;

import WareHouse.Filters.IFilter;
import WareHouse.Filters.SizeFilter;
import WareHouse.Filters.WeightFilter;

public class main {
    public static void main(String[] args) {
        IFilter filter = new SizeFilter(10);
        filter = new WeightFilter(100, filter);
        WareHouse wareHouse = new WareHouse(filter);

        IProduct product = new Product(100,12, false);
        wareHouse.addProduct(product);
    }
}
