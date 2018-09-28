package genric;

/**
 * @author jianweilin
 * @date 2018/3/12
 */
public class Plate<T extends Fruit> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
