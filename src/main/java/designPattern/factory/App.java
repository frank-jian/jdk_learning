package designPattern.factory;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class App {
    private Fruit fruit;

    public App(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public static void main(String[] args) {
        App app = new App(new Apple());
        System.out.println(app.fruit.sayName());
        app = new App(new Banana());
        System.out.println(app.fruit.sayName());
    }
}
