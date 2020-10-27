package problem.tree;

import problem.model.TreeNode;

import java.util.*;

public class QueryTree {

    public static void main(String[] args) {

        /**
         *          1
         *        /   \
         *      2       6
         *    /  \         \
         *  4     5         8
         */
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.setLeft(root2);
        root1.setRight(root5);
        TreeNode root3 = new TreeNode(6);
//        TreeNode root4 = new TreeNode(8);
//        root3.setRight(root4);

        root.setLeft(root1);
//        root.setRight(root3);
//        preOrder(root);
//        preOrderNormal(root);
//        midOrder(root);
//        midOrderNormal(root);
//        postOrder(root);
//        postOrderNormal(root);

//        dfs(root);
//        System.out.println("~~~~~~~~~~~~~~~~~~~");
//        dfsNormal(root);
//        bfs(root);
//        System.out.println(maxDepth(root));
        System.out.println(isBalanced(root));
    }



    //前序遍历，递归
    public static void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.getVal());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //前序，非递归
    public static void preOrderNormal(TreeNode root){
        if (root==null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
//                System.out.println(root.getVal());
                result.add(root.getVal());
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.empty()){
                root = stack.pop().getRight();
            }
        }
    }


    //中序遍历，递归
    public static void midOrder(TreeNode root){
        if (root==null){
            return;
        }
        midOrder(root.getLeft());
        System.out.println(root.getVal());
        midOrder(root.getRight());

    }

    public static void midOrderNormal(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.empty()){
                root = stack.pop();
                System.out.println(root.getVal());
                root = root.getRight();
            }
        }
    }

    //后序遍历，递归
    public static void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getVal());

    }

    public static void postOrderNormal(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisit = null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.getLeft();
            }
            //查看是否为右节点,右节点要先于根节点出
            TreeNode node = stack.peek();
            if (node.getRight()==null||lastVisit==node.getRight()){
                System.out.println(node.getVal());
                stack.pop();
                lastVisit = node;
            }else {
                root = node.getRight();
            }
        }
    }

    //后序遍历，采用逆向的方法
    public static void postOrderReverser(TreeNode root){
        if (root==null){
            return;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode it = stack.pop();
            //首先出栈的为根节点，其后先出右子节点，后出左子节点
            if (it.getLeft()!=null){
                stack.push(it.getLeft());
            }
            if (it.getRight()!=null){
                stack.push(it.getRight());
            }
            result.add(0,it.getVal());
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


    //深度搜索，先根再左再右的遍历
    public static void dfs(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.getVal());
        dfs(root.getLeft());
        dfs(root.getRight());
    }
    //深度搜索，非递归,通过栈的先进后出，把右子树先压入
    public static void dfsNormal(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.getVal());
            if (root.getRight()!=null){
                stack.push(root.getRight());
            }
            if (root.getLeft()!=null){
                stack.push(root.getLeft());
            }
        }

        dfs(root.getLeft());
        dfs(root.getRight());
    }
    // BFS 分层搜索，逐层遍历
    public static void bfs(TreeNode node){
        if (node==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){

            int len = queue.size();

            for (int i=0;i<len;i++){
                TreeNode root = queue.poll();
                System.out.println(root.getVal());

                if (root.getLeft()!=null){
                    queue.add(root.getLeft());
                }
                if (root.getRight()!=null){
                    queue.add(root.getRight());
                }
            }

        }
    }
    //分治或者使用BFS分层或者使用DFS搜索
    public static int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        if (left>right){
            return left+1;
        }else {
            return right+1;
        }
    }

    //判断二叉树是不是平衡二叉树，
    // 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
    public static boolean isBalanced(TreeNode root){
        if (balanceDepth(root)==-1){
            return false;
        }
        return true;
    }

    public static int balanceDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        if (left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        if (left>right){
            return left+1;
        }else {
            return right+1;
        }

    }

}
