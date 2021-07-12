package Sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 24, 2, 54, 46, 7, 55, 64, 868};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void heapSort(int[] nums) {
        // 将数组构造成大根堆
        heapify(nums);
        int size = nums.length;
        while (size > 1) {
            // 固定最大值
            swap(nums, 0, size - 1);
            size--;
            siftDown(nums, 0, size);
        }
    }

    public static void heapify(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 当前插入元素的索引
            int curIdx = i;
            // 这个元素的父节点索引，计算公式记住
            int fatherIdx = (curIdx - 1) / 2;
            // 如果当前元素的对应的元素值大于其父节点对应的元素值，则交换；并将当前索引指向其父节点，然后父节点和他的父节点元素值比较，直到不大于最后那个父节点结束循环
            while (nums[curIdx] > nums[fatherIdx]) {
                swap(nums, curIdx, fatherIdx);
                curIdx = fatherIdx;
                fatherIdx = (curIdx - 1) / 2;
            }
        }
    }

    // 将大顶堆除去堆顶元素的其他元素继续改造成大顶堆
    public static void siftDown(int[] nums, int fatherIdx, int size) {
        int leftChildIdx = 2 * fatherIdx + 1;
        int rightChildIdx = 2 * fatherIdx + 2;
        while (leftChildIdx < size) {
            int largestIdx;
            // 找到孩子中较大值对应的索引，并保证右孩子也在size范围内
            if (nums[leftChildIdx] < nums[rightChildIdx] && rightChildIdx < size) {
                largestIdx = rightChildIdx;
            } else {
                largestIdx = leftChildIdx;
            }
            // 比较父节点对应的元素值和孩子中的较大值，获取三者中的最大值索引
            if (nums[fatherIdx] > nums[largestIdx]) {
                largestIdx = fatherIdx;
            }
            // 如果父节点对应的值已经是最大的了，说明此时已经是大顶堆了，可以退出循环
            if (largestIdx == fatherIdx) {
                break;
            }
            // 父节点不是最大值，继续和孩子节点交换；并且将父节点索引指向孩子节点中较大元素的索引，继续跟下面的其他孩子节点比较
            swap(nums, fatherIdx, largestIdx);
            fatherIdx = largestIdx;
            leftChildIdx = 2 * fatherIdx + 1;
            rightChildIdx = 2 * fatherIdx + 2;
        }
    }

    // 交换函数
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
