/**
 * Created by God on 2016/3/4.
 */
public class Test {

    public int add(int a, int b) {
        try {
            return a+b;
        } catch (Exception e) {
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Test().add(9, 34));
    }
}
