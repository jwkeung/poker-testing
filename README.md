# Poker Testing

Five-card poker hand evaluator with a bonus policy, built as a testing exercise.
Version **1.1.0**.

## Project overview

| Item | Value |
|------|-------|
| Purpose | Test a five-card poker hand evaluator and its bonus policy |
| Language | Java 17 |
| Build tool | Maven |
| Test framework | JUnit 5 (Jupiter) |
| Coverage tool | JaCoCo 0.8.13 |
| Version | 1.1.0 |

## Program and rules

This is the W4 five-card evaluator with its previous three defects repaired.
A hand contains five distinct physical cards, in any order. Ranks are 2..14
(J=11, Q=12, K=13, A=14); suits are CLUBS, DIAMONDS, HEARTS, SPADES.
Do not modify the hand. Inputs are non-null and valid; invalid-input handling
is outside this exercise.

The strongest category wins, in this order:

| Priority | Category | Rule |
|----------|----------|------|
| 1 | STRAIGHT_FLUSH | Five distinct consecutive ranks, all one suit |
| 2 | FOUR_OF_A_KIND | Rank counts 4,1 |
| 3 | FULL_HOUSE | Rank counts 3,2 |
| 4 | FLUSH | Five equal suits |
| 5 | STRAIGHT | Five distinct consecutive ranks |
| 6 | THREE_OF_A_KIND | Rank counts 3,1,1 |
| 7 | TWO_PAIR | Rank counts 2,2,1 |
| 8 | ONE_PAIR | Rank counts 2,1,1,1 |
| 9 | HIGH_CARD | No other category |

A straight has five distinct consecutive ranks. A-2-3-4-5 and 10-J-Q-K-A are
allowed; Q-K-A-2-3 is not. A flush has five equal suits. A full house has rank
counts 3 and 2. Three of a kind has counts 3,1,1; two pair 2,2,1;
one pair 2,1,1,1. Four of a kind has counts 4,1.

## New bonus rule

BonusPolicy.qualifies returns true for a straight flush OR a full house.
Let A = isStraight(hand), B = isFlush(hand), C = isFullHouse(hand).
The required decision is P = (A && B) || C. The implementation may be wrong.

| Hand | Result | Category |
|------|--------|----------|
| 2H 3H 4H 5H 6H | true | straight flush |
| 7C 7D 7H 9S 9C | true | full house |
| 2C 3D 4H 5S 6C | false | straight only |
| 2H 5H 8H JH KH | false | flush only |
| 2C 5D 8H JS KC | false | high card |

## Build and test

| Command | Purpose |
|---------|---------|
| `mvn test` | Run all JUnit tests |
| `mvn verify` | Run tests and generate the JaCoCo coverage report |
| Report location | `target/site/jacoco/index.html` |

## Files

| Path | Purpose |
|------|---------|
| `src/main/java/lab/poker/Card.java` | Card record with rank and suit |
| `src/main/java/lab/poker/HandType.java` | Hand category enum |
| `src/main/java/lab/poker/PokerHandEvaluator.java` | Evaluates a five-card hand |
| `src/main/java/lab/poker/BonusPolicy.java` | Bonus rule `P = (A && B) \|\| C` |
| `src/test/java/lab/poker/PokerHandEvaluatorTest.java` | Evaluator tests |
| `src/test/java/lab/poker/BonusPolicyTest.java` | Bonus policy tests |
| `src/test/java/lab/poker/BonusIndependenceTest.java` | Reserved for the Git exercise |
| `src/test/java/lab/poker/Hands.java` | Helper: `Hands.of("2C 3D 4H 5S 6C")` |
| `docs/predicate-table.csv` | Predicate truth table |

## Coverage

| Class | Lines | Branches | Methods |
|-------|-------|----------|---------|
| PokerHandEvaluator | 100% | 100% | 100% |
| BonusPolicy | 100% | 100% | 100% |

## Changelog

| Version | Date | Summary |
|---------|------|---------|
| 1.1.0 | 2026-10-02 | Added full CC/DC and MC/DC coverage for PokerHandEvaluator: all nine hand categories, the A-2-3-4-5 wheel branch of `isStraight`, and independent-condition cases for `isFlush` and `isFullHouse`. Achieved 100% line/branch/method coverage. |
| 1.0.0 | — | Initial five-card evaluator with its three defects repaired; added the bonus policy `P = (A && B) \|\| C`, the predicate truth table, and the initial test suite. |