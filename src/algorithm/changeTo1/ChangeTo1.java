package algorithm.changeTo1;

public class ChangeTo1 {

    public static void main(String[] args) {
        int k = 61;
        int[] a = new int[k + 1];
        a[1] = 1;
        char[] c = new char[k + 1];
        changeTo1(a, k, c);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "," + c[i] + "," + a[i]);
        }
    }

    private static void changeTo1(int[] a, int k, char[] c) {
        for (int i = 2; i < a.length; i++) {
            if (i % 2 == 0) {//偶数
                a[i] = a[i / 2] + 1;
                c[i] = '#';
            } else {
                if ((a[(i + 1) / 2] + 2) > (a[(i - 1)/2] + 2)) {
                    a[i] = (a[(i - 1)/2] + 2);
                    c[i] = '-';
                } else {
                    a[i] = (a[(i + 1) / 2] + 2);
                    c[i] = '+';
                }
            }
        }
    }
}
