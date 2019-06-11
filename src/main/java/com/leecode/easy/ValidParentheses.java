package com.leecode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.poll() != getLeft(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isLeft(char c) {
        return c == '(' || c == '{' ||  c == '[';
    }
    
    private char getLeft(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        return '.';
    }
    
    public static void main(String[] args) {
        ValidParentheses app = new ValidParentheses();
        System.out.println(app.isValid("()[]{}"));
        System.out.println(app.isValid("([)]"));
    }
}