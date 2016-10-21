package com.edocti.jintro.hw1.election;
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
	private static final int PARTY_RATIO = 500000;
	private static final Random RANDOM = new Random();
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * Collects election results.
	 * @author manciul
	 */
	public static class Results {
		private static Map<Candidate, Integer> candidates = new HashMap<Candidate, Integer>();
		private static List<Candidate> podium = new ArrayList<Candidate>();
		private static List<Integer> scores = new ArrayList<Integer>(); 
		
		/**
		 * Registers a new candidate with 0 votes.
		 * @param c {@link Candidate} to be registered in the election.
		 */
		public static void addCandidate(Candidate c) {
			candidates.put(c, 0);
		}
		
		/**
		 * Record a new vote for a registered candidate.
		 * @param c {@link Candidate} to be given a new vote to.
		 */
		public static void addVote(Candidate c) {
			int current = candidates.get(c);
			if (c != null)
				candidates.put(c, ++current);
			else
				System.err.println("Attempting to vote for invalid candidate: " + c);
		}
		
		/**
		 * Return the list of candidates competing in the election.
		 * @return <code>ArrayList</code> of {@link Candidate candidates} registered in the election.
		 */
		private static List<Candidate> getCandidates() {
			return new ArrayList<Candidate>(candidates.keySet());
		}
		
		/**
		 * Return the number of currently registered candidates.
		 * @return <code>int</code> number of registered candidates.
		 */
		private static int getCandidateNumber() {
			return candidates.size();
		}
		
		/**
		 * Get the winning candidate after votes have been counted.
		 * @return the winning {@link Candidate}.
		 */
		private static Candidate getWinner() {
			if (podium.size() != 0)
				return podium.get(0);
			else {
				System.err.println("Votes have not been counted yet");
				return null;
			}
		}
		
		/**
		 * Sort candidates by vote count into ordered lists: podium and scores.
		 */
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
		
		/**
		 * Display election results.
		 */
		private static void display() {
			Candidate winner = getWinner();
			System.out.println("Winner:");
			winner.display();
			System.out.println();
			System.out.println("Votes:");
			for (int i = 0; i < podium.size(); i++) {
				Candidate candidate = podium.get(i);
				System.out.printf("%-24s %-7s %5d\n", candidate.name, candidate.party.name, scores.get(i));
			}
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
		for (City city : cities)
			for (Section section : city.getSections())
				for (Voter voter : section.getRegisteredVoters())
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
	
	private static void displayResults() {
		System.out.println("====================   Results  ======================");
		Results.display();
	}
	
	private static void displayCities() {
		System.out.println("====================   Cities   ======================");
		for (City city : cities) {
			city.display();
			System.out.println("------------------------------------------------------");
		}
	}
	
	private static void displayParties() {
		System.out.println("====================   Parties  ======================");
		for (Party party : parties) {
			party.display();
			System.out.println("------------------------------------------------------");
		}
	}
	
	private static void displayCandidates() {
		System.out.println("====================   Candidates  ===================");
		for (Candidate candidate : Results.getCandidates()) {
			candidate.display();
			System.out.println("------------------------------------------------------");
		}
	}
	
	private static void initCities() {
		City city = new City("Bucharest");
		initPopulation(city, 1883000);
		cities.add(city);
		
		city = new City("Cluj-Napoca");
		initPopulation(city, 324000);
		cities.add(city);
		
		city = new City("Timisoara");
		initPopulation(city, 319000);
		cities.add(city);
		
		city = new City("Iasi");
		initPopulation(city, 290000);
		cities.add(city);
		
		city = new City("Constanta");
		initPopulation(city, 283000);
		cities.add(city);
	}
	
	private static void initPopulation(City city, int population) {
		for (int i = 0; i < population; i++)
			city.newInhabitant(initPerson());
	}

	private static void initParties() {
		int totalPopulation = 0;
		
		for (City city : cities)
			totalPopulation += city.getPopulation();
		
		for (int i = 0; i < totalPopulation / PARTY_RATIO; i++)
			parties.add(initParty());
	}
	
	private static void initSections() {
		for (City city : cities)
			city.organizeIntoSections();
	}
	
	private static Party initParty() {
		return new Party(randomWord(3).toUpperCase());
	}
	
	private static Person initPerson() {
		return new Person(randomName(), randomCNP(), randomInt(115));
	}
	
	private static void randomlyJoinParties() {
		for (City city : cities)
			for (Section section : city.getSections())
				for (Voter voter : section.getRegisteredVoters())
					if (RANDOM.nextDouble() < 0.05)
						voter.joinParty(pickRandomParty());
	}
	
	private static Party pickRandomParty() {
		return parties.get(RANDOM.nextInt(parties.size()));
	}
	
	private static void randomlyElectPartyCandidates() {
		for (Party party : parties)
			party.chooseCandidate(pickRandomMember(party));
	}
	
	private static Voter pickRandomMember(Party party) {
		return party.getMembers().get(RANDOM.nextInt(party.getMembersNumber()));
	}
	
	private static Candidate pickRandomCandidate() {
		return Results.getCandidates().get(randomInt(Results.getCandidateNumber()));
	}
	
	private static String randomName() {
		return randomUppercaseWord(randomInt(5) + 3) + " " + randomUppercaseWord(randomInt(10) + 3);
	}
	
	private static int randomInt(int n) {
		return RANDOM.nextInt(n);
	}
	
	private static String randomCNP() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 13);
	}
	
	private static String randomWord(int n) {
		String word = "";
		for (int i = 0; i < n; i++)
			word += ALPHABET.charAt(randomInt(ALPHABET.length()));
		return word;
	}
	
	private static String randomUppercaseWord(int n) {
		String word = randomWord(n);
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}
	
	/**
	 * @return the voting age.
	 */
	public static int getVotingAge() {
		return VOTING_AGE;
	}
}
