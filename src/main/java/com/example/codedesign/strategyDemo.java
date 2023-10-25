package com.example.codedesign;

import com.example.order.Order;
import com.example.payStrategy.PayStrategy;
import com.example.strategies.PayByCreditCard;
import com.example.strategies.PayByPaypal;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author diviner16
 * @date 2023年10月08日 13:18
 */

@SpringBootApplication
public class strategyDemo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy payStrategy;

    static {
        priceOnProducts.put(1, 1000);
        priceOnProducts.put(2, 2000);
        priceOnProducts.put(3, 4000);
        priceOnProducts.put(5, 6000);
        priceOnProducts.put(6, 2000);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;
            do {
                System.out.println("please select a product :" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.println("count:");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(count * cost);
                System.out.println("so you want to continue choice products y/n? :");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("y"));
            if (payStrategy == null) {
                System.out.println("please select a payment method :" + "\n" +
                        "1---paypal" + "\n" +
                        "2---credit card ");
                String paymentMethod = reader.readLine();
                //clinet create different strategies based on input from user
                if (paymentMethod.equals("1")) {
                    payStrategy = new PayByPaypal();
                } else {
                    payStrategy = new PayByCreditCard();
                }
            }
            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(payStrategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (payStrategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed(true);
            }
        }
    }

}
