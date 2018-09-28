package genric;

/**
 * @author jianweilin
 * @date 2018/3/12
 */
public class Test {
    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
        p.getItem();
//        p.setItem(new Apple());

//        Plate<? super Fruit> p2 = new Plate<Fruit>(new Fruit());
        Plate<? super Fruit> p2 = new Plate<Fruit>(new Fruit());
        p2.setItem(new Fruit());
        p2.setItem(new Apple());
//        p2.setItem(new Food());
        Object apple = p2.getItem();
        p2.getItem();
    }
}
