package com.edocti.jintro.hw1.election;

/**
 * Represents a candidate and their info.
 * @author manciul
 */
public class Candidate extends Voter {
	
	Candidate(Voter v, Party p) {
		super(v);
		this.party = p;
	}
}