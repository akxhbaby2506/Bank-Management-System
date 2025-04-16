package com.akbank.bms.util;

import java.util.Random;

public class AccountNumberGenerator {

    public static String generate() {
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900); // 3-digit number
        return randomNumber + "AKBANK";
    }

    public static String normalize(String existingNumber) {
        return existingNumber.replaceAll("[^0-9]", "") + "AKBANK";
    }
}
