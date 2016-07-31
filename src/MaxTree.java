/**
 * Created by God on 2016/2/26.
 * 最大堆
 */
public class MaxTree {
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




    public void siftdown(int i) {
        int maxPos;
        boolean flag=true;
        while (2*i <= n && flag) {//当i结点有子节点（至少有左孩子）
            //和左孩子比较
            if (tree[i] < tree[2 * i]) {
                maxPos=2*i;
            }else{
                maxPos=i;
            }

            //如果存在左孩子，则再和右孩子比较，确定更小结点
            if (2 * i + 1 <= n) {
                if (tree[maxPos] < tree[2 * i + 1]) {
                    maxPos = 2 * i + 1;
                }
            }

            //如果发现最大结点不是自己本身，则需要更新交换
            if (i != maxPos) {
                swap(maxPos, i);
                i = maxPos;//以便继续往下调整
            } else {
                flag=false;
            }

        }
    }


    public void create() {
        //创建最大堆
        for (int i=n/2;i>=1;i--) {
            siftdown(i);
        }
        for(int i=1;i<=n;i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
    }


    //由大到小
    public void sort() {
        while (n >=1) {
            swap(1,n);
            System.out.print(tree[n]+" ");
            n--;
            siftdown(1);
        }
    }


    public static void main(String[] args) {
        MaxTree tree = new MaxTree();
        tree.initTree();
        tree.create();
        tree.sort();
    }
}
