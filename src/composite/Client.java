package composite;

/**
 * Created by God on 2016/5/13.
 */
public class Client {
    public static void main(String[] args) {
        Component component1 = new Composite("文件夹1");
        Component component2 = new CFile("文件1");
        Component component3 = new CFile("文件1");
        component1.addFile(component2);
        component1.addFile(component3);

        Composite component4 = new Composite("文件夹2");
        component4.addFile(new CFile("文件3"));
        component4.addFile(new Composite("文件夹8"));
        component1.addFile(component4);

        component1.printAll();
    }
}
