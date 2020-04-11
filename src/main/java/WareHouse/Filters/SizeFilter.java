package WareHouse.Filters;

import WareHouse.Exceptions.ExceedsMaxSizeException;
import WareHouse.Exceptions.ExceedsMaxWeightException;
import WareHouse.IProduct;

public class SizeFilter implements IFilter {
    private final static String EXCEEDS_MAX_SIZE_MSG = "Product size (%s) exceeds max size(%s)";

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
    public void validate(IProduct product) throws ExceedsMaxSizeException, ExceedsMaxWeightException {
        int prodSize = product.getSize();
        if (prodSize >= MAXSIZE){
            throw new ExceedsMaxSizeException(String.format(EXCEEDS_MAX_SIZE_MSG, prodSize, MAXSIZE));
        }
        if (this.filter != null){
            this.filter.validate(product);
        }
    }
}
