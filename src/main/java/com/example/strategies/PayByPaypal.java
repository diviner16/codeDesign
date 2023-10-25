package com.example.strategies;

import com.example.payStrategy.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author diviner16
 * @date 2023年10月08日 8:38
 */
public class PayByPaypal implements PayStrategy {
    private static final Map<String, String> DATE_BASE = new HashMap<>();

    static {
        DATE_BASE.put("sadkj11", "lsadkf123@gmail.com");
        DATE_BASE.put("uu12", "saldf1@outlook.com");
    }

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    @Override
    public boolean pay(int paymentAmount) {
        if (verify()) {
            System.out.println(" paying " + paymentAmount + "using paypal.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.println(" Enter the user s  email :");
                email = READER.readLine();
                System.out.println(" Enter the user s password");
                password = READER.readLine();
                if (verify()) {
                    System.out.println(" date verification has been successful!");
                } else {
                    System.out.println(" wrong email or password");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATE_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;

    }

}
