package com.yangweiyao.sort;

import com.yangweiyao.sort.random.ArraysRandom;

import java.util.Arrays;

/**
 * @Author yangweiyao
 * @CreateTime 2023-03-27 14:09
 * @Description 堆排序 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
 **/
public class HeapSort {

    public static void main(String[] args) {

        int[] nums = ArraysRandom.createArray(10);

        long start = System.currentTimeMillis();
        heapSort(nums);
        System.out.println("排序cost: " + (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 利用完全二叉树特性，构造最大堆后，依次遍历，交换首尾，然后重新调整最大堆
     * @param nums 待排序的数组
     */
    public static void heapSort(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int[] copy = Arrays.copyOf(nums, nums.length);

        // 二叉树，对于当前节点i，其左孩子为2*i，其右孩子为2*i+1
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 构建最大堆，堆顶是整个堆中最大元素
            adjustHeap(nums, i, nums.length);
        }

        for(int j = nums.length - 1; j > 0; j--) {
            // 末尾节点与首节点交换位置
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            // 重新构建最大堆
            adjustHeap(nums, 0, j);
        }
    }

    private static void adjustHeap(int[] nums, int index, int len) {
        // 当前节点下标
        int max = index;
        // 左子树的下标
        int leftChild = index * 2 + 1;
        // 右子树的下标
        int rightChild = index * 2 + 2;

        // 左右孩子下标必须小于len，确保数组不会越界
        if(leftChild < len && nums[leftChild] > nums[max]) {
            max = leftChild;
        }

        if(rightChild < len && nums[rightChild] > nums[max]) {
            max = rightChild;
        }

        // max节点值需要与index节点值交换
        if(max != index) {
            int temp = nums[index];
            nums[index] = nums[max];
            nums[max] = temp;
            // 交换完之后需要再次对max进行调整，因为此时max有可能不满足最大堆
            adjustHeap(nums, max, len);
        }
    }

}
