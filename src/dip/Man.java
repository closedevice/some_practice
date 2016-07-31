package dip;

/**
 * Created by God on 2016/5/4.
 */
public class Man implements Human {
    @Override
    public void drive(Car car) {
        System.out.println("man drive " + car.getName());
    }
}
