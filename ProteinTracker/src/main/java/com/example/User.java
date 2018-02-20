package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
	private int id;
	private String name;
	
	private ProteinDate proteinData= new ProteinDate();
	
	private List<UserHistory> history = new ArrayList<UserHistory>();
	
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
	public ProteinDate getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinDate proteinData) {
		this.proteinData = proteinData;
	}
	public List<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	
	

}
