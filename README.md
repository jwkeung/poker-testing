## Program and rules
This is the W4 five-card evaluator with its previous three defects repaired.
A hand contains five distinct physical cards, in any order. Ranks are 2..14
(J=11, Q=12, K=13, A=14); suits are CLUBS, DIAMONDS, HEARTS, SPADES.
Do not modify the hand. Inputs are non-null and valid; invalid-input handling
is outside this exercise.

The strongest category wins, in this order:
STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT,
THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD.
A straight has five distinct consecutive ranks. A-2-3-4-5 and 10-J-Q-K-A are
allowed; Q-K-A-2-3 is not. A flush has five equal suits. A full house has rank
counts 3 and 2. Three of a kind has counts 3,1,1; two pair 2,2,1;
one pair 2,1,1,1. Four of a kind has counts 4,1.

## New bonus rule
BonusPolicy.qualifies returns true for a straight flush OR a full house.
Let A = isStraight(hand), B = isFlush(hand), C = isFullHouse(hand).
The required decision is P = (A && B) || C. The implementation may be wrong.
Examples (rank then suit; C/D/H/S mean clubs/diamonds/hearts/spades):
- 2H 3H 4H 5H 6H -> true (straight flush)
- 7C 7D 7H 9S 9C -> true (full house)
- 2C 3D 4H 5S 6C -> false (straight only)
- 2H 5H 8H JH KH -> false (flush only)
- 2C 5D 8H JS KC -> false (high card)


## Files
src/main/java/lab/poker: Card, HandType, PokerHandEvaluator and BonusPolicy.
src/test/java/lab/poker: initial tests and Hands.of("2C 3D 4H 5S 6C") helper.
docs/predicate-table.csv: fill expected P and feasible hands by hand first.
BonusIndependenceTest.java: an empty class reserved for the later Git exercise.
Leave it unchanged until the slides ask you to add the B or C test.
