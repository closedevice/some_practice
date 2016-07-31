package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by God on 2016/5/13.
 */
public abstract class Component {
    private String name;
    public Component(String name) {
        this.name=name;
    }

    public String getName() {
        return this.name;
    }
    List<Component> list = new ArrayList<>();
    public abstract void addFile(Component component);

    public abstract void delFile(Component component);

    public abstract boolean isDir();

    public abstract void printAll();
}
