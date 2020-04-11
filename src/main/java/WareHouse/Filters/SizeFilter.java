package WareHouse.Filters;

import WareHouse.IProduct;

public class SizeFilter implements IFilter {
    private final int MAXSIZE;
    private IFilter filter;

    public SizeFilter(final int maxSize){
        this.MAXSIZE = maxSize;
    }

    public SizeFilter(final int maxSize, final IFilter filter) {
        this.MAXSIZE = maxSize;
        this.filter = filter;
    }

    @Override
    public boolean validate(IProduct product) {
        if (product.getSize() >= MAXSIZE){
            return false;
        }
        if (this.filter != null){
            return this.filter.validate(product);
        }
        return true;
    }
}
