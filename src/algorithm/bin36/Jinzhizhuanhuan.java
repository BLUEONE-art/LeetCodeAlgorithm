package algorithm.bin36;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jinzhizhuanhuan {
    /**
     * 36进制由0-9，a-z，共36个字符表示，最小为'0'
     * '0''9'对应十进制的09，'a''z'对应十进制的1035
     * 例如：'1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47
     * 要求按照加法规则计算出任意两个36进制正整数的和
     * 如：按照加法规则，计算'1b' + '2x' = '48'
     *
     * 要求：不允许把36进制数字整体转为10进制数字，计算出10进制数字的相加结果再转回为36进制
     *
     * @param args
     */
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String result = addFunWithStr(str1, str2);
        System.out.println("result = " + result);
    }

    /**
     * 获取值
     * @param ch
     * @return
     */
    public static int getIntFromChar(char ch) {
        int ret = -1;
        if (ch >='0' && ch <= '9') {
            ret = ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {
            ret = (ch - 'a') + 10;
        }
        return ret;
    }

    public static String addFunWithStr(String param1, String param2) {

        StringBuffer stringBuffer = new StringBuffer();
        String symbol = "0123456789abcdefghijklmnopqrstuvwxyz";
        int param1Len = param1.length();
        int param2Len = param2.length();
        int i = param1Len - 1;
        int j = param2Len - 1;
        if (i < 0 || j < 0) {
            return null;
        }
        int temp = 0;
        while (i >= 0 && j >= 0) {
            char ch_1 = param1.charAt(i);
            char ch_2 = param2.charAt(j);

            int v1 = getIntFromChar(ch_1);
            int v2 = getIntFromChar(ch_2);
            int ret = v1 + v2;

            if (ret >= 36) {
                int index = ret - 36 + temp;
                char sv = symbol.charAt(index);
                stringBuffer.append(sv);
                temp = 1; //进位
            } else {
                int index = ret + temp;
                char sv = symbol.charAt(index);
                stringBuffer.append(sv);
                temp = 0;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            char ch_1 = param1.charAt(i);
            stringBuffer.append(ch_1);
            i--;
        }
        while (j >= 0) {
            char ch_2 = param2.charAt(i);
            stringBuffer.append(ch_2);
            j--;
        }
        StringBuffer result = stringBuffer.reverse();
        return result.toString();
    }
}
