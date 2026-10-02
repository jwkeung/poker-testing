package lab.poker;
import java.util.List;
import java.util.ArrayList;
import static lab.poker.Card.Suit.*;

final class Hands {
    private Hands() { }
    static List<Card> of(String text) {
        List<Card> hand = new ArrayList<>();
        for (String token : text.split(" ")) {
            String rankText = token.substring(0, token.length() - 1);
            int rank = switch (rankText) {
                case "J" -> 11; case "Q" -> 12; case "K" -> 13; case "A" -> 14;
                default -> Integer.parseInt(rankText);
            };
            Card.Suit suit = switch (token.charAt(token.length() - 1)) {
                case 'C' -> CLUBS; case 'D' -> DIAMONDS;
                case 'H' -> HEARTS; case 'S' -> SPADES;
                default -> throw new IllegalArgumentException(token);
            };
            hand.add(new Card(rank, suit));
        }
        return hand;
    }
}
