package com.qa.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private int totalGamesPlayed;
	private int cpuWins;
	private int humanWins;
	private int ties;

	private Random rand = new Random();
//    • Most commonly picked (rock/paper/scissors) + number and percentage

	public RPS getCPUMove() {
		switch (rand.nextInt(3)) {
		case 2:
			return RPS.ROCK;
		case 1:
			return RPS.PAPER;
		case 0:
			return RPS.SCISSORS;
		}
		return null;
	}

	public String playRound(Scanner s) {
		RPS playerMove = null;
		do {
			System.out.println("Please choose rock, paper or scissors:");
			playerMove = getPlayerMove(s.nextLine());
		} while (playerMove == null);
		RPS cpuMove = getCPUMove();
		System.out.println("CPU chooses: " + cpuMove);
		String outcome = getWinner(cpuMove, playerMove);
		return outcome;
	}

	public String getWinner(RPS cpuMove, RPS playerMove) {
		switch (cpuMove) {
		case ROCK:
			switch (playerMove) {
			case ROCK:
				return recordRound(Outcome.TIE);
			case PAPER:
				return recordRound(Outcome.PLAYER_WIN);
			case SCISSORS:
				return recordRound(Outcome.CPU_WIN);
			}
		case PAPER:
			switch (playerMove) {
			case ROCK:
				return recordRound(Outcome.CPU_WIN);
			case PAPER:
				return recordRound(Outcome.TIE);
			case SCISSORS:
				return recordRound(Outcome.PLAYER_WIN);
			}
		case SCISSORS:
			switch (playerMove) {
			case ROCK:
				return recordRound(Outcome.PLAYER_WIN);
			case PAPER:
				return recordRound(Outcome.CPU_WIN);
			case SCISSORS:
				return recordRound(Outcome.TIE);
			}
		}
		return null;
	}

	private String recordRound(Outcome cpuWin) {
		this.totalGamesPlayed++;
		switch (cpuWin) {
		case PLAYER_WIN:
			this.humanWins++;
			return "Player wins!";
		case CPU_WIN:
			this.cpuWins++;
			return "CPU wins!";
		case TIE:
			this.ties++;
			return "Nobody wins!";
		}
		return null;
	}

	public RPS getPlayerMove(String choice) {
		switch (choice.toLowerCase()) {
		case "rock":
			return RPS.ROCK;
		case "paper":
			return RPS.PAPER;
		case "scissors":
			return RPS.SCISSORS;
		default:
			return null;
		}
	}

	public void start() {
		Scanner s = new Scanner(System.in);
		boolean play = true;
		do {
			System.out.println(playRound(s));
			System.out.println("Enter 'q' to quit or anything else to continue: ");
			play = checkContinue(s.nextLine());
		} while (play);
		System.out.println(this.toString());
	}

	private boolean checkContinue(String choice) {
		return !choice.equalsIgnoreCase("q");
	}

	@Override
	public String toString() {
		return "Game [totalGamesPlayed=" + totalGamesPlayed + ", cpuWins=" + cpuWins + ", humanWins=" + humanWins
				+ ", ties=" + ties + "]";
	}

}
