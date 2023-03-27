package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 11:05
 * @Description 归并排序 最佳情况：T(n) = O(n) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        int[] sortNums = margeSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(sortNums));
    }

    public static int[] margeSort(int[] nums) {
        if(nums == null || nums.length < 2) return nums;
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        // 取平均值后，递归拆分小份比较后合成大份比较（始终左右两个数组在比较）
        return marge(margeSort(left), margeSort(right));
    }

    private static int[] marge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, l = 0, r = 0; index < result.length; index++) {
            if (l >= left.length)
                result[index] = right[r++];
            else if (r >= right.length)
                result[index] = left[l++];
            // 递归到最底层的时候，left、right只有一个元素
            // 先进行下面比较，顺便通过后++移动来保证上面判断可以取到元素放在result后面
            else if (left[l] > right[r])
                result[index] = right[r++];
            else
                result[index] = left[l++];
        }
        return result;
    }


}
