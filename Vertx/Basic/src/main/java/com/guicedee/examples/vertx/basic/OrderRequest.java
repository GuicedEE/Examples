package com.guicedee.examples.vertx.basic;

/**
 * Simple DTO for order events sent over the Vert.x event bus.
 * Must be in a package opened to com.fasterxml.jackson.databind for serialization.
 */
public class OrderRequest
{
    private String id;
    private String item;
    private double amount;

    public OrderRequest() {}

    public OrderRequest(String id, String item, double amount)
    {
        this.id = id;
        this.item = item;
        this.amount = amount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString()
    {
        return "OrderRequest{id='" + id + "', item='" + item + "', amount=" + amount + "}";
    }
}

