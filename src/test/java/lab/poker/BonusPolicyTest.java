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
}
