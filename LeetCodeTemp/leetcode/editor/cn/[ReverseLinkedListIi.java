//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 630 👎 0

package com.yourname.leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  DH
 * @date 2021-01-10 15:56:52
 */
public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
   }
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // 相当于反转前 N 个元素
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}