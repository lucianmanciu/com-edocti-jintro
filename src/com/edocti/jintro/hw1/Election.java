package com.edocti.jintro.hw1;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * We want to implement a simplified voting system.
 * Think about the entities which are involved during a vote: citizens, cities, voting sections, vote, party (political party), election, etc.
 * Simulate a voting scenario and display the results
 * 		You can generate random citizens who vote randomly for a list of pre-defined political parties
 *		Be aware that it's a bad design idea to add this behavior (random generation of persons and votes) inside the Citizen / Vote classes -
 *		instead, try to separate the entities involved in the vote from the test case you are trying to build.
 * @author manciul
 */
public class Election {
	
	private static List<City> cities = new ArrayList<City>();
	private static List<Party> parties = new ArrayList<Party>(); 
	private static final int VOTING_AGE = 18;
	private static final Random RANDOM = new Random();

	private static class Person {
		
		protected String name;
		protected String CNP;
		protected int age;
		
		Person(String n, String c, int a) {
			this.name = n;
			this.CNP = c;
			this.age = a;
		}
		
		private boolean isAdult() {
			return (age >= VOTING_AGE);
		}
		
		@SuppressWarnings("unused")
		void display() {
			System.out.printf("Name: %s\nAge: %d\n", name, age);
		}
	}
	
	private static class Voter extends Person {
		protected Party party;
		
		Voter(Person p) {
			super(p.name, p.CNP, p.age);
		}
		
		private void joinParty(Party p) {
			p.addMember(this);
			party = p;
		}
		
		private void voteFor(Candidate c) {
			Results.addVote(c);
		}
		
		@Override
		void display() {
			System.out.printf("Name: %s\nParty: %s\nAge: %d\n", name, party.name, age);
		}
	}
	
	private static class Candidate extends Voter {
		
		Candidate(Voter v, Party p) {
			super(v);
			this.party = p;
		}
	}
	
	private static class Party {
		
		private String name;
		private Candidate candidate;
		private List<Voter> members = new ArrayList<Voter>();
		
		Party(String n) {
			this.name = n;
		}
		
		private void addMember(Voter v) {
			members.add(v);
		}
		
		private void chooseCandidate(Voter v) {
			Candidate c = new Candidate(v, this);
			candidate = c;
			Results.addCandidate(c);
		}
		
		private int getMemberNumber() {
			return members.size();
		}
		
		private void display() {
			System.out.printf("%s\nMembers: %03d     Candidate: ", name, members.size());
			if (candidate != null) 
				System.out.printf("%s\n", candidate.name);
			else {
				System.out.printf("None chosen.\n");
			}
		}
	}
	
	private static class Results {
		private static Map<Candidate, Integer> candidates = new HashMap<Candidate, Integer>();
		private static List<Candidate> podium = new ArrayList<Candidate>();
		private static List<Integer> scores = new ArrayList<Integer>(); 
		
		private static void addCandidate(Candidate c) {
			candidates.put(c, 0);
		}
		
		private static void addVote(Candidate c) {
			int current = candidates.get(c);
			if (c != null)
				candidates.put(c, ++current);
			else
				System.err.println("Attempting to vote for invalid candidate: " + c);
		}
		
		private static List<Candidate> getCandidates() {
			return new ArrayList<Candidate>(candidates.keySet());
		}
		
		private static int getCandidateNumber() {
			return candidates.size();
		}
		
		private static Candidate getWinner() {
			if (podium.size() != 0)
				return podium.get(0);
			else {
				System.err.println("Votes have not been counted yet");
				return null;
			}
		}
		
		private static void countVotes() {
			for (Map.Entry<Candidate, Integer> entry : candidates.entrySet()) {
				if (podium.size() == 0) {
					podium.add(entry.getKey());
					scores.add(entry.getValue());
				}
				else {
					int votes = entry.getValue();
					for (int i = 0; i < podium.size(); i++) {
						if (votes > scores.get(i)) {
							podium.add(i, entry.getKey());
							scores.add(i, votes);
							break;
						} 
						else if (i == podium.size() - 1) {
							podium.add(entry.getKey());
							scores.add(votes);
							break;
						}
					}		
				}
			}
		}
		
		private static void display() {
			Candidate winner = getWinner();
			System.out.println("Winner:");
			winner.display();
			System.out.println("Votes:");
			for (int i = 0; i < podium.size(); i++) {
				Candidate candidate = podium.get(i);
				System.out.printf("%-10s %-7s %5d\n", candidate.name, candidate.party.name, scores.get(i));
			}
		}
	}
	
	private static class City {
		
		private String name;
		private int adults = 0;
		private Section latestSection;
		private List<Person> people = new ArrayList<Person>();
		private List<Section> sections = new ArrayList<Section>();
		
		City(String n) {
			this.name = n;
			this.adults = 0;
		}
		
