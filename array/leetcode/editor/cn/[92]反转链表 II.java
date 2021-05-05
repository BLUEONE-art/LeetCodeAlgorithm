//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 890 👎 0


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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode slow = dum, fast = dum.next;
        for (int i = 0; i < left - 1; i++) {
            slow = slow.next; // 以1，2，3，4，5为例，定位到1节点
            fast = fast.next; // 定位到2
        }
        for (int i = 0; i < right - left; i++) {
            // 依次删除
            ListNode removed = fast.next; // 3
            fast.next = fast.next.next; // 2 --> 4
            // 移位
            removed.next = slow.next; // 3 --> 2
            slow.next = removed; // 1 --> 3
        }
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
