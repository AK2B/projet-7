package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poseidon.domain.BidList;

@Repository
public interface BidListRepository extends JpaRepository<BidList, Integer> {


	
}
