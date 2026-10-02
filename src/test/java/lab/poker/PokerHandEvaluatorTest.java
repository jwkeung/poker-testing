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
    @Test void straightFlush() {
        assertEquals(STRAIGHT_FLUSH, evaluator.classify(Hands.of("2H 3H 4H 5H 6H")));
    }
    @Test void fourOfAKind() {
        assertEquals(FOUR_OF_A_KIND, evaluator.classify(Hands.of("7C 7D 7H 7S 9C")));
    }
    @Test void threeOfAKind() {
        assertEquals(THREE_OF_A_KIND, evaluator.classify(Hands.of("7C 7D 7H 9S 10C")));
    }
    @Test void twoPair() {
        assertEquals(TWO_PAIR, evaluator.classify(Hands.of("7C 7D 9H 9S 10C")));
    }
    @Test void onePair() {
        assertEquals(ONE_PAIR, evaluator.classify(Hands.of("7C 7D 9H 4S 10C")));
    }
    @Test void highCard() {
        assertEquals(HIGH_CARD, evaluator.classify(Hands.of("2C 5D 8H JS KC")));
    }

    @Test void isStraightWheel() {
        assertTrue(evaluator.isStraight(Hands.of("2C 3D 4H 5S AC")));
    }
    @Test void isStraightWheelRank0NotTwo() {
        assertFalse(evaluator.isStraight(Hands.of("3C 4D 5H 6S AC")));
    }
    @Test void isStraightWheelRank1NotThree() {
        assertFalse(evaluator.isStraight(Hands.of("2C 4D 5H 6S AC")));
    }
    @Test void isStraightWheelRank2NotFour() {
        assertFalse(evaluator.isStraight(Hands.of("2C 3D 5H 6S AC")));
    }
    @Test void isStraightWheelRank3NotFive() {
        assertFalse(evaluator.isStraight(Hands.of("2C 3D 4H 6S AC")));
    }
    @Test void isStraightWheelRank4NotAce() {
        assertFalse(evaluator.isStraight(Hands.of("2C 3D 4H 5S KC")));
    }
    @Test void isStraightConsecutive() {
        assertTrue(evaluator.isStraight(Hands.of("6C 2D 5H 3S 4C")));
    }
    @Test void isStraightNonConsecutive() {
        assertFalse(evaluator.isStraight(Hands.of("2C 5D 8H JS KC")));
    }

    @Test void isFlushTrue() {
        assertTrue(evaluator.isFlush(Hands.of("2H 5H 8H JH KH")));
    }
    @Test void isFlushLastDiffers() {
        assertFalse(evaluator.isFlush(Hands.of("2H 3H 4H 5H 6D")));
    }
    @Test void isFlushMiddleDiffers() {
        assertFalse(evaluator.isFlush(Hands.of("2H 3D 4H 5H 6H")));
    }

    @Test void isFullHouseTrue() {
        assertTrue(evaluator.isFullHouse(Hands.of("7C 7D 7H 9S 9C")));
    }
    @Test void isFullHouseThreeOnly() {
        assertFalse(evaluator.isFullHouse(Hands.of("7C 7D 7H 9S 10C")));
    }
    @Test void isFullHouseTwoOnly() {
        assertFalse(evaluator.isFullHouse(Hands.of("7C 7D 9H 9S 10C")));
    }
}
