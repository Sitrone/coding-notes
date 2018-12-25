package com.sununiq.snippet.leetcode;

import java.util.*;

/**
 * @program: java-snippet
 *
 * @description:
 *
 * @author: sununiq
 *
 * @create: 2018-10-29 20:27
 **/
public class Subsets78 {

    public static void main(String[] args) {
        System.out.println((new Subsets78().subsets(new int[]{1, 2, 3})));
    }

    // bfs 耗时185ms
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        for (int i = 0; i <= nums.length; i++) {
            for (Set<Integer> set : subsets(nums, i)) {
                result.add(new ArrayList<>(set));
            }
        }
        result.add(new ArrayList<>());
        return result;
    }

    private List<Set<Integer>> subsets(int[] nums, int count) {
        List<Set<Integer>> result = new ArrayList<>();

        //bfs 起始搜索路径
        Queue<Set<Integer>> paths = new LinkedList<>();
        for (int n : nums) {
            paths.offer(new HashSet<>(Arrays.asList(n)));
        }

        while (!paths.isEmpty()) {
            Set<Integer> tempSet = paths.poll();
            if (tempSet.size() == count) {
                result.add(tempSet);
                continue;
            }

            for (int num : nums) {
                // 数字不能重复
                if (!tempSet.contains(num)) {

                    // 集合不能重复
                    Set<Integer> set = new HashSet<>(tempSet);
                    set.add(num);
                    if (!paths.contains(set)) {
                        paths.offer(set);
                    }
                }
            }
        }

        return result;
    }
}
