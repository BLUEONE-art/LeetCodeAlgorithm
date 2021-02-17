//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1433 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /* 反转整个链表，并输出反转后链表的头节点 */
    public ListNode reverseList(ListNode head) {
        // base case：当只有一个 head 时，返回 head
        if (head == null || head.next == null) {
            return head;
        }

        // 递归除了头结点 head 后面的节点
        ListNode last = reverseList(head.next);

        // 更新节点信息
        head.next.next = head;
        head.next = null;

        return last;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
