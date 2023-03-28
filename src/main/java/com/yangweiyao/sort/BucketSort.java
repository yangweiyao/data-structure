package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 14:09
 * @Description
 **/
public class BucketSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        bucketSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 桶排序：将数据放入桶中，每个桶中的元素分别进行排序，其实就是一种用空间换时间的算法，还包含一种分治思想。<br>
     * 桶排序适用于序列中元素的分布比较均匀的场景
     * @param nums 需要排序的数组
     */
    public static void bucketSort(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }

        // 桶数量，范围在nums.length，支持自定义桶数
        int bucketNum = (max - min) / nums.length + 1;

        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : nums) {
            // 计算该num命中哪个桶
            int index = (num - min) / nums.length;
            buckets.get(index).add(num);
        }

        for (List<Integer> bucket : buckets) {
            if(bucket.size() == 0) {
                continue;
            }
            Collections.sort(bucket);
        }

        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                nums[i++] = num;
            }
        }

    }

}
