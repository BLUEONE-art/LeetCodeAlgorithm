//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 817 👎 0


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

    // 进阶：根据快慢指针判断回文链表
    public boolean isPalindrome(ListNode head) {

        // ①定义快慢指针，找出链表的中点
        ListNode slow, faster;
        slow = faster = head;
        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }

        // 因为慢指针每次步进 1，快指针每次步进 2
        // 回文链表不比较中心元素，只要求中心元素的两端的元素相等
        // 当链表节点数为奇数：slow 指针指向的是链表的中心节点，需要后移一位，再进行反转链表
        // 当链表节点数为偶数：没有中心元素，链表可以分为两半，每一半的元素都要跟另一半进行比较
        // ②如果是奇数，需要将 slow 指针后移一位(判断条件：当 faster 指针不指向 null 时)
        if (faster != null) {
            slow = slow.next;
        }

//        // 定义 p 指针记录原始 slow 位置
//        ListNode p = slow;

        // ③反转 slow 之后的链表(包括 slow)
        ListNode left = head;
        ListNode right = reverse(slow); // 返回的是新的头节点

//        // 定义 q 指针记录反转链表头节点的位置
//        ListNode q = right;

        // ④比较反转之后的链表和前一半链表的值
        while (right != null) {

            if (left.val != right.val) return false;

            left = left.next;
            right = right.next;
        }

//        // 恢复输入链表的原始结构
//        slow.next = reverse(q);

        return true;
    }

    // 反转指定节点之后的链表函数 reverse()
    public ListNode reverse(ListNode head) {

        ListNode pre, cur, nxt;
        pre = null;
        cur = nxt = head;

        while (cur != null) {

            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }

        return pre;
    }


//    public boolean isPalindrome(ListNode head) {
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//
//        preTraverse(head, sb1);
//        postTraverse(head, sb2);
//
//        // 判断
//        for (int i = 0; i < sb1.length(); i++) {
//            if (sb1.charAt(i) != sb2.charAt(i)) return false;
//        }
//        return true;
//    }
//
//    // 前序遍历链表
//    public static void preTraverse(ListNode head, StringBuilder sb) {
//        if (head == null) return;
//
//        // 前序遍历代码
//        sb.append(head.val);
//
//        preTraverse(head.next, sb);
//    }
//
//    // 后序遍历链表
//    public static void postTraverse(ListNode head, StringBuilder sb) {
//        if (head == null) return;
//
//        postTraverse(head.next, sb);
//
//        // 后序遍历代码
//        sb.append(head.val);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
