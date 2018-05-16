import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;


public class BowlingTest {

    private Bowling bowling;

    @Before
    public void setUp() {
        bowling = new Bowling();
    }

    @Test
    public void canScoreGameOfZeros(){
        roll(20, 0);
        assertEquals(0, bowling.score());
    }

    @Test
    public void canScoreGameOfOnes(){
        roll(20, 1);
        assertEquals(10, bowling.score());
    }

    @Test
    public void canScoreSpareFollowedByThree() {
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(3);
        assertEquals(bowling.score(), 16);
    }

    @Test
    public void canScoreGameOfFivesAndOneAtTheEnd() {
        roll(19, 5);
        bowling.roll(1);
        assertEquals(141, bowling.score());
    }

    @Test
    public void canRollGameOfSpares() {
        roll(21, 5);
    }

    @Test
    public void canScoreGameOfSpares() {
        roll(21, 5);
        assertEquals(bowling.score(), 150);
    }


    @Test
    public void canScoreStrikeFollowedByThreeAndFour() {
        bowling.roll(10);
        bowling.roll(3);
        bowling.roll(4);
        assertEquals(bowling.score(), 24);
    }

    @Test
    public void canScoreGameOfTensAndOneAtTheEnd() {
        roll(19, 5);
        bowling.roll(1);
        assertEquals(141, bowling.score());
    }

    @Test
    public void canScoreGameOfStrikes() {
        roll(22, 10);
        assertEquals(bowling.score(), 300);
    }

    private void roll(int times, int pinsShooted) {
        for(int i = 0; i< times; i++) {
            bowling.roll(pinsShooted);
        }
    }



}