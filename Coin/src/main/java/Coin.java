import java.util.Random;

/**
 * Abstranction of a coin
 */
public class Coin {

    boolean isCoicFaceUp = true;

    /**
     * Simulates the flip of the coin, setting the coin to "heads" or "tails" at random.
     */
    public void flip(){
        isCoicFaceUp = new Random().nextBoolean();
    }

    /**
     * Returns this coin's status.
     * @return status as either "heads" or "tails".
     */
    public String checkStatus(){
        return isCoicFaceUp ? "heads" : "tails";
    }
}
