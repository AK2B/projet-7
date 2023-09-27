package com.app.poseidon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poseidon.domain.Trade;
import com.app.poseidon.repositories.TradeRepository;

import jakarta.validation.Valid;

@Service
public class TradeService {
	
	@Autowired
	private TradeRepository tradeRepository;
	
	public List<Trade> getAllTrade () {
		return tradeRepository.findAll();
	}

	public Trade saveTrade(@Valid Trade trade) {
		return tradeRepository.save(trade);
		
	}

	public Trade getTradeById(Integer tradeId) {
		return tradeRepository.getById(tradeId);
	}

	public Trade updateTrade(Integer id, @Valid Trade trade) {
		return tradeRepository.save(trade);
		
	}

	public void deleteTrade(Integer id) {
		tradeRepository.deleteById(id);
		
	}


}
