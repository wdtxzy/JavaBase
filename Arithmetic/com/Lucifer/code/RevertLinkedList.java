/**
 * @author : wangdi
 * @time : creat in 2019/3/21 10:09
 * 如何反转链表？递归和非递归两种方式
 */
public class RevertLinkedList {

    public static void main(String[] args) {

    }

    public ListNode revert(ListNode head) {
        ListNode pReversedHead = null; //反转过后的单链表存储头结点
        ListNode pNode = head; //定义pNode指向pHead;
        ListNode pPrev = null; //定义存储前一个结点
        while (pNode != null) {
            ListNode pNext = pNode.getNext(); //定义pNext指向pNode的下一个结点
            if (pNext == null) { //如果pNode的下一个结点为空，则pNode即为结果
                pReversedHead = pNode;
            }
            pNode.setNext(pPrev);  //修改pNode的指针域指向pPrev
            pPrev = pNode; //将pNode结点复制给pPrev
            pNode = pNext; //将pNode的下一个结点复制给pNode
        }
        return pReversedHead;

    }

    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    public ListNode revertByRecurrence(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode next = head.getNext();
        head.setNext(null);
        ListNode revertHead = revertByRecurrence(next);
        next.setNext(head);
        return revertHead;
    }
}
