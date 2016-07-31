package propotype;

/**
 * Created by God on 2016/5/30.
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype("person one");
        prototype.setAge(10);
        System.out.println(prototype.getNameList() + " " + prototype.getAge());

        ConcretePrototype clone = (ConcretePrototype) prototype.clone();

        clone.setName("person two");
        clone.setAge(20);

        System.out.println(clone.getNameList() + " " + clone.getAge());
        System.out.println(prototype.getNameList() + " " + prototype.getAge());


    }
}
