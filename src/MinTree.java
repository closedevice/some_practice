/**
 * Created by God on 2016/2/26.
 * 最小堆
 */
public class MinTree {
    private int[] tree = new int[101];//存放堆的数组
    private int n;//堆的大小


    public void initTree() {
        n=14;
        tree[1]=99;
        tree[2]=5;
        tree[3]=36;
        tree[4]=7;
        tree[5]=22;
        tree[6]=17;
        tree[7]=46;
        tree[8]=12;
        tree[9]=2;
        tree[10]=19;
        tree[11]=25;
        tree[12]=28;
        tree[13]=1;
        tree[14]=92;

        for (int i=1;i<=n;i++) {
            System.out.print(tree[i]+",");
        }
        System.out.println();
    }

    public void swap(int x, int y) {
        int t;
        t = tree[x];
        tree[x] = tree[y];
        tree[y]=t;
    }


    /*
    *往上调整
     */
    public void siftup(int i) {
        boolean flag=true;//是否继续往上调整
        if (i == 1) {//堆顶则不需要调整了
            return;
        }
        while (i != 1&&flag) {
            //当前结点比父结点小,则需要调整
            if (tree[i] < tree[i / 2]) {
                swap(i, i / 2);
            } else {
                flag=false;
            }
            i=i/2;//如果需要调整的化,则更新编号i为其父节点的编号,从而便于下一次继续往上调整
        }

    }

    public void siftdown(int i) {
        int minPos;
        boolean flag=true;
        while (2*i <= n && flag) {//当i结点有子节点（至少有左孩子）
            //和左孩子比较
            if (tree[i] > tree[2 * i]) {
                minPos=2*i;
            }else{
                minPos=i;
            }

            //如果存在左孩子，则再和右孩子比较，确定更小结点
            if (2 * i + 1 <= n) {
                if (tree[minPos] > tree[2 * i + 1]) {
                    minPos = 2 * i + 1;
                }
            }

            //如果发现最小结点不是自己本身，则需要更新交换
            if (i != minPos) {
                swap(minPos, i);
                i = minPos;//以便继续往下调整
            } else {
                flag=false;
            }

        }
    }


    public void create() {
        //创建最小堆
        for (int i=n/2;i>=1;i--) {
            siftdown(i);
        }
        System.out.print("最小堆: ");
        for(int i=1;i<=n;i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
    }

    public int deleteMin() {
        int t;
        t = tree[1];
        tree[1] = tree[n];
        n--;
        siftdown(1);
        return t;
    }

    //由小到大
    public void sort() {
        System.out.print("由小到大: ");
        for (int i=1;i<=14;i++) {
            System.out.print(deleteMin()+" ");

        }
    }

    public static void main(String[] args) {
        MinTree tree = new MinTree();
        tree.initTree();
        tree.create();
        tree.sort();
    }
}
