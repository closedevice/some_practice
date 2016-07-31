package propotype;

import java.util.ArrayList;

/**
 * Created by God on 2016/5/30.
 */
public class ConcretePrototype implements Cloneable {
    private String name;
    private ArrayList<String> nameList = new ArrayList<>();
    private int age;

    public ConcretePrototype(String name) {
        this.name = name;
        this.nameList.add(this.name);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.nameList.add(name);
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    @Override
    protected Object clone() {
        ConcretePrototype self=null;
        try {
            self = (ConcretePrototype) super.clone();//此处只是浅拷贝
            self.nameList = (ArrayList<String>) this.nameList.clone();//这句是实现深拷贝的基础
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return self;
    }
}
