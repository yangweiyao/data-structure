package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 14:09
 * @Description 基数排序 最佳情况：T(n) = O(n+k) 最差情况：T(n) = O(n+k) 平均情况：T(n) = O(n2)
 **/
public class RadixSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        radixSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    public static void radixSort(int[] nums) {
        if(nums == null || nums.length == 0) return;

        // 获取最大值
        int max = nums[0];
        for (int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        // 用二维数组模拟桶
        int[][] bucket = new int[10][nums.length];

        // 元素最大值的长度
        int length = String.valueOf(max).length();

        // 将整数按位数切割成不同的数字，然后按每个位数分别比较
        for (int i = 0, n = 1; i < length; n *=10, i++) {
            // 记录每个桶有几个元素
            int[] bucketRecord = new int[10];
            for (int num : nums) {
                // 个/十/百.../位数的下标
                int sub = (num / n) % 10;
                // 给桶里面赋值
                bucket[sub][bucketRecord[sub]] = num;
                // 并且记录当前桶里面元素个数，加1
                bucketRecord[sub]++;
            }

            int index = 0;
            for (int j = 0; j < bucketRecord.length; j++) {
                // 最后一轮基本有序了，只需要将桶数据放入原数组
                for (int k = 0; k < bucketRecord[j]; k++) {
                    nums[index++] = bucket[j][k];
                }
            }
        }

    }

}
