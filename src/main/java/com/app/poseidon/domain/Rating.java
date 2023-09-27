package com.app.poseidon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {
	
	
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
	private String moodysRating;
	private String sandPRating;
	private String fitchRating;
	private Integer orderNumber;
	
	public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
		super();
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

	public Rating() {
		super();
	}
	
}
