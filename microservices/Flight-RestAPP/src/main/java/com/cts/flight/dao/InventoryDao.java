package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.Inventory;

public interface InventoryDao extends JpaRepository<Inventory, Long> {

}
