package com.example.j_25;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String tableId;
    private List<String> items;
    private LocalDateTime timestamp;

    public Order(String tableId, List<String> items) {
        this.tableId = tableId;
        this.items = items;
        this.timestamp = LocalDateTime.now();
    }

    public String getTableId() { return tableId; }
    public List<String> getItems() { return items; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Order from table " + tableId + " at " + timestamp + ": " + items;
    }
}