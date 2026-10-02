package lab.poker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonusIndependenceTest {
    private boolean bonus(String hand) {
        return new BonusPolicy().qualifies(Hands.of(hand));
    }

    // Add an independence test here.
}
