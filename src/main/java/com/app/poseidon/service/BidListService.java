package com.app.poseidon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poseidon.domain.BidList;
import com.app.poseidon.repositories.BidListRepository;

import jakarta.validation.Valid;

@Service
public class BidListService {
	
	@Autowired
	private BidListRepository bidListRepository;
	
	public List<BidList> getAllBidList () {
		return bidListRepository.findAll();
	}

	public BidList saveBidList(@Valid BidList bid) {
		return bidListRepository.save(bid);
	}

	public BidList getBidListById(Integer bidListId) {
		return bidListRepository.getById(bidListId);
	}

	public BidList updateBidList(Integer id, @Valid BidList bidList) {
		
		return bidListRepository.save(bidList);
	}

	public void deleteBidList(Integer id) {
		bidListRepository.deleteById(id);
		
	}

}
