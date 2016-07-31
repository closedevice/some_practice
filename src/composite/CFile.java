package composite;

/**
 * Created by God on 2016/5/13.
 */
public class CFile extends Component {
    public CFile(String name) {
        super(name);
    }

    @Override
    public void addFile(Component component) {
        throw new UnsupportedOperationException("cfile unsupported");
    }

    @Override
    public void delFile(Component component) {
        throw new UnsupportedOperationException("cfile unsupported");
    }

    @Override
    public boolean isDir() {
        return false;
    }

    @Override
    public void printAll() {
        throw new UnsupportedOperationException("cfile unsupported");
    }
}
