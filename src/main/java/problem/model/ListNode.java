package problem.model;

/**
 * @Description 链表
 * @Author zcf
 * @Date 2020-06-23 17:48
 **/
public class ListNode {
    private int val;
    private ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void next(ListNode next) {
        this.next = next;
    }

    @Override
        public  String toString(){
            StringBuilder sb = new StringBuilder();
            while (next!=null){
                sb.append(val).append(",");
                next = next.next;
            }
            return sb.toString();
        }
}
