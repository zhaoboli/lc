/**
 * Prob: can-place-flower
 * 一个长条花坛里有若干并排的花槽，有些花槽中已经种了花，有些则还没种花。然而，不能将两株花种在相邻的花槽否则它们会争夺水分导致两者都枯萎.
 * 给定一个花坛的种植情况   flowerbed（一个包含0和1的数组，0表示该花槽为空，1表示该花槽已经种了花），以及一个数n，
 * 问是否可以再种下新的n株花且满足相邻花槽不能同时种花的条件。
 * 思路：
 * 从左往右扫描花槽，每遇到一个满足条件可以种植的花槽（前后花槽都为空或者为边界），就在这个位置种花，看能种下的花的数量是否大于等于n，是则返回true，否则返回false
 * 一个小优化是当计数计到n时即可直接返回true。算法时间复杂度为O(n)，额外空间复杂度为O(1)
 *
 *
 * 输入： flowerbed = [1,0,0,0,1], n = 1 输出： True
 * 输入： flowerbed = [1,0,0,0,1], n = 2 输出： False
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) 
                    && (i == (flowerbed.length - 1) || flowerbed[i+1] == 1)) {
                flowerbed[i] = 1;
                count++;
                    }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
}
