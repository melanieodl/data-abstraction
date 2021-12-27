import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerSetTest {

    private IntegerSet testSet;

    @BeforeEach
    void setUp() {
        testSet = new IntegerSet();
    }

    @Test
    void testInsertNotThere(){
        checkSetEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOne(3);
    }

    @Test
    void testInsertAlreadyThere(){
        checkSetEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOne(3);
        testSet.insert(3);
        checkSetContainsOne(3);
    }

    private void checkSetContainsOne(int num){
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(num));
    }

    private void checkSetEmptyDoesntContain(int num){
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(num));
    }


}