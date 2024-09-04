package com.example.demo.service;

import com.example.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    public double calculateTotal(List<Item> items, double discount) {
        if (items.isEmpty() || discount > 1 || discount < 0){
            throw new RuntimeException();
        }
        double total = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        return total - (total * discount);
    }

}
