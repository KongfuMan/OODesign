package WareHouse.Filters;

import WareHouse.Exceptions.ExceedsMaxSizeException;
import WareHouse.Exceptions.ExceedsMaxWeightException;
import WareHouse.IProduct;

public class WeightFilter implements IFilter {
    private final static String EXCEEDS_MAX_WEIGHT_MSG = "Product weight (%s) exceeds max weight (%s)";

    private final int MAXWEIGHT;
    private IFilter filter;

    public WeightFilter(final int maxSize){
        this.MAXWEIGHT = maxSize;
    }

    public WeightFilter(int maxSize, IFilter filter) {
        this.MAXWEIGHT = maxSize;
        this.filter = filter;
    }

    @Override
    public void validate(IProduct product) throws ExceedsMaxSizeException, ExceedsMaxWeightException {
        int prodWeight = product.getWeight();
        if (product.getWeight() > MAXWEIGHT){
            throw new ExceedsMaxWeightException(String.format(EXCEEDS_MAX_WEIGHT_MSG, prodWeight, MAXWEIGHT));
        }
        if (this.filter != null){
            this.filter.validate(product);
        }
    }
}
