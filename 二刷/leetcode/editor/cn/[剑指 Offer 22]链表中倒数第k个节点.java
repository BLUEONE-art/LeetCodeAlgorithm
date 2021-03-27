//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 164 👎 0


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
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

//    public ListNode getKthFromEnd(ListNode head, int k) {
//        if (head == null) return null;
//        // 假如长度为 5，倒数第二个相当于正数第第四个，即第 （链表长度 - k + 1） 个节点
//        int length = countNum(head);
//        int count = length - k;
//        while (count > 0) {
//            head = head.next;
//            count--;
//        }
//        return head;
//    }
//    public int countNum(ListNode head) {
//        int count = 0;
//        while (head != null) {
//            count += 1;
//            head = head.next;
//        }
//        return count;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
