package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * 最佳情况：T(n) = O(n2) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 * @author YangWeiYao
 * @Description 选择排序，找到最小数的索引保存
 * @date 2023-3-12 20:51
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray();

        long start = System.currentTimeMillis();
        selectionSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序<br>
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
     * @param nums 需要排序的数组
     */
    public static void selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            // 从i开始寻找最小数的索引，i索引前面的数字已经是有序的
            for (int j = i; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]) { // 找到最小的数
                    minIndex = j; // 将最小数的索引保存
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

}
