package WareHouse;

public interface IProductFactory {
    IProduct createProduct(final int size, final int weight, final boolean isChemical);
}
