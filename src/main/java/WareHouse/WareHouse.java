package WareHouse;

import WareHouse.Filters.IFilter;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private IFilter filter;
    private List<IProduct> productList;

    public WareHouse(final IFilter filter) {
        this.filter = filter;
        this.productList = new ArrayList<>();
    }

    public void addProduct(IProduct product){
        if (validateProduct(product)){
            productList.add(product);
        }
    }

    private boolean validateProduct(final IProduct product){
        return this.filter.validate(product);
    }
}
