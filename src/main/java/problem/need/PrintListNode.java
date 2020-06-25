package problem.need;

import problem.ListNode;

import java.util.Stack;

/**
 * @Description TODO
 * @Author zcf
 * @Date 2020-06-22 23:44
 **/
public class PrintListNode {



    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next(new ListNode(5));
        printFromEnd(node);
    }

    //倒序输出链表
    public static void printFromEnd(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node!=null){
            stack.push(node.getVal());
            node=node.getNext();
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

}
