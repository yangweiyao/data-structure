package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-24 09:41
 * @Description
 **/
public class ShellSort {

    public static void main(String[] args) {

        int[] nums = {45, 61, 92, 29, 17, 94, 83};
//        int[] nums = ArraysRandom.createArray(10);
        long start = System.currentTimeMillis();
        insertShellSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 希尔排序-交换法：类似二分法思想
     * [45, 61, 92, 29, 17, 94, 83]，pointer = length / 2 = 7 / 2 = 3
     * @param nums 需要排序的数组
     */
    public static void exchangeShellSort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // [45, 61, 92, 29, 17, 94, 83]
        int[] copy = Arrays.copyOf(nums, nums.length);

        boolean isExchange = false;

        // 第一轮：pointer = length / 2 = 7 / 2 = 3
        // 第二轮：pointer = 3 / 2 = 1
        for(int i = nums.length / 2; i > 0; i /= 2) {
            // 在第一轮分组下：遍历pointer右边[29, 17, 94, 83]
            // 在第二轮分组下：遍历pointer右边[17, 92, 45, 61, 94, 83]
            for(int j = i; j < nums.length; j++) {
                // k = j - i与k -= i 主要是对应拿到pointer左边数组的值
                for(int k = j - i; k >= 0; k -= i) {
                    // pointer左边数组的值 与 pointer右边数组的值比较
                    // 比如29与45 17与61 94与92 83与29
                    // 最后一轮前后元素两两比较，把最大值往后挤
                    if(nums[k + i] < nums[k]) {
                        // 然后swag
                        int temp = nums[k + i];
                        nums[k + i] = nums[k];
                        nums[k] = temp;
                        isExchange = true;
                    }
                    if(!isExchange) {
                        // 如果没有发生swag，直接跳出
                        break;
                    }
                    isExchange = false;
                }
            }
        }
    }

    /**
     * 希尔排序-插入法：类似二分法思想
     * [45, 61, 92, 29, 17, 94, 83]，pointer = length / 2 = 7 / 2 = 3
     * @param nums 需要排序的数组
     */
    public static void insertShellSort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] copy = Arrays.copyOf(nums, nums.length);

        for(int i = nums.length / 2; i > 0; i /= 2) {
            for(int j = i; j < nums.length; j++) {
                int index = j;
                int temp = nums[index];
                while (index - i >= 0 && temp < nums[index - i]) {
                    nums[index] = nums[index - i];
                    index -= i;
                    nums[index] = temp;
                }
            }
        }
    }

}
