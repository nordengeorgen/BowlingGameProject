package Game;

import Game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGame {

    //Tests to do:
    //Gutter game = all zeroes, (score = 0)
    //One pin down in each roll, (score = 20)
    //Spare in first roll, one pin down in each other roll, (score = 10 + 1 + 18 = 29)
    //Spare in last roll, one pin down in each other roll, (score = 18 + 10 + 1 = 29)
    //Strike in first roll, one pin down in each other roll, (score = 10 + 1 + 1 + 18 = 30)
    //Strike in last roll, one pin down in each other roll, (score = 18 + 10 + 1 + 1 = 30)
    //Golden game = all strikes (score = 300)

    private Game game = new Game();

    @Test
    public void Zero(){
        game.roll(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertEquals(game.getScore(), 0);
    }

    @Test
    public void OnlyOnes(){
        game.roll(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertEquals(game.getScore(), 20);
    }

    @Test
    public void isSpareFirstRoll(){
        game.roll(5,5,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertEquals(game.getScore(), 28);
    }

    @Test
    public void isSpareLastRoll(){
        game.roll(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,4);
        assertEquals(game.getScore(), 36);
    }

    @Test
    public void isStrikeFirstRoll(){
        game.roll(10,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertEquals(game.getScore(), 30);
    }

    @Test
    public void isStrikeLastRoll(){
        game.roll(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,10,0,4);
        assertEquals(game.getScore(), 36);
    }

    @Test
    public void isPerfectGame(){
        game.roll(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0);
        assertEquals(game.getScore(), 300);
    }
 }
