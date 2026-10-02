package lab.poker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonusIndependenceTest {
    private boolean bonus(String hand) {
        return new BonusPolicy().qualifies(Hands.of(hand));
    }

    // Add an independence test here.
    // STUDENT #2 : ALSO WORKING ON ADDITIONAL TESTS FOR BONUS POLICY
    @Test void cChangesDecision() {
        assertFalse(bonus("2C 5D 8H JS KC"));
        assertTrue(bonus("7C 7D 7H 9S 9C"));
    }



    // BY STUDENT #1 HERE : 
    @Test void bChangesDecision() {
        assertTrue(bonus("2H 3H 4H 5H 6H"));
        assertFalse(bonus("2C 3D 4H 5S 6C"));
    }

}
