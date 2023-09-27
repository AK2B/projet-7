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
@Table(name = "rulename")
public class RuleName {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private	Integer id;
	
	private	String name;
	private	String description;
	private	String json;
	private	String template;
	private	String sqlStr;
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
