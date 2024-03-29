package com.app.poseidon.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trade")
public class Trade {
	

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private	Integer tradeId;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String account;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String type;
	
	@NotNull(message = "Le champ ne peut pas être null.")
	@Positive(message = "Doit être un nombre positif.")
	private	Double buyQuantity;
	
	
	private	Double sellQuantity;	
	private	Double buyPrice;	
	private	Double sellPrice;	
	private	String benchmark;
	private	Timestamp tradeDate;
	private	String security;
	private	String status;
	private	String trader;
	private	String book;
	private	String creationName;
	private	Timestamp creationDate;
	private	String revisionName;
	private	Timestamp revisionDate;
	private	String dealName;
	private	String dealType;
	private	String sourceListId;
	private	String side;
	
	
	public Trade(String account, String type, Double buyQuantity) {
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
	}

	public Trade() {
		super();
	}
}
