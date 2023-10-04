package com.app.poseidon.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private	Integer id;
	
	@Positive(message = "Doit être un nombre positif.")
	private Integer curveId;
	
	private Timestamp asOfDate;
	
	@Positive(message = "Doit être un nombre positif.")
	private Double term;
	
	@Positive(message = "Doit être un nombre positif.")
	private Double value;
	
	private Timestamp creationDate;
	
	
	public CurvePoint(Integer curveId, Double term, Double value) {
		super();
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}


	public CurvePoint() {
		super();
	}
	
	
}
