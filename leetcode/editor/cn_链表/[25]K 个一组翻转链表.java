//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 838 👎 0


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
    // K 个一组反转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        // base case: 当链表节点不满 K 个的时候，直接返回 head，不需要反转
        for (int i = 0; i < k; i++) {
            if (b == null) return head; // 先进行判断，在让 b = b.next 用以判断节点不满足 K 时不反转的功能
            b = b.next;
            // example：当节点数为 2，K = 2 时，i 取值 0 ~ 1。
            // 第一次：i = 0, b = head，不满足 if 中条件，执行 b = b.next;
            // 第二次: i = 1, b = head.next, 不满足 if 中条件，执行 b = b.next; 虽然此时 b = head.next.next == null, 但是此时 i 会递增为 2，不会在进行 for 循环了。
            // 以此判断节点数够不够 K 个
        }

        // 更新得到一个新的 head 节点，命名 newHead
        ListNode newHead = reverse(a, b);
        // 连接后续递归反转的链表
        head.next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转以 a 为头结点的链表
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        while (cur != b) {
            // 先将 nxt 移到 cur 的下一个节点
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
