import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String str = "1,2,3,4,6";
        String[] arr = str.split(",");
        List<String> list = Arrays.asList(arr);
        //list.remove("1");//error,asList()返回的是Arrays$ArrayList对象
        ArrayList<String> strings = new ArrayList<>(list);
        strings.remove("1");





    }
}
