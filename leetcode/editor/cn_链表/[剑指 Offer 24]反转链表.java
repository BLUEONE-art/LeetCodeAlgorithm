//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 159 👎 0


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
        head.next.next = head;
        head.next = null;

        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
