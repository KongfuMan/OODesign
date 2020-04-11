package WareHouse;

import WareHouse.Exceptions.ExceedsMaxSizeException;
import WareHouse.Exceptions.ExceedsMaxWeightException;
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

    public void addProduct(IProduct product) throws ExceedsMaxWeightException, ExceedsMaxSizeException {
        validateProduct(product);
        productList.add(product);
    }

    private void validateProduct(final IProduct product) throws ExceedsMaxWeightException, ExceedsMaxSizeException {
        this.filter.validate(product);
    }
}
