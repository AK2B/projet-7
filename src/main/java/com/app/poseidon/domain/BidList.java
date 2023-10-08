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
@Table(name = "bidlist")
public class BidList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer BidListId;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private String account;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private String type;
	
	@NotNull(message = "Le champ ne peut pas être null.")
	@Positive(message = "Doit être un nombre positif.")
	private Double bidQuantity;
	
	private Double askQuantity;
	private Double bid;
	private Double ask;
	private String benchmark;
	private Timestamp bidListDate;
	private String commentary;
	private String security;
	private String status;
	private String trader;
	private String book;
	private String creationName;
	private Timestamp creationDate;
	private String revisionName;
	private Timestamp revisionDate;
	private String dealName;
	private String dealType;
	private String sourceListId;
	private String side;
	
	
	

	public BidList(String account, String type, double bidQuantity) {
		 	this.account = account;
		    this.type = type;
		    this.bidQuantity = bidQuantity;
	}


	public BidList() {
		super();
		
	}
	
}
