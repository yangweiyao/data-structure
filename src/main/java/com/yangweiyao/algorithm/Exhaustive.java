package com.yangweiyao.algorithm;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-30 16:37
 * @Description 穷举算法（枚举法或者蛮力法）：其依赖于计算机的强大计算能力，来穷尽每一种可能的情况，从而达到求解问题的目的。
 **/
public class Exhaustive {

    public static void main(String[] args) {
        System.out.println("====== 兑换纸币 ======");
        exchangeBills();

        System.out.println("\n====== 鸡兔同笼 ======");
        ChickenAndRabbitCoop(35, 94);
        ChickenAndRabbitCoop(21, 128);

        System.out.println("\n====== 百钱买百鸡 ======");
        buy_100ChickensFor_100Yuan(100, 100);
    }

    /**
     * 假设现在要你将100元人民币兑换成10元、5元和1元这三种面值的纸币恰好共50张(要求这三种纸币每一种都要有，且不能兑换为其它面值的纸币)，
     * 请用穷举法输出所有满足条件的兑换方案，并统计兑换方案数量。
     * 输入: 无。
     * 输出:
     * 首先输出多行，表示所有可能的方案。
     * 每行依次输出3个整数，分别表示10元、5元、1元的纸币数量。
     * 数与数之间用空格隔开，且按照升序输出答案(先按10元纸币数量升序排序,若10元纸币数量相同，则按5元纸币数量排序)。
     * 输出完所有方案后，最后-行(另起一行)输出-个整数，表示方案数。
     */
    private static void exchangeBills() {
        // 方案数
        int sum = 0;
        // 假设有i张10元，j张5元，k张1元
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 100; k++) {
                    // 满足兑换方案的方程应该是i + j + k = 50并且i ∗ 10 + j ∗ 5 + k = 100
                    if(i * 10 + j * 5 + k == 100 && i + j + k == 50) {
                        System.out.printf("%d %d %d\n", i, j, k);
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 今有鸡兔同笼，上有三十五头，下有九十四足，问鸡兔各几何？
     */
    private static void ChickenAndRabbitCoop(int head, int foot) {
        int rabbit; // 兔头
        boolean flag = false;
        for (int chicken = 0; chicken <= head; chicken++) {
            rabbit = head - chicken;
            // 兔子4只脚，鸡2只脚
            if(foot == (2 * chicken + 4 * rabbit)) {
                System.out.printf("chicken:%d, rabbit:%d\n", chicken, rabbit);
                flag = true;
            }
        }
        if(!flag) {
            System.out.printf("题目有误！head:%s, foot:%s\n", head, foot);
        }
    }

    /**
     * 鸡翁一，值钱五，鸡母一，值钱三，鸡雏三，值钱一，百钱买百鸡，问翁、母、雏各几何
     * 公鸡+母鸡+小鸡 = 100
     * 5*公鸡+3*母鸡+小鸡/3 = 100
     */
    private static void buy_100ChickensFor_100Yuan(int money, int amount) {
        int smallChicken;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <= amount; j++) {
                smallChicken = amount - i - j;
                if(smallChicken % 3 == 0 && i * 5 + j * 3 + smallChicken / 3 == money) {
                    System.out.printf("鸡翁：%d, 鸡母：%d, 鸡雏：%d\n", i, j, smallChicken);
                }
            }
        }
    }

}
