package WareHouse.Filters;

import WareHouse.IProduct;

public interface IFilter {
    boolean validate(IProduct product);
}
