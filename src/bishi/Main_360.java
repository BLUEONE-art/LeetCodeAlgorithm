package bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_360 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入\t烽火台个数n：\t将军人数m：\t影响范围x：\t战斗力提升k：");
        String line1 = bf.readLine();
        String[] strings1 = line1.split(" ");
        // 烽火台个数n
        int n = Integer.parseInt(strings1[0]);
        // 将军人数m
        int m = Integer.parseInt(strings1[1]);
        // 影响范围x
        int x = Integer.parseInt(strings1[2]);
        // 战斗力提升k
        int k = Integer.parseInt(strings1[3]);

        System.out.println("烽火台初始战力：");
        String line2 = bf.readLine();
        String[] strings2 = line2.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings2[i]);
        }

        // 计算结果
        int res = getMin(n, m, x, k, nums);
        System.out.println(res);
    }

    public static int getMin(int n, int m, int x, int k, int[] nums) {
        int res = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minVal = Math.min(minVal, nums[i]);
        }
        for (int i = 0; i < m; i++) {

        }
        return res;
    }
































    public static int getMaxNum(int p, int q, int[] score) {
        // 平时分不知道，但有条件：
        // ①尽可能让学生及格
        // ②期末考试分高的学生平时分高
        // ③平时分最高100分
        int res = 0;
        Arrays.sort(score);
        int maxNormalSco = 100;
        int[] normalSco = new int[score.length];
        for (int i = score.length - 1; i > 0; i--) {
            normalSco[i] = maxNormalSco;
            if (score[i] != score[i - 1]) {
                maxNormalSco--;
            }
        }
        if (score[0] == score[1]) {
            normalSco[0] = normalSco[1];
        } else {
            normalSco[0] = normalSco[1] - 1;
        }

        for (int i = score.length - 1; i >= 0; i--) {
            int finScore = (p * normalSco[i] + q * score[i]) / 100;
            if (finScore >= 60) {
                res++;
            }
        }
        return res;
    }
}

