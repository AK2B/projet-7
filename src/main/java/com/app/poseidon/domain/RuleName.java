package com.app.poseidon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rulename")
public class RuleName {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private	Integer id;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String name;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String description;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String json;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String template;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String sqlStr;
	
	@NotBlank(message = "Le champ ne peut pas être null.")
	private	String sqlPart;
	
	public RuleName() {
		super();
	}
	
	public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
		super();
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}


	
	
}
