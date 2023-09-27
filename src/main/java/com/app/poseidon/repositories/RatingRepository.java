package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.poseidon.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
