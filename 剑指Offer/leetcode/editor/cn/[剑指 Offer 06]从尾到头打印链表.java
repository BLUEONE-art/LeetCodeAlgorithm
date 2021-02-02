//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 91 👎 0


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
    // 思路：反转整个链表，打印
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode curNode = head;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        int[] res = new int[length];
        // 调用反转链表的函数
        ListNode newHead = reverse(head);
        // 打印
        int i = 0;
        while (newHead != null) {
            res[i] = newHead.val;
            i++;
            newHead = newHead.next;
        }
        return res;
    }
    // 反转链表
    private ListNode reverse(ListNode head) {
        // base case：当只有一个 head 时，返回 head
        if (head == null || head.next == null) {
            return head;
        }

        // 递归除了头结点 head 后面的节点
        ListNode last = reverse(head.next);

        // 更新节点信息
        head.next.next = head;
        head.next = null;

        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
