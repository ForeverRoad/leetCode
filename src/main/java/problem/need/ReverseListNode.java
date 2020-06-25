package problem.need;

import problem.ListNode;

/**
 * @Description TODO
 * @Author zcf
 * @Date 2020-06-23 17:48
 **/
public class ReverseListNode {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next(new ListNode(2));
        ListNode reverse = reverse(node);
        System.out.println(reverse.toString());
    }

    //把cur的next给pre，把pre给next
    public static ListNode reverse(ListNode node){

        ListNode pre = null,cur=node,next;

        while (cur.getNext()!=null){
            next = cur.getNext();
            cur.next(pre);
            pre = cur;
            cur=next;
        }
        return pre;
    }
}
