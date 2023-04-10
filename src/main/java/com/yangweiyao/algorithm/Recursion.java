package com.yangweiyao.algorithm;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-10 14:30
 * @Description 递归算法
 **/
public class Recursion {

    public static void main(String[] args) {
        System.out.println(fact(18));
        System.out.println(fibonacci(8));
        hanoi(3, "A", "B", "C");
    }


    /**
     * 求一个非负整数n的阶乘
     * 阶乘的递推公式为 fact(n) = fact(n-1)*n, 还需要注意的是0的阶乘为1,1的阶乘为1
     */
    private static int fact(int i) {
        if(i == 0 || i == 1) {
            return 1;
        } else {
            return i * fact(i - 1);
        }
    }

    /**
     * 斐波那契: 前两个数相加等于第三个数 例如：1+1=2，1+2=3
     * 形如 1、1、2、3、5、8、13、21、34 ...的数列
     * 递推公式为 f(n) = f(n-1) + f(n-2)，n指该数在数列的位置
     * 当n=1或n=2时，递归结束，f(1)=f(2)=1
     */
    private static int fibonacci(int i) {
        if(i <= 2) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    /**
     * 汉诺塔
     * 有三根相邻的柱子，标号为A,B,C，A柱子上从下到上按金字塔状叠放着n个不同大小的圆盘，
     * 要把所有盘子一个一个移动到柱子B上，并且每次移动同一根柱子上都不能出现大盘子在小盘子上方
     */
    private static void hanoi(int n, String A, String B, String C) {
        if(n == 1) {
            System.out.printf("将%s杆的%d盘子移动到%s杆\n", A, n, C);
        } else {
            hanoi(n - 1, A, C, B);
            System.out.printf("将%s杆的%d盘子移动到%s杆\n", A, n, C);
            hanoi(n - 1, B, A, C);
        }

    }
}
