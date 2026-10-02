package lab.poker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BonusPolicyTest {
    private final BonusPolicy policy = new BonusPolicy();
    @Test void straightFlushQualifies() {
        assertTrue(policy.qualifies(Hands.of("2H 3H 4H 5H 6H")));
    }
    @Test void highCardDoesNotQualify() {
        assertFalse(policy.qualifies(Hands.of("2C 5D 8H JS KC")));
    }
    @Test void fullHouseQualifies() {
        assertTrue(policy.qualifies(Hands.of("7C 7D 7H 9S 9C")));
    }
    @Test void flushDoesNotQualify() {
        assertFalse(policy.qualifies(Hands.of("2H 5H 8H JH KH")));
    }
    @Test void straightDoesNotQualify() {
        assertFalse(policy.qualifies(Hands.of("6C 2D 5H 3S 4C")));
    }
}
