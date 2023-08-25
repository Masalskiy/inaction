package com.example.springboot.repository;

import com.example.springboot.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
