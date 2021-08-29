package input;

import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static double p = 1e-15;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String l = bf.readLine();
        String[] strings = l.split(" ");
        int x = Integer.parseInt(strings[0]);
        double res = mySqrt(8);        System.out.println(String.format("%3f", res));

        Pair pair = getMultiNums();
        pair.getKey();
        pair.getValue();
    }

    public static double mySqrt(int x) {
        double left = 1;
        double right = x;
        while (left < right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(mid * mid - x) < p) {
                return mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 得到二维矩阵
     * @return matrix
     * @throws IOException
     */
    public static int[][] get2DMatrix() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String l1 = bf.readLine();
        String[] rowAndCol = l1.split(" ");
        int row = Integer.parseInt(rowAndCol[0]);
        int col = Integer.parseInt(rowAndCol[1]);
        int[][] matrix = new int[row][col];
        String l2 = bf.readLine();
        String[] nums = l2.split(" ");
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(nums[count]);
                count++;
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("\t");
        }
        return matrix;
    }

    /**
     * 得到一维矩阵
     * @return int[]
     * @throws IOException
     */
    public static int[] get1DMatrix() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String l1 = bf.readLine();
        String[] strings = l1.split(" ");
        int n = Integer.parseInt(strings[0]);
        int[] nums = new int[n];
        String l2 = bf.readLine();
        String[] num = l2.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(num[i]);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
        return nums;
    }

    /**
     * 得到多个数
     * @return Pair<Integer, Integer></>
     * @throws IOException
     */
    public static Pair<Integer, Integer> getMultiNums() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行：第一行中有两个字符串
        String l1 = bf.readLine();
        // 将第一行以空格进行分割，即可得到所需的两个字符串
        String[] strings = l1.split(" ");
        int fir = Integer.parseInt(strings[0]);
        int lst = Integer.parseInt(strings[1]);
        System.out.println("fir:" + fir + "\tlst:" + lst);
        return new Pair<>(fir, lst);
    }

    /**
     * 使用BufferedReader+InputStreamReader获取字符串
     * @return str
     * @throws IOException
     */
    public String getStr() throws IOException{
        // Scanner效率要比BufferedReader差很多
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String str = bf.readLine();
        System.out.println(str);
        return str;
    }

    /**
     * 使用Scanner获取二维数组
     * @return matrix
     */
    public static int[][] getMatrix() {
        System.out.println("二维数组的行列数：");
        Scanner sc = new Scanner(System.in);
        // nextInt：以有效数字后的空格作为两个输入数据之间的间隔
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        // nextLine：以enter为结束符，输入的结果是两个enter之间的所有字符
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
        return matrix;
    }
}
