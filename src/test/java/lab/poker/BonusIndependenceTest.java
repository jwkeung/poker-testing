package lab.poker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonusIndependenceTest {
    private boolean bonus(String hand) {
        return new BonusPolicy().qualifies(Hands.of(hand));
    }

    // Add an independence test here.

    // BY STUDENT #1 HERE : 
    @Test void bChangesDecision() {
        assertTrue(bonus("2H 3H 4H 5H 6H"));
        assertFalse(bonus("2C 3D 4H 5S 6C"));
    }

}
