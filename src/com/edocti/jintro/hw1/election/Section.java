package com.edocti.jintro.hw1.election;

import java.util.ArrayList;
import java.util.List;

public class Section {
	
	public int number;
	private static final int SECTION_SIZE = 50000;
	
	private List<Voter> registeredVoters = new ArrayList<Voter>();
	
	Section(int n) {
		this.number = n;
	}
	
	public void registerVoter(Voter v) {
		if (isFull())
			System.err.println("Registering voter " + v + " to a full voting section.");
		registeredVoters.add(v);
	}
	
	public List<Voter> getRegisteredVoters() {
		return registeredVoters;
	}
	
	public int votersNumber() {
		return registeredVoters.size();
	}
	
	public boolean isFull() {
		return (registeredVoters.size() >= SECTION_SIZE);
	}
	
	public boolean isEmpty() {
		return (registeredVoters.size() == 0);
	}
}