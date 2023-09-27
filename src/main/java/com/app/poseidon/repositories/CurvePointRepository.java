package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.poseidon.domain.CurvePoint;

@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

}
