package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 14:17
 * @Description 快速排序 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(nlogn)
 **/
public class QuickSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(8);

        long start = System.currentTimeMillis();
        quickSort(nums, 0, nums.length - 1);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
    public static void quickSort(int[] nums, int start, int end) {
        // 数组长度为1时终止递归
        if(nums == null || nums.length < 2 || start >= end) return;
        // 寻找基准位置
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        // 由于快速排序每轮选取「子数组最左元素」作为「基准数」， int pivot = nums[start];
        // 因此在输入数组完全有序或完全倒序时，partition()每轮只划分一个元素，达到最差时间复杂度O(n^2)。
        // 每轮在子数组中随机选择一个元素作为基准数，这样就可以极大概率避免以上劣化情况。
        // 值得注意的是，由于仍然可能出现最差情况，因此快速排序的最差时间复杂度仍为O(n^2)
        // 随机生成[start, end]区间的基准
        int pivot = (int) (start + Math.random() * (end - start + 1));
        swap(nums, start, pivot); // 随机索引找到后交换基准数
        int i = start, j = end; // 前后两个指针
        while (i < j) {
            // 从后往前找比基准数小或者等于的数
            while (i < j && nums[j] >= nums[start]) j--;
            // 从前往后找比基准数小或者等于的数
            while (i < j && nums[i] <= nums[start]) i++;
            // 交换指针的位置，这样就会左边数小于基准数，右边数大于基准数
            swap(nums, i, j);
        }
        // 之前的基准数也得交换位置
        swap(nums, i, start);
        return i;
    }


    private static void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
