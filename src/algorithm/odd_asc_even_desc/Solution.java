package algorithm.odd_asc_even_desc;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(8);
        ListNode test3 = new ListNode(3);
        ListNode test4 = new ListNode(6);
        ListNode test5 = new ListNode(5);
        ListNode test6 = new ListNode(4);
        ListNode test7 = new ListNode(7);
        ListNode test8 = new ListNode(2);
        ListNode test9 = new ListNode(9);
        test1.next = test2;
        test2.next = test3;
        test3.next = test4;
        test4.next = test5;
        test5.next = test6;
        test6.next = test7;
        test7.next = test8;
        test8.next = test9;
        ListNode res = s.oddEvenSortList(test1);
        System.out.println(s.printNode(res));
    }

    public ListNode oddEvenSortList(ListNode head) {
        // 1.将奇偶乱序链表分解成两个子链表：奇数位按序增长，偶数位按序减小
        List<ListNode> lists = oddEvenList(head);
        ListNode dumOdd = lists.get(0);
        ListNode dumEven = lists.get(1);
        // 偶数位链表反转
        dumEven = reverse(dumEven);
        // 合并两个链表
        return mergeLists(dumOdd, dumEven);
    }

    public List<ListNode> oddEvenList(ListNode head) {
        ListNode dumOdd = new ListNode(0);
        ListNode curOdd = dumOdd;
        ListNode dumEven = new ListNode(0);
        ListNode curEven = dumEven;
        boolean isOdd = true;
        List<ListNode> res = new ArrayList<>();
        while (head != null) {
            if (isOdd) {
                curOdd.next = head;
                curOdd = curOdd.next;
            }
            else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        curOdd.next = null;
        curEven.next = null;
        res.add(dumOdd.next);
        res.add(dumEven.next);
        return res;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode mergeLists(ListNode A, ListNode B) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        boolean isOdd = true;
        while (A != null && B != null) {
            if (isOdd) {
                cur.next = A;
                A = A.next;
            }
            else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
            isOdd = !isOdd;
        }
        return dum.next;
    }

    public String printNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}
