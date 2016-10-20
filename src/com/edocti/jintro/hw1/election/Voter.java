package com.edocti.jintro.hw1.election;

/**
 * Represents a voter and their info, can join and belong to a party, and vote in elections.
 * @author manciul
 */
public class Voter extends Person {
	protected Party party;
	
	Voter(Person p) {
		super(p.name, p.CNP, p.age);
	}
	
	/**
	 * Join a given party.
	 * @param p {@link Party} to be joined.
	 */
	public void joinParty(Party p) {
		p.addMember(this);
		party = p;
	}
	
	/**
	 * Vote for a candidate.
	 * @param c {@link Candidate} to be voted for.
	 */
	public void voteFor(Candidate c) {
		Election.Results.addVote(c);
	}
	
	/**
	 * Display voter info to standard output.
	 */
	@Override
	public void display() {
		System.out.printf("Name: %28s\nParty: %27s\nAge: %29d\n", name, party.name, age);
	}
}