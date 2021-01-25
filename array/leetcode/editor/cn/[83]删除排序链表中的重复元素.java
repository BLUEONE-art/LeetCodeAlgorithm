//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 457 👎 0


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
    /* 原地删除(不增加新的存储空间)链表中的重复项 */
    // 核心思想：快指针先去前面探路，没有重复项，让 slow++，并且 nums[slow] == nums[fast]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // 定义快慢指针
        ListNode slow, fast;
        slow = fast = head;
        // fast 指针去前面探雷
        while (fast != null) {
            // 刚开始快慢指针对应的值肯定是相同的，随着 fast 的前行，当快慢指针对应的值不等时
            if (fast.val != slow.val) {
                // 更新 slow 的指针信息
                slow.next = fast;
                // slow++，维持 slow 与 fast 又在同一起跑线上
//                slow = slow.next; // slow = slow.next = fast;
                slow = fast;
            }
            // 快指针递增
            fast = fast.next;
        }
        // 遍历完成后
        slow.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
