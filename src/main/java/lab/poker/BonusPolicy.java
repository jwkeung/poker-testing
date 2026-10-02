package lab.poker;
import java.util.List;

/** House rule: a straight flush or a full house earns a bonus. */
public class BonusPolicy {
    private final PokerHandEvaluator evaluator = new PokerHandEvaluator();
    public boolean qualifies(List<Card> hand) {
        boolean a = evaluator.isStraight(hand);
        boolean b = evaluator.isFlush(hand);
        boolean c = evaluator.isFullHouse(hand);
        return (a && b) || c;
    }
}