		private void organizeIntoSections() {
			latestSection = openNewSection();
			people.forEach((person) -> {
				if (person.isAdult()) {
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
		
		private Section openNewSection() {
			return new Section(sections.size() + 1);
		}
		
		private void display() {
			System.out.printf("%s\nPopulation: %d     Adults: %d\n", name, people.size(), adults);
			System.out.println("Sections:");
			displaySections();
		}
		
		private void displaySections() {
			int rowCount = 0;
			for (int i = 0; i < sections.size(); i++) {
				if (++rowCount > 10) {
					rowCount = 0;
					System.out.println();
				}
				Section s = sections.get(i);
				System.out.printf("Section %02d %03d     ", s.number, s.votersNumber());
			}	
			System.out.println();
		}
		
		private int getPopulation() {
			return people.size();
		}
	}
	
	private static class Section {
		
		private int number;
		private static final int sectionSize = 150;
		
		private List<Voter> registeredVoters = new ArrayList<Voter>();
		
		Section(int n) {
			this.number = n;
		}
		
		private void registerVoter(Voter v) {
			if (isFull())
				System.err.println("Registering voter " + v + " to a full voting section.");
			registeredVoters.add(v);
		}
		
		private int votersNumber() {
			return registeredVoters.size();
		}
		
		private boolean isFull() {
			return (registeredVoters.size() >= sectionSize);
		}
		
		private boolean isEmpty() {
			return (registeredVoters.size() == 0);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initCities();
		initParties();
		initSections();
		displayCities();
		randomlyJoinParties();
		randomlyElectPartyCandidates();
		displayParties();
		displayCandidates();
		runElection();
		displayResults();
	}
	
	private static void runElection() {
		voting();
		Results.countVotes();
	}
	
	private static void voting() {
		for (City city : cities) {
			for (Section section : city.sections) {
				for (Voter voter : section.registeredVoters) {
					if (voter.party != null)
						if (voter.CNP == voter.party.candidate.CNP)
							voter.voteFor(voter.party.candidate);
						else
							if (RANDOM.nextDouble() < 0.20)
								voter.voteFor(pickRandomCandidate());
							else 
								voter.voteFor(voter.party.candidate);
					else
						voter.voteFor(pickRandomCandidate());
				}
			}
		}
	}
	
	private static void displayResults() {
		System.out.println("====================   Results  ====================");
		Results.display();
	}
	
	private static void displayCities() {
		System.out.println("====================   Cities   ====================");
		for (City city : cities) {
			city.display();
			System.out.println("----------------------------------------------------");
		}
	}
	
	private static void displayParties() {
		System.out.println("====================   Parties  ====================");
		for (Party party : parties) {
			party.display();
			System.out.println("----------------------------------------------------");
		}
	}
	
	private static void displayCandidates() {
		System.out.println("====================   Candidates  =================");
		for (Candidate candidate : Results.getCandidates()) {
			candidate.display();
			System.out.println("----------------------------------------------------");
		}
	}
	
	private static void initCities() {
		City city = new City("Bucharest");
		initPopulation(city, 1883);
		cities.add(city);
		
		city = new City("Cluj-Napoca");
		initPopulation(city, 324);
		cities.add(city);
		
		city = new City("Timisoara");
		initPopulation(city, 319);
		cities.add(city);
		
		city = new City("Iasi");
		initPopulation(city, 290);
		cities.add(city);
		
		city = new City("Constanta");
		initPopulation(city, 283);
		cities.add(city);
	}
	
	private static void initPopulation(City city, int population) {
		for (int i = 0; i < population; i++) {
			Person person = initPerson();
			if (person.isAdult())
				city.adults++;
			city.people.add(person);
		}
	}

	private static void initParties() {
		int totalPopulation = 0;
		
		for (City city : cities) {
			totalPopulation += city.getPopulation();
		}
		
		for (int i = 0; i < totalPopulation / 500; i++) {
			parties.add(initParty());
		}
	}
	
	private static void initSections() {
		for (City city : cities) {
			city.organizeIntoSections();
		}
	}
	
	private static Party initParty() {
		return new Party("Party" + RANDOM.nextInt(25));
	}
	
	private static Person initPerson() {
		return new Person(randomName(), randomCNP(), randomInt(115));
	}
	
	private static void randomlyJoinParties() {
		for (City city : cities) {
			for (Section section : city.sections) {
				for (Voter voter : section.registeredVoters) {
					if (RANDOM.nextDouble() < 0.05) {
						voter.joinParty(pickRandomParty());
					}
				}
			}
		}
	}
	
	private static Party pickRandomParty() {
		return parties.get(RANDOM.nextInt(parties.size()));
	}
	
	private static void randomlyElectPartyCandidates() {
		for (Party party : parties) {
			party.chooseCandidate(pickRandomVoter(party));
		}
	}
	
	private static Voter pickRandomVoter(Party party) {
		return party.members.get(RANDOM.nextInt(party.getMemberNumber()));
	}
	
	private static Candidate pickRandomCandidate() {
		return Results.getCandidates().get(randomInt(Results.getCandidateNumber()));
	}
	
	private static String randomName() {
		return "Person" + randomInt(1000);
	}
	
	private static int randomInt(int n) {
		return RANDOM.nextInt(n);
	}
	
	private static String randomCNP() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 13);
	}
}
