import java.util.Random;

/**
 * Abstranction of a coin
 */
public class Coin {


    /**
     * Simulates the flip of the coin, setting the coin to "heads" or "tails" at random.
     */
    public void flip(){

    }

    /**
     * Returns this coin's status.
     * @return status as either "heads" or "tails".
     */
    public String checkStatus(){
        return "heads";
    }
}
