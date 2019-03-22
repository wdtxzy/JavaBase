import java.util.LinkedList;

/**
 * @author : wangdi
 * @time : creat in 2019/3/21 00:08
 * 如何在一次传递中找到单链表的中间元素？
 */
public class FindMidleInLinkedList {
    public static void main(String[] args) {

    }

    public ListNode findmid(ListNode head){
        ListNode i = head;
        ListNode j = head;
        while (j.getNext().getNext()!=null){
            i = i.getNext();
            j=j.getNext().getNext();
        }
        return i;
    }
}
