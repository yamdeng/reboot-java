package com.yamdeng.reboot.java.basic;

import java.util.Random;

// 랜덤 추출
public class RandomFunction {

    public static void main(String[] args) {
        System.out.println("랜덤 추출");
        System.out.println();

        // Random
        randomFunction();
        System.out.println();

        System.out.println("========== RandomFunction End ==========");
    }

    private static void randomFunction() {
        System.out.println("Random");
        Random random = new Random();
        for(int index=0; index<200; index++) {
            int randomValue = random.nextInt(6) + 1;
            System.out.println("randomValue : " + randomValue);
        }
    }
}
