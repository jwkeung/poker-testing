package lab.poker;
import org.junit.jupiter.api.Test;
import static lab.poker.HandType.*;
import static org.junit.jupiter.api.Assertions.*;
class PokerHandEvaluatorTest {
    private final PokerHandEvaluator evaluator = new PokerHandEvaluator();
    @Test void straight() {
        assertEquals(STRAIGHT, evaluator.classify(Hands.of("6C 2D 5H 3S 4C")));
    }
    @Test void flush() {
        assertEquals(FLUSH, evaluator.classify(Hands.of("2H 5H 8H JH KH")));
    }
    @Test void fullHouse() {
        assertEquals(FULL_HOUSE, evaluator.classify(Hands.of("7C 7D 7H 9S 9C")));
    }
}
