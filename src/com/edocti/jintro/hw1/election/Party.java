package com.edocti.jintro.hw1.election;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a political party. Has members that are {@link Voter Voters}, picks a {@link Candidate} from its members to run in the election.
 * @author manciul
 *
 */
public class Party {
	
	public String name;
	public Candidate candidate;
	
	private List<Voter> members = new ArrayList<Voter>();
	
	Party(String n) {
		this.name = n;
	}
	
	/**
	 * Accept a new member.
	 * @param v {@link Voter} to be added as a member.
	 */
	public void addMember(Voter v) {
		members.add(v);
	}
	
	/**
	 * Accepts a given voter as the party candidate.
	 * @param v {@link Voter} to be picked as candidate.
	 */
	public void chooseCandidate(Voter v) {
		candidate = new Candidate(v, this);
		Election.Results.addCandidate(candidate);
	}
	
	/**
	 * Returns the number of members that have joined the party.
	 * @return <code>int</code> number of members
	 */
	public int getMembersNumber() {
		return members.size();
	}
	
	public List<Voter> getMembers() {
		return members;
	}
	
	/**
	 * Display party info in standard output.
	 */
	public void display() {
		System.out.printf("%s\nMembers: %06d     Candidate: ", name, members.size());
		if (candidate != null) 
			System.out.printf("%23s\n", candidate.name);
		else
			System.out.printf("None chosen.\n");
	}
}