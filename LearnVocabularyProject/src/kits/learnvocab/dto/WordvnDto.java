package kits.learnvocab.dto;

import java.io.Serializable;

public class WordvnDto implements Serializable{
	private int id;
	private String name;
	
	
	
	public WordvnDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public WordvnDto() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
