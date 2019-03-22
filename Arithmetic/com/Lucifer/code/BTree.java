/**
 * @author : wangdi
 * @time : creat in 2019/3/21 14:43
 */
public class BTree {

    public void insert(int value,TreeNode root){
        TreeNode newNode = new TreeNode();
        newNode.data = value;
        if (root == null){
            root = newNode;
        }else {
            TreeNode current = root;
            //current节点的父节点
            TreeNode parent;
            //循环查找插入的位置
            while (true){
                parent = current;
                if(value<parent.data){//如果插入值小于当前节点的值，向左子树查找
                    current = parent.leftChild;
                    if(current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }else{//如果插入值大于当前节点的值，向右子树找
                    current = parent.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    //查找二叉树
    public TreeNode find(int value,TreeNode root){
        TreeNode current = root;
        if(root == null){
            return null;
        }else{
            while (true){
                if(current == null){
                    return null;
                }else if(current.data == value){
                    return current;
                }else if(current.data>value){
                    current=current.leftChild;
                }else if(current.data<value){
                    current = current.rightChild;
                }
            }
        }
    }

    //删除节点
    //TODO 还需要再写一遍
    public boolean delet(int value,TreeNode root){
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeft = false;
        boolean isRight = false;
        //查找要删除的节点是做节点还是右节点
        while (current.data!=value){
            parent = current;
            isLeft = false;
            isRight =false;
            if(value<current.data){
                current = parent.leftChild;
                isLeft = true;
            }else {
                current = parent.rightChild;
                isRight = true;
            }
            if(current == null){
                return false;
            }
        }
        if(current.leftChild == null && current.rightChild==null){//是叶子节点，不存在子节点
            if(isLeft){
                parent.leftChild = null;
            }else if(isRight){
                parent.rightChild = null;
            }
            return true;
        } else if(current.leftChild!=null&&current.rightChild == null){//存在左节点
            if(isLeft){
                parent.leftChild = current.leftChild;
            }else if(isRight){
                parent.rightChild = current.leftChild;
            }
            return true;
        }else if (current.leftChild==null&&current.rightChild!=null){//存在右节点
            if(isLeft){
                parent.leftChild = current.rightChild;
            }else if(isRight){
                parent.rightChild = current.rightChild;
            }
            return true;
        }else {//左右子节点都存在
            if (isLeft) {
                parent.leftChild = current.leftChild;
                TreeNode currentLeft = current.rightChild;
                TreeNode parentLeft = currentLeft;
                while (currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.leftChild;
                }
                parentLeft.leftChild = current.leftChild;
            } else if (isRight) {
                parent.rightChild = current.rightChild;
                TreeNode currentRight = current.leftChild;
                TreeNode parentRight = currentRight;
                while (currentRight != null) {
                    parentRight = currentRight;
                    parentRight = currentRight.leftChild;
                }
                parentRight.leftChild = current.leftChild;
            }
            return true;
        }
    }

    //前序
    public void preOrder(TreeNode root) {
        if(root != null) {
            System.out.println(root.data);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    //中序
    public void midOrder(TreeNode root){
        if(root != null){
            midOrder(root.leftChild);
            System.out.println(root.data);
            midOrder(root.rightChild);
        }
    }

    //后序
    public void afterOrder(TreeNode root){
        if(root != null){
            afterOrder(root.leftChild);
            afterOrder(root.rightChild);
            System.out.println(root.data);
        }
    }

    //打印二叉树
    //TODO 还需要再写一遍
    public  void printTree(TreeNode head) {
        System.out.println("-----------------\r\nBinary Tree:");
        printInOrder(head, 0, "Root-", 8);
        System.out.println();
    }

    public  void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.rightChild, height + 1, "R-", len);
        String val = to + head.data;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val;// + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.leftChild, height + 1, "L-", len);
    }

    public  String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

}
