package lab.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static lab.poker.HandType.*;

/** Evaluate five distinct cards. See README.md for the rules. */
public class PokerHandEvaluator {
    public HandType classify(List<Card> hand) {
        boolean straight = isStraight(hand);
        boolean flush = isFlush(hand);
        Map<Integer, Integer> counts = rankCounts(hand);
        if (straight && flush) return STRAIGHT_FLUSH;
        if (counts.containsValue(4)) return FOUR_OF_A_KIND;
        if (isFullHouse(hand)) return FULL_HOUSE;
        if (flush) return FLUSH;
        if (straight) return STRAIGHT;
        if (counts.containsValue(3)) return THREE_OF_A_KIND;
        long pairs = counts.values().stream().filter(n -> n == 2).count();
        if (pairs == 2) return TWO_PAIR;
        if (pairs == 1) return ONE_PAIR;
        return HIGH_CARD;
    }

    public boolean isStraight(List<Card> hand) {
        int[] ranks = hand.stream().mapToInt(Card::rank).sorted().toArray();
        if (ranks[0] == 2 && ranks[1] == 3 && ranks[2] == 4
                && ranks[3] == 5 && ranks[4] == 14) return true;
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] != ranks[i - 1] + 1) return false;
        }
        return true;
    }

    public boolean isFlush(List<Card> hand) {
        Card.Suit suit = hand.get(0).suit();
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).suit() != suit) return false;
        }
        return true;
    }

    public boolean isFullHouse(List<Card> hand) {
        Map<Integer, Integer> counts = rankCounts(hand);
        return counts.containsValue(3) && counts.containsValue(2);
    }

    private Map<Integer, Integer> rankCounts(List<Card> hand) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Card card : hand) {
            counts.merge(card.rank(), 1, Integer::sum);
        }
        return counts;
    }
}
