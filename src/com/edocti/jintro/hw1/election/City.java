package com.edocti.jintro.hw1.election;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author manciul
 */
public class City {
	
	public String name;
	private int adults;
	private Section latestSection;
	private List<Person> people = new ArrayList<Person>();
	private List<Section> sections = new ArrayList<Section>();
	
	City(String n) {
		this.name = n;
		this.adults = 0;
	}
	
	public void organizeIntoSections() {
		adults = 0;
		latestSection = openNewSection();
		people.forEach((person) -> {
			if (person.isAdult()) {
				adults++;
				if (latestSection.isFull()) {
					sections.add(latestSection);
					latestSection = openNewSection();
				}
				latestSection.registerVoter(new Voter(person));
			}
		});
		if (!latestSection.isEmpty()) 
			sections.add(latestSection);
	}
	
	public void newInhabitant(Person person) {
		people.add(person);
	}
	
	private Section openNewSection() {
		return new Section(sections.size() + 1);
	}
	
	public void display() {
		System.out.printf("%s\nPopulation: %d     Adults: %d\n", name, people.size(), adults);
		System.out.println("Sections:");
		displaySections();
	}
	
	private void displaySections() {
		int rowCount = 0;
		for (int i = 0; i < sections.size(); i++) {
			Section s = sections.get(i);
			System.out.printf("Section %02d %03d   ", s.number, s.votersNumber());
			if (++rowCount > 2) {
				rowCount = 0;
				System.out.println();
			}
		}	
		System.out.println();
	}
	
	public int getPopulation() {
		return people.size();
	}
	
	public int getAdultsNumber() {
		if (adults == 0)
			countAdults();
		return adults;
	}
	
	public List<Section> getSections() {
		return sections;
	}
	
	private void countAdults() {
		adults = 0;
		people.forEach((person) -> {
			if (person.isAdult())
				adults++;
		});
	}
}