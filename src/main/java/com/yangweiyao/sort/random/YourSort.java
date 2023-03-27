package com.yangweiyao.sort.random;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 14:09
 * @Description
 **/
public class YourSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        yourSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    public static void yourSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        // TODO
    }

}
