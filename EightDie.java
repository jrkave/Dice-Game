package mypack;
import java.util.Random;

public class EightDie extends MyDie implements Comparable {

    public EightDie() {
        // set default values
        myValue = (int) (Math.random()*8)+1;
        rand = new Random();
    }

    public void roll () {
        myValue = rand.nextInt(8) + 1;
    }

    public int getValue() {
        return myValue;
    }

    // set the random number generator seed for testing
    public void setSeed(int seed) {
        rand.setSeed(seed);

    }

    // allows dice to be compared if necessary
    public int compareTo(Object o) {
        EightDie d = (EightDie) o;
        return getValue() - d.getValue();
    }

}
