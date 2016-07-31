package dip;

/**
 * Created by God on 2016/5/4.
 */
public class Client {

    public static void main(String[] args) {
        Human human = new Man();
        Car car = new Audi();
        human.drive(car);
    }
}
