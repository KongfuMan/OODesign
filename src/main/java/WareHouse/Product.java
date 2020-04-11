package WareHouse;

public class Product implements IProduct{
    private final int weight;
    private final int size;
    private final boolean isChemical;

    public Product(int weight, int size, boolean isChemical) {
        this.weight = weight;
        this.size = size;
        this.isChemical = isChemical;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isChemical() {
        return isChemical;
    }
}
