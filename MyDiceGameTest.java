package mypack;

import static org.junit.Assert.*;
import org.junit.*;

/*******************************************
 * The test class for Chuck
 *
 * @author Resendiz
 * @version February 2021
 ******************************************/

public class MyDiceGameTest {

    /******************************************************
     * Test initial values of the constructor
     *****************************************************/
    @Test
    public void testConstructor() {
        GameManager game = new GameManager(6);
        int credits = game.getDice().getCredits();

        // confirm there is only one copy of Title 1
        Assert.assertEquals("Game should start with 10 credits",
                credits, 10);
    }

    /******************************************************
     * Test Large
     *****************************************************/
    @Test
    public void testLarge() {
        // confirm large is rolled
        GameManager game = new GameManager(6);
        int credits = game.getDice().getCredits();
        game.getDice().testRoll(new int[]{6, 4, 5});
        game.getDice().checkLarge();
        Assert.assertEquals("Dice => (6,4,5): credits should stay the same",
                game.getDice().getCredits(), credits);

        // confirm large is not rolled
        GameManager game2 = new GameManager(6);
        credits = game2.getDice().getCredits();
        game2.getDice().testRoll(new int[]{1, 2, 3});
        game2.getDice().checkLarge();
        Assert.assertEquals("Dice => (1,2,3): credits should decrease by one",
                game2.getDice().getCredits(), credits - 1);



    }

        /******************************************************
         * Test Doubles
         *****************************************************/
        @Test
        public void testDoubles() {
            // confirm doubles is rolled. 1st Combo
            GameManager game = new GameManager(6);
            int credits = game.getDice().getCredits();
            game.getDice().testRoll(new int[]{1, 1, 2});
            game.getDice().checkDoubles();
            Assert.assertEquals("Dice => (1,1,2): credits should stay the same",
                    game.getDice().getCredits(), credits);

            // confirm doubles is rolled. 2nd Combo
            GameManager game2 = new GameManager(6);
            int credits2 = game2.getDice().getCredits();
            game2.getDice().testRoll(new int[]{2, 1, 1});
            game2.getDice().checkDoubles();
            Assert.assertEquals("Dice => (1,1,1): credits should stay the same",
                    game2.getDice().getCredits(), credits2);

        }

    /******************************************************
     * Test Combination of Points Awarded
     *****************************************************/

        @Test
        public void testCombinations(){
            // confirm large and double are called
            GameManager game = new GameManager(6);
            int credits = game.getDice().getCredits();
            game.getDice().testRoll(new int[]{6, 6, 3});
            game.getDice().checkDoubles();
            game.getDice().checkLarge();
            Assert.assertEquals("Dice => (6,6,3): credits should increase by one",
                    game.getDice().getCredits(), credits + 1);

            // confirm large, triplets and doubles are given points
            GameManager game3 = new GameManager(6);
            credits = game3.getDice().getCredits();
            game3.getDice().testRoll(new int[]{4, 4, 4});
            game3.getDice().checkLarge();
            game3.getDice().checkTriplets();
            game3.getDice().checkDoubles();
            Assert.assertEquals("Dice => (4,4,4): credits should increased by two",
                    game3.getDice().getCredits(), credits + 2);

            // confirm triplets and doubles are called but not large
            GameManager game4 = new GameManager(6);
            credits = game4.getDice().getCredits();
            game4.getDice().testRoll(new int[]{3, 3, 3});
            game4.getDice().checkLarge();
            game4.getDice().checkTriplets();
            game4.getDice().checkDoubles();
            Assert.assertEquals("Dice => (3,3,3): credits should increase by one",
                    game4.getDice().getCredits(), credits+1);


        }
}