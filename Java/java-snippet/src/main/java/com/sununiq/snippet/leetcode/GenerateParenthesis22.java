package com.sununiq.snippet.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: java-snippet
 *
 * @description:
 * 1. 暴力解法，求出所有的组合，然后判断是否是合法的
 * 2. 回溯 TODO
 *
 * @author: sununiq
 *
 * @create: 2018-11-04 21:22
 **/
public class GenerateParenthesis22 {

    public static void main(String[] args) {
        GenerateParenthesis22 gen = new GenerateParenthesis22();
        System.out.println(gen.generateParenthesis(6).size());
        System.out.println(gen.generateParenthesis1(6).size());

        int[] arr = new int[]{4, 5, 7, 1, 0, 10};
        gen.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generateAll(new char[n * 2], 0, result);
        return result;
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length ) {
            if (isValid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return (balance == 0);
    }

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new LinkedList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}
