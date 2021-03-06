package org.bsim.walletapp_demo.shared.utils;


import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
//bedanya service dan componen
// service di pake ketika di pake di service layer
// selain dari itu pakenya si komponen
public class GenerateRandomPublicId {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int ITERATIONS = 10000;
    private final int KEY_LENGTH = 256;

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
