package WareHouse.Filters;

import WareHouse.Exceptions.ExceedsMaxSizeException;
import WareHouse.Exceptions.ExceedsMaxWeightException;
import WareHouse.IProduct;

public interface IFilter {
    void validate(IProduct product) throws ExceedsMaxSizeException, ExceedsMaxWeightException;
}
