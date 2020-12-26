package algorithm.lru;

public class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;

    public DoubleList() {
        // 初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // 在链表尾部添加节点x，时间复杂度为O(1)
    public void addLast(Node x) {
        x.prev = tail.prev; // 表示x的前一个指针（引用）里存的地址是尾部节点的前一个节点
        x.next = tail;
        tail.prev.next = x; // tail.pre表示末尾节点的前一个节点，tail.prev.next的指针（引用）存放（指向）的地址是x
        tail.prev = x;
        size++;
    }

    // 删除链表中的x节点（x一定存在）
    // 由于是双向链表且给的是目标 Node 节点，时间复杂度为O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中的第一个节点，并返回该节点，时间复杂度为O(1)
    public Node removeFirst() {
        if(head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度，时间复杂度为O(1)
    public int size() { return size; }
}
