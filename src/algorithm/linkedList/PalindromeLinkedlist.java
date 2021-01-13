package algorithm.linkedList;

import org.junit.Test;

public class PalindromeLinkedlist {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        // 反转输入的链表
        ListNode reverseHead = reverse(head);


        ListNode temp = reverseHead;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        traverse(head, sb1);
        traverse(reverseHead, sb2);

        int size = sb1.length();

        // 判断
        for (int i = 0; i < size; i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }

    // 反转链表
    public static ListNode reverse(ListNode haed) {
        // base case：当只有一个节点时，直接返回
        if (haed == null || haed.next == null) return haed;

        // 递归反转
        ListNode last = reverse(haed.next);
        haed.next.next = haed;
        haed.next = null;

        return last;
    }

    // 遍历链表
    public static void traverse(ListNode head, StringBuilder sb) {
        if (head == null) return;
        // 前序遍历代码
        sb.append(head.val);

        traverse(head.next, sb);
    }

    public static void main(String[] args) {
        PalindromeLinkedlist palindromeLinkedlist = new PalindromeLinkedlist();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        traverse(listNode, sb1);
        System.out.println(sb1.length());
        System.out.println(sb1);

        ListNode reverseHead = reverse(listNode);
        traverse(reverseHead, sb2);
        System.out.println(sb2.length());
        System.out.println(sb2);

        Boolean res = palindromeLinkedlist.isPalindrome(listNode);
        System.out.println(res);
    }
}
