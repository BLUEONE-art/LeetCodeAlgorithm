package algorithm.bin36;

import java.util.Scanner;

public class JinzhizhuanhuanCopy {
    // 36进制字符在十进制中的表示
    public static int findIndex(char c) {
        int res = -1;
        if (c > '0' && c < '9') {
            res = c - '0';
        } else if (c >= 'a' && c <= 'z') {
            res = c - 'a' + 10;
        }
        return res;
    }

    // 36进制加法
    public static String bin_36(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        String symbol = "0123456789abcdefghijklmnopqrstuvwxyz";
        int str1_len = str1.length();
        int str2_len = str2.length();
        int i = str1_len - 1;
        int j = str2_len - 1;
        if (i < 0 || j < 0) return null;
        int temp = 0; // 进位标志位
        while (i >= 0 && j >= 0) {
            char ch_1 = str1.charAt(i);
            char ch_2 = str2.charAt(j);
            int value1 = findIndex(ch_1);
            int value2 = findIndex(ch_2);
            int res = value1 + value2;
            if (res >= 36) { // 进位
                int index = res - 36 + temp;
                char charValue = symbol.charAt(index);
                sb.append(charValue);
                temp = 1;
            } else {
                int index = res + temp;
                char charValue = symbol.charAt(index);
                sb.append(charValue);
                temp = 0;
            }
            i--;
            j--;
        }
        // 当str1长度大于str2长度
        while (i >= 0) {
            char charValue = symbol.charAt(i);
            sb.append(charValue);
            i--;
        }
        while (j >= 0) {
            char charValue = symbol.charAt(j);
            sb.append(charValue);
            j--;
        }
        StringBuilder res = sb.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String res = bin_36(str1, str2);
        System.out.println(res);
    }
}

