package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poseidon.domain.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
