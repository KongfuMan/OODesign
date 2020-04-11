package WareHouse.Filters;

import WareHouse.IProduct;

public class WeightFilter implements IFilter {
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
    public boolean validate(IProduct product) {
        if (product.getWeight() > MAXWEIGHT){
            return false;
        }
        if (this.filter != null){
            return this.filter.validate(product);
        }
        return true;
    }
}
