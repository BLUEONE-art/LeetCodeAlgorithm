package algorithm.random_0_9;

import java.util.Random;

public class Extend0_6To0_9 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int rand1 = rand10();
            System.out.println(rand1);
        }
    }

    public static int rand6() {
        // 生成随机数
        Random r = new Random();
        int ran1 = r.nextInt(6);
        return ran1 + 1;
    }

    public static int rand10() {
        int x = 0;
        while ((x = (rand6() - 1) * 6 + (rand6() -1)) >= 36);
        return x % 9 + 1;
    }
}
