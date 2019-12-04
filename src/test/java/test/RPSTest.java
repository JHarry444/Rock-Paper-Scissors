package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.rps.Game;
import com.qa.rps.Outcome;
import com.qa.rps.RPS;

public class RPSTest {

	private Game game;
	
	@Before
	public void setup() {
		this.game = new Game();
	}
	
	@Test
	public void testValidCPUMove() {
		List<RPS> validMoves = Arrays.asList(new RPS[] {RPS.ROCK, RPS.PAPER,RPS.SCISSORS});
		assertTrue("CPU has chosen an invalid move", validMoves.contains(this.game.getCPUMove()));
	}
	
	@Test
	public void testGetWinner() {
		assertEquals(Outcome.PLAYER_WIN, this.game.getWinner(RPS.ROCK, RPS.PAPER));
	}
	
}
