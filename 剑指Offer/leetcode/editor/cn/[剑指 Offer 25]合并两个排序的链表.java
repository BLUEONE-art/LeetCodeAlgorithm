//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 82 👎 0


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 只需要借助一个伪头节点
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            // 如果 l1.val < l2.val，让 l1 排在前面
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                // 如果 l1.val >= l2.val，让 l2 排在前面
                cur.next = l2;
                l2 = l2.next;
            }
            // cur +1
            cur = cur.next;
        }
        // 如果 l1 或者 l2 先跑完了
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
