package com.example.order;

import com.example.payStrategy.PayStrategy;

/**
 * @author diviner16
 * @date 2023年10月08日 13:13
 */
public class Order {
    private int totalCost = 0;
    private boolean isClosed =false;

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void processOrder (PayStrategy payStrategy){
        payStrategy.collectPaymentDetails();
        //here we could collect and store payment date form strategy.
    }
}
