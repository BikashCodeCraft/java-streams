package com.bikash.question8;

import java.math.BigDecimal;

public class Order {
    private Integer orderId;
    private String status;
    private BigDecimal amount;

    public Order(Integer orderId, String status, BigDecimal amount) {
        this.orderId = orderId;
        this.status = status;
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
