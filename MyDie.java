package mypack;
import java.util.Random;

public abstract class MyDie {
    protected int myValue;
    protected Random rand;

    public MyDie() {
        myValue = -1;
    }

    abstract public void roll ();
    abstract public int getValue();
    abstract public void setSeed(int seed);
    abstract public int compareTo(Object o);


}