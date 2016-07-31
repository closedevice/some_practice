import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;
import java.util.Stack;

/**
 * Created by God on 2016/3/4.
 */
public class TreeTest {

    public static void main(String[] args) {

        TreeTest treeTest = new TreeTest();

        TreeNode root = new TreeNode(1, "A");
        treeTest.createTree(root);

        System.out.println(treeTest.height(root));
        System.out.println(treeTest.size(root));

        System.out.println("前序遍历：");
        treeTest.preOrder(root);
        System.out.println();
        System.out.println("中序遍历");
        treeTest.midOrder(root);
        System.out.println();
        System.out.println("后序遍历");
        treeTest.afterOrder(root);


    }


    /**
     * 创建树
     * @param root
     */
    public void createTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(3, "C");
        TreeNode newNodeD = new TreeNode(4, "D");
        TreeNode newNodeE = new TreeNode(5, "E");
        TreeNode newNodeF = new TreeNode(6, "F");

        root.right=newNodeB;
        root.left=newNodeC;
        root.right.right=newNodeD;
        root.right.left=newNodeE;
        root.left.left=newNodeF;


    }

    /**
     * 树的高度
     * @param root
     * @return
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }else{
            int i = height(root.left);
            int j = height(root.right);
            return (i<j)?j+1:i+1;
        }

    }



    /**
     * 树的节点个数
     * @param root
     * @return
     */
    public int size(TreeNode root) {

        if (root == null) {
            return 0;
        }else{
            return 1+size(root.left)+size(root.right);
        }

    }

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return ;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }


    /**
     * 前序遍历（非递归）
     * @param root
     */
    public void nonRecPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node=root;
        while (node != null) {
            while (node != null) {
                System.out.print(node.data+" ");
                stack.push(root);
                node=node.left;
            }
            while (stack.size() > 0) {
                node=stack.pop();
                node=node.right;
            }
        }
    }



    /**
     * 中序遍历
     * @param root
     */
    public void midOrder(TreeNode root) {
        if (root == null) {
            return ;
        }

        midOrder(root.left);
        System.out.print(root.data+" ");
        midOrder(root.right);
    }


    public void nonRecMidOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node=root;
        while (node != null) {
            while (node != null) {
                stack.push(node);

                node=node.left;

            }
            while (stack.size() > 0) {
                node=stack.pop();
                System.out.print(node.data+" ");
                node=node.right;
            }
        }


    }

    /**
     * 后续遍历
     * @param root
     */
    public void afterOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.data+" ");
    }

    /**
     * 树节点
     */
    private static class TreeNode{
        private int key;
        private String data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            left=null;
            right=null;
        }
    }

}
