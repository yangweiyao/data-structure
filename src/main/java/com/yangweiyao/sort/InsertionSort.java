package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @author YangWeiYao
 * @Description 插入排序
 * @date 2023-3-12 21:28
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        insertionSortPro(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入排序：<br>
     * 类似于打牌的时候，左手拿的排就是有序的、右手拿牌然后将牌与前面的牌进行比较、然后插入到合适位置。
     */
    public static void insertionSort(int[] nums) {

        if (nums == null || nums.length == 0) return;

        for (int i = 1; i < nums.length; i++) {
            int index = i; // 记录当前要比较的索引
            while (index > 0 && nums[index] < nums[index - 1]) {
                int temp = nums[index - 1];
                nums[index - 1] = nums[index];
                nums[index] = temp;
                index--;
            }
        }
    }

    /**
     * 选择排序-优化（逆序比较多的情况下可以减少比较、交换次数）
     * 先记录下当前的元素的值、将该元素前面大于该元素的数字都后移一位、然后插入
     */
    public static void insertionSortPro(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int[] copy = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            int index = i;
            int temp = nums[index]; // 记录当前要比较的元素
            while (index > 0 && temp < nums[index - 1]) {
                nums[index] = nums[index - 1]; // 大于该元素的数字都后移一位
                index--;
            }
            nums[index] = temp; // 然后插入
        }
    }

}
