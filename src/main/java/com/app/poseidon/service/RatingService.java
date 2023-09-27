package com.app.poseidon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poseidon.domain.Rating;
import com.app.poseidon.repositories.RatingRepository;

import jakarta.validation.Valid;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Rating> getAllRating () {
		return ratingRepository.findAll();
	}

	public Rating saveRating(@Valid Rating rating) {
		return ratingRepository.save(rating);
		
	}

	public Rating getRatingById(Integer id) {
		return ratingRepository.getById(id);
	}

	public Rating updateRating(Integer id, @Valid Rating rating) {
		return ratingRepository.save(rating);
		
	}

	public void deleteRating(Integer id) {
		ratingRepository.deleteById(id);
		
	}
}
