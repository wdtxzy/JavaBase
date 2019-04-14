import java.util.Stack;

/**
 * @author : wangdi
 * @time : creat in 2019/4/14 22:46
 */
public class TestTwoTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);
        node4.setLeftChild(node8);
        node4.setRightChild(node9);
        test1(node1);
        test1(node1);
    }

    //递归
    public static void test1(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.getData());
        test1(root.getLeftChild());
        test1(root.getRightChild());
    }


    //非递归的方式
    public static void test2(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                System.out.print(root.getData());
                stack.push(root);
                root = root.getLeftChild();
            }
            TreeNode tmp = stack.pop();
            root = tmp.getRightChild();
        }
    }

}




class TreeNode{
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}