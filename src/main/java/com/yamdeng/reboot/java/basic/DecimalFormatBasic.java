package com.yamdeng.reboot.java.basic;

import java.text.DecimalFormat;

// DecimalFormat
public class DecimalFormatBasic {

    public static void main(String[] args) {
        System.out.println("========== 래퍼 클래스 ==========");
        System.out.println();

        // DecimalFormat Basic
        decimalFormat();

        System.out.println("========== DecimalFormatBasic End ==========");
    }

    private static void decimalFormat() {
        System.out.println("DecimalFormat Basic");

        double number  = 1234567.89;
        String[] pattern = {
                "0",
                "#",
                "0.0",
                "#.#",
                "0000000000.0000",
                "##########.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "#,####.##",
                "#E0",
                "0E0",
                "##E0",
                "00E0",
                "####E0",
                "0000E0",
                "#.#E0",
                "0.0E0",
                "0.000000000E0",
                "00.00000000E0",
                "000.0000000E0",
                "#.#########E0",
                "##.########E0",
                "###.#######E0",
                "#,###.##+;#,###.##-",
                "#.#%",
                "#.#\u2030",
                "\u00A4 #,###",
                "'#'#,###",
                "''#,###",
        };

        for(int i=0; i < pattern.length; i++) {
            DecimalFormat df = new DecimalFormat(pattern[i]);
            System.out.printf("%19s : %s\n",pattern[i], df.format(number));
        }

        try {
            DecimalFormat df = new DecimalFormat("#,###.##");
            Number convertNumber = df.parse("1,234.23");
            System.out.println("convertNumber : " + convertNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
