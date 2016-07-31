package composite;

import java.util.List;

/**
 * Created by God on 2016/5/13.
 */
public class Composite extends Component {
    public Composite(String name) {
        super(name);
    }

    @Override
    public void addFile(Component component) {
        if (component!=null) {
            list.add(component);
        }
    }

    @Override
    public void delFile(Component component) {
        if (component!=null) {
            list.add(component);
        }
    }

    @Override
    public boolean isDir() {
        return true;
    }

    @Override
    public void printAll() {
        System.out.println("------"+getName()+"------");
        for (Component component : list) {
            if (component.isDir()) {
                System.out.println("dir:" + component.getName());
                component.printAll();
            }else{

                System.out.println("file:"+component.getName());
            }
        }
    }
}
