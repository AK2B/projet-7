package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.poseidon.domain.Trade;


public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
