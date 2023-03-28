package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 14:09
 * @Description 计数排序 最佳情况：T(n) = O(n+k) 最差情况：T(n) = O(n+k) 平均情况：T(n) = O(n+k)
 **/
public class CountingSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        int[] result = countingSortPro(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(result));
    }

    /**
     * 计数排序思想：利用数组的索引是有序的，通过将序列中的元素作为索引，其个数作为值放入数组，遍历数组来排序。<br>
     * 存在问题：<br>
     * 1. 新建一个长度为max+1的数组会造成内存的浪费，比如元素为{400，405，410}则新建数组的长度为411，这会使前面的0 ~ 400索引没用，造成内存浪费。<br>
     * 2. 其将元素作为键，将个数作为值放入新的数组中，但是如果存在相同的元素，我们只统计其个数，其顺序无法确定，是不稳定的。<br>
     * @param nums 需要排序的数组
     */
    public static void countingSort(int[] nums) {
        if(nums == null || nums.length == 0) return;

        // 获取数组最大值，用于创建长度为max+1的新数组
        int max = nums[0];
        for (int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        // 旧数组的值作为新数组的索引，个数作为值
        int[] newNums = new int[max + 1];
        for (int num : nums) {
            // 利用数组索引有序特性，将元素以索引方式顺序排列
            newNums[num]++;
        }

        int n = 0;
        for (int i = 0; i < newNums.length; i++) {
            // j < newNums[i] 过滤出新数组值不为0的索引
            for (int j = 0; j < newNums[i]; j++) {
                // 将索引（旧数组的值）覆盖到需要排序的（旧）数组
                nums[n++] = i;
            }
        }
    }

    /**
     * 计数排序-优化版（主要解决countingSort存在的问题）<br>
     * 解决方案：<br>
     * 1. 取数组中的最大值max和最小值min，新建(max-min +1)长度的数组，数组的元素存放在新数组中的（arr[i]-min）索引处。<br>
     * 2. 新建一个统计数组，其长度为(max-min +1)，其索引存放的是新数组该索引之前元素的和，这个和表示的是该索引（该元素）在原数组中的排序顺序，就是排第几。<br>
     * @param nums 需要排序的数组
     */
    public static int[] countingSortPro(int[] nums) {
        if(nums == null || nums.length == 0) return nums;

        // 获取数组最大最小值，缩短不必要的长度, 用于创建长度为max-min+1的新数组
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        int[] newNums = new int[max - min + 1];
        // 用于记录当前数据排在第几位
        int[] countArr = new int[newNums.length];
        for (int num : nums) {
            // 利用数组索引有序特性，将元素以索引方式顺序排列
            newNums[num - min]++;
        }

        // 统计数组其索引存放的是新数组该索引之前元素的和
        for (int i = 0; i < newNums.length; i++) {
            if (i == 0) {
                countArr[i] = newNums[i];
                continue;
            }
            countArr[i] = newNums[i] + countArr[i - 1];
        }

        // 新建一个最终数组result
        int[] result = new int[nums.length];
        // 反向遍历原数组
        for (int i = nums.length - 1; i >= 0; i--) {
            // 统计数组countArr[nums[i] - min] - 1中记录的是元素排在第几位
            result[countArr[nums[i] - min] - 1] = nums[i];
            // 每排列一个，就减少一个位置
            countArr[nums[i] - min]--;
        }

        return result;

    }

}
