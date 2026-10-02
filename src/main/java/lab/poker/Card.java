package lab.poker;

/** A card has a rank from 2 to 14 (Ace) and a suit. */
public record Card(int rank, Suit suit) {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
}
