package com.edocti.jintro.hw1;
import java.io.*;
import java.util.Random;

/**
 * Implement an event generator and see how the execution can be modeled / modified by simply adding / removing / updating the transition table.
 * This is far more elegant than maintaining a long list of conditional statements.
 * @author manciul
 */
public class StateMachine {
	
	private CustomerSatisfaction satisfaction;
	private static final Random RANDOM = new Random();
	private static final int eventSize = ProjectEvent.values().length;
	
	public StateMachine() {
		satisfaction = CustomerSatisfaction.UNPLEASED;
	}
	
	enum CustomerSatisfaction {
		PLEASED, SATISFIED, UNPLEASED, FURIOUS;
		
		public void status() {
			System.out.println("I am " + name().toLowerCase() + ".\n");
		}	
	}
	
	enum ProjectEvent {
		ISSUE_SOLVED,
		ELEGANT_SOLUTION,
		SOLUTION_INTRODUCED_BUGS,
		NASTY_WORKAROUND;
		
		/**
		 * Print ProjectEvent name to standard output
		 */
		public void status() {
			System.out.println("A " + name().toLowerCase() + " occurred.");
		}
	}
		
	public enum ProjectTransitions {
		T1(CustomerSatisfaction.PLEASED,   ProjectEvent.ISSUE_SOLVED,             CustomerSatisfaction.SATISFIED),
		T2(CustomerSatisfaction.PLEASED,   ProjectEvent.NASTY_WORKAROUND,         CustomerSatisfaction.UNPLEASED),
		T3(CustomerSatisfaction.PLEASED,   ProjectEvent.SOLUTION_INTRODUCED_BUGS, CustomerSatisfaction.FURIOUS),
		
		T4(CustomerSatisfaction.SATISFIED, ProjectEvent.NASTY_WORKAROUND,         CustomerSatisfaction.PLEASED),
		T5(CustomerSatisfaction.SATISFIED, ProjectEvent.SOLUTION_INTRODUCED_BUGS, CustomerSatisfaction.UNPLEASED),
		
		T6(CustomerSatisfaction.UNPLEASED, ProjectEvent.ISSUE_SOLVED,             CustomerSatisfaction.SATISFIED),
		T7(CustomerSatisfaction.UNPLEASED, ProjectEvent.ELEGANT_SOLUTION,         CustomerSatisfaction.PLEASED),
		T8(CustomerSatisfaction.UNPLEASED, ProjectEvent.NASTY_WORKAROUND,         CustomerSatisfaction.FURIOUS),
		T9(CustomerSatisfaction.UNPLEASED, ProjectEvent.SOLUTION_INTRODUCED_BUGS, CustomerSatisfaction.FURIOUS),
		
		T10(CustomerSatisfaction.FURIOUS,  ProjectEvent.ELEGANT_SOLUTION,         CustomerSatisfaction.UNPLEASED),
		T11(CustomerSatisfaction.FURIOUS,  ProjectEvent.ISSUE_SOLVED,             CustomerSatisfaction.PLEASED);
		
		private CustomerSatisfaction current, next;
		private ProjectEvent event;
		
		ProjectTransitions(CustomerSatisfaction current, ProjectEvent event, CustomerSatisfaction next) {
			this.current = current;
			this.event = event;
			this.next = next;
		}
		
		/**
		 * Search the next state in the transition table
		 * @param current current @link CustomerSatisfaction
		 * @param event event from @link ProjectEvent which has occurred
		 * @return <code>CustomerSatisfaction</code> that has been transitioned to
		 */
		public static CustomerSatisfaction next(CustomerSatisfaction current, ProjectEvent event) {
			for(ProjectTransitions t : ProjectTransitions.values()) {
				if (t.current == current && t.event == event)
					return t.next;
			}
			return current; // in case there is no transition
		}
	}
	
	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		StateMachine machine = new StateMachine();
		machine.satisfaction.status();
		int n = getInput();	
		while (n-- > 0) {
			triggerEvent(machine);
			machine.satisfaction.status();
		}
		System.out.println("Finished");
	}

	/**
	 * Trigger an event at random on the given @link StateMachine
	 * @param machine
	 */
	private static void triggerEvent(StateMachine machine) {
		ProjectEvent event = randomEvent();
		event.status();
		machine.satisfaction = ProjectTransitions.next(machine.satisfaction, event);
	}
	
	/**
	 * Pick a random event from @link ProjectEvent
	 * @return random <code>ProjectEvent</code>
	 */
	private static ProjectEvent randomEvent() {
		return ProjectEvent.values()[(RANDOM.nextInt(eventSize))];
	}
	
	/**
	 * Get user input from standard input
	 * @return <code>int</code> number of events to generate
	 * @throws IllegalArgumentException if number of events is less than 0
	 */
	private static int getInput() {
		
		int x = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Number of events to generate:");
		
		try {
			x = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Reading user input failed: " + e.getMessage());
		} catch(NumberFormatException e) {
			System.out.println("Input was not a number: " + e.getMessage());
		}
		
		if (x < 0)
			throw new IllegalArgumentException("Illegal argument");

		return x;
	}
}
