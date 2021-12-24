import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    private Coin coin;

    @BeforeEach
    void setUp() {
        coin = new Coin();
    }

    @Test
    @DisplayName("flip produces both heads and tails when executed 10 times or less")
    void flipHeadAndTails() {
        int timesChanges = 0;
        String lastStatus = "heads";
        for (int i = 0; i < 10 ; i++) {
            coin.flip();
            String status = coin.checkStatus();

            if(!lastStatus.equals(status)) {
                timesChanges++;
                lastStatus = status;
            }
        }
        assertNotEquals(0, timesChanges);
    }

    @Test
    @DisplayName("flip produces both heads and tails when executed > 10 times")
    void testFlipRandomness() {
        String lastStatus = "heads";
        int longestRunOfSameAnswer = 0;
        int currentRun = 0;
        for (int i = 0; i < 100 ; i++) {
            coin.flip();
            String status = coin.checkStatus();
            if (lastStatus.equals(status)){
                currentRun++;
                if (currentRun > longestRunOfSameAnswer){
                    longestRunOfSameAnswer = currentRun;
                }
            } else {
                lastStatus = status;
                currentRun = 0;
            }
        }

        assertFalse(longestRunOfSameAnswer > 10);
    }
}