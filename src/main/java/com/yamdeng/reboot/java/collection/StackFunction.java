package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.Stack;

// Stack : Stack extends Vector
public class StackFunction {

    public static void main(String[] args) {
        System.out.println("========== Stack ==========");
        System.out.println();

        // stack api
        stackFunction();
        System.out.println();

        System.out.println("========== StackFunction End ==========");
    }

    // peek, push, pop, search
    private static void stackFunction() {
        System.out.println("stack api");
        Stack<String> stack = new Stack<String>();
        YamdengCollectionUtil.initStringList(stack);

        // peek
        String peekValue = stack.peek();
        System.out.println("peekValue : " + peekValue);
        peekValue = stack.peek();
        System.out.println("peekValue : " + peekValue);

        // push, pop
        stack.push("111");
        YamdengCollectionUtil.iteratorToString(stack, "111 after stack");
        String popValue = stack.pop();
        System.out.println("popValue : " + popValue);
        System.out.println("stack.search(\"AAA\") : " + stack.search("AAA"));
    }
}
