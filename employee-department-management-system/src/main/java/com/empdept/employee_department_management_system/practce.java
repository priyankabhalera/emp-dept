package com.empdept.employee_department_management_system;

import java.util.ArrayList;
import java.util.Stack;

public class practce {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "(S)()";
        int total = 0;
        int temp = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    total++;
                }
            } else if (ch == 'S') {
                total *= 2;
            }
        }

        System.out.println(total);
    }

}
