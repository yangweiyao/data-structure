package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * 冒泡排序 每一轮比较结束后，都会出来一个最大值
 * @Author: yangweiyao
 * @CreateTime: 2023-03-10 09:16
 **/
public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray();

        long start = System.currentTimeMillis();
        bubbleSortPro(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }


    /**
     * 冒泡排序
     * @param nums 需要排序的数组
     */
    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            // 减1：最后一位不需要交换比较，否则数组越位异常
            // 减i：由于每一轮比较结束后，都会出来一个最大值，所以之前前i轮出来的最大值不需要比较
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序-优化<br>
     * 1）减少比较轮数：如果这一轮比较重没有交换位置，可以直接结束循环<br>
     * 2）减少比较次数：例如【4,6,3,7,8,9,10】, 那么 7,8,9,10 都可以直接跳过比较的<br>
     * @param nums 需要排序的数组
     */
    public static void bubbleSortPro(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int position = nums.length - 1; // 定义一个作为比较的边界

        for (int i = 0; i < nums.length; i++) {

            boolean flag = true; // 标志位
            int limit = 0; // 记录最后交换位置的值

            for (int j = 0; j < position; j++) {
                if(nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                    limit = j;
                }
            }

            position = limit;

            if(flag) {
                // 如果没有交换位置，直接跳过这一轮比较
                break;
            }
        }
    }

}
