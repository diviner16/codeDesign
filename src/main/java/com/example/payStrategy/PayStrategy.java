package com.example.payStrategy;

/**
 * @author diviner16
 * @date 2023年10月08日 8:33
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
