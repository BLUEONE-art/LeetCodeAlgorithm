//       在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
//       [1,3,4,2,5]
//
//        1左边比1小的数，没有；
//
//        3左边比3小的数，1；
//
//        4左边比4小的数，1、3；
//
//        2左边比2小的数，1；
//
//        5左边比5小的数，1、3、4、2；
//
//        所以小和为1+1+3+1+1+3+4+2=16
//
//        要求时间复杂度O(NlogN)，空间复杂度O(N)


public class Main {
    // 暴力方法 O(N^2)
    public static long smallSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    public static long samllSum_merge(int[] arr, int low, int high) {
        if (low == high) return 0;
        // 计算mid的位置
        int mid = low + ((high - low) >> 1); // 这样可以避免溢出，而且使用了位运算，效率更高
        return samllSum_merge(arr, low, mid) + samllSum_merge(arr, mid + 1, high) + merge(arr, low, mid, high);
    }

    // 归并两个有序的数组
    public static long merge(int[] arr, int low, int mid, int high) {
        int[] help = new int[high - low + 1];
        long result = 0;
        int p = low;
        int q = mid + 1;
        int k = 0;
        while (p <= mid && q <= high) {
            if (arr[p] <= arr[q]) { //  左边比又变小，产生小和
                result += arr[p] * (high - q + 1);
                help[k++] = arr[p++];
            } else if (arr[p] > arr[q]) {
                help[k++] = arr[q++];
            }
        }
        while (p <= mid) {
            help[k] = arr[p++];
            k++;
        }
        while (q <= high) {
            help[k] = arr[q++];
            k++;
        }
        // copy
        for (int i = 0; i < high - low + 1; i++) {
            arr[low + i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long sum = samllSum_merge(arr, 0, arr.length - 1);

        System.out.println(sum);
    }

}

