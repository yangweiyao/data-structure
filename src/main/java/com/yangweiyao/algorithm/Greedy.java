package com.yangweiyao.algorithm;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-10 11:17
 * @Description 贪心算法：不从整体最优上加以考虑，只做出在某种意义上的局部最优解。
 **/
public class Greedy {

    /**
     * 基本思路：
     * 1） 建立数学模型来描述问题
     * 2） 把求解的问题分成若干个问题
     * 3） 对每一子问题求解，得到子问题的局部最优解
     * 4） 把子问题的局部最优解合成原来解问题的一个解
     */
    public static void main(String[] args) {
        // 币值（从小到大）
        int[] values = {1, 2, 5, 10, 20, 50, 100};
        // 数量（与币值对应）
        int[] counts = {3, 4, 3, 5, 3, 2, 10};
        smallChange(377, values, counts);
    }

    /**
     *  指定币值和相应的数量，用最少的数量凑齐某金额
     */
    public static void smallChange(int sum, int[] values, int[] counts) {
        int[] result = new int[values.length];
        int money = 0;

        // 贪心思想：我们不想兑太多零钱，尽可能要多点币值大点的钱好管理，意味我们想要更多100元的币值
        // 优先考虑以最大面值开始兑换
        for (int i = values.length - 1; i >= 0; i--) {

            int num = (sum - money) / values[i];

            // 如果超过币值对应的数量
            if(num > counts[i]) num = counts[i];

            money += num * values[i];

            result[i] = num;
        }

        System.out.println(Arrays.toString(result));
    }


}
