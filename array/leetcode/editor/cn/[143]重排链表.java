//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 575 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // 至少需要三个节点
        if (head == null || head.next == null || head.next.next == null) return;
        // 找中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分裂成两个链表
        ListNode newHead = slow.next;
        slow.next = null;
        // 反转后一个链表
        newHead = reverse(newHead);
        // 合并两个链表
        mergeTwoLists(head, newHead);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public void mergeTwoLists(ListNode A, ListNode B) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        int count = 0;
        while (A != null && B != null) {
            count += 1;
            // 由A->B开始合并
            if (count % 2 != 0) {
                cur.next = A;
                A = A.next;
            }
            else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }
        // A 和 B 可能不一样长
        cur.next = (A == null ? B : A);
//        A = dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
