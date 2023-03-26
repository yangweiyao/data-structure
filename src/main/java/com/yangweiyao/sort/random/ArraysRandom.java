package com.yangweiyao.sort.random;

import java.util.Random;

/**
 * 数组生成器
 * @Author: yangweiyao
 * @CreateTime: 2023-03-10 09:31
 **/
public class ArraysRandom {

    private final static int SEMEN_MAX_THRESHOLD = 100000;

    public static int[] createArray() {
        return createArray(SEMEN_MAX_THRESHOLD);
    }

    public static int[] createArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        int bound = Math.max(length, 100);
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
