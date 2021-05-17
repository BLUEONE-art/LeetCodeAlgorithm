//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1136 👎 0


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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 分裂链表
        ListNode mid = middleNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // 归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并链表
        return mergeTwoLists(left, right);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (A != null && B != null) {
            if (A.val < B.val) {
                cur.next = A;
                A = A.next;
            }
            else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }
        cur.next = (A == null ? B : A);
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
