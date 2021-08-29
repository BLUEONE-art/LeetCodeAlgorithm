package bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wangyi {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数据组数：");
        String l1 = bf.readLine();
        String[] data = l1.split(" ");
        int T = Integer.parseInt(data[0]);
        // 有T组数据就要执行T遍
        for (int i = 0; i < T; i++) {
            System.out.println("请输入怪物数量：");
            String l2 = bf.readLine();
            String[] str = l2.split(" ");
            int monsterNum = Integer.parseInt(str[0]);
            // 主角属性输入
            System.out.println("请输入主角的攻守：");
            String l3 = bf.readLine();
            String[] captain = l3.split(" ");
            int[] captainAB = new int[2];
            for (int j = 0; j < 2; j++) {
                captainAB[j] = Integer.parseInt(captain[j]);
            }
            int res = -1;
            int count = 0;
            int[][] monsters = new int[monsterNum][3];
            // 每个怪兽都要判断一次，只有全部通过才可以返回
            for (int k = 0; k < monsterNum; k++) {
                // 怪物数组
                int[] monster = new int[3];
                System.out.println("请输入怪物的攻守：");
                String l4 = bf.readLine();
                String[] ABH = l4.split(" ");
                for (int l = 0; l < 3; l++) {
                    monster[l] = Integer.parseInt(ABH[l]);
                    monsters[count][l] = Integer.parseInt(ABH[l]);
                }
                count++;
            }
            res = getMinHealth(captainAB, monsters);
            System.out.println(res < 0 ? -1 : res);
        }
    }

    public static int getMinHealth(int[] captain, int[][] monsters) {
        int res = -1;
        int A = captain[0];
        int B = captain[1];
        // 暴力搜生命值1~10000中又没有符合条件的
        for (int i = 1; i <= 10000; i++) {
            int captainHealth = i;
            for (int[] monster : monsters) {
                int monsterHealth = monster[2];
                while (true) {
                    // 主角先手，求怪兽剩余血量 = 怪兽血量 - (主角攻击 - 怪兽防御)
                    monsterHealth -= (A - monster[1]);
                    // 有差值，说明当前怪兽被打死，主角被动回复血量
                    if (monsterHealth <= 0) {
                        captainHealth -= monsterHealth;
                        break;
                    }
                    // 怪兽还击：主角剩余血量 = 主角血量 - (怪兽攻击 - 主角防御)
                    captainHealth = captainHealth - (monster[0] - B);
                    // 如果主角死掉，搜下一个
                    if (captainHealth < 1) {
                        break;
                    }
                }
                // 如果主角死掉，搜下一个
                if (captainHealth < 1) {
                    break;
                }
            }
            res = captainHealth >= 1 ? i : -1;
            if (res > 0) {
                return res;
            }
        }
        return res;
    }
}
