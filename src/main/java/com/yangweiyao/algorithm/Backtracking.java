package com.yangweiyao.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-03 16:27
 * @Description 回溯算法：与穷举算法最直接的区别是可以适当加入一些判断过滤掉一些【无用的穷举】，减少穷举次数，其次回溯和递归是相辅相成的
 **/
public class Backtracking {

    public static void main(String[] args) {
        leetcode_77(4, 2);
        leetcode_216(3, 7);
    }


    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案。
     * 输入：n = 4, k = 2
     * 输出：[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
     */
    public static void leetcode_77(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs_77(1, n, k, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    private static void dfs_77(int index, int n, int k, List<Integer> path, List<List<Integer>> ans) {
        if(path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs_77(i + 1, n, k, path, ans);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 1) 只使用数字1到9
     * 2) 每个数字 最多使用一次
     * 3) 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 解释: 1 + 2 + 4 = 7
     */
    public static void leetcode_216(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs_216(1, n, k, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    private static void dfs_216(int index, int n, int k, List<Integer> path, List<List<Integer>> ans) {
        if(path.size() == k) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            if(sum == n) ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i <= 9; i++) {
            path.add(i);
            dfs_216(i + 1, n, k, path, ans);
            path.remove(path.size() - 1);
        }
    }

}
