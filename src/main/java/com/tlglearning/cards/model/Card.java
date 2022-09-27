package com.tlglearning.cards.model;

import java.util.Objects;

//Object is the superclass automatically
public class Card implements Comparable<Card> {

  //1. field Declaration. modifier Type Name. Final is asking the compiler to only have single value,
  private final Rank rank; // and in return expects initialization...
  private final Suit suit;

  //2. CONSTRUCTOR(      parameter     )
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  //3. ACCESSORS || GETTERS || METHODS
  public Rank rank() {
    return rank;
  }

  public Suit suit() {
    return suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, suit); //FIXME Move this to initialization . (:
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {
      result = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      result = (this.rank == other.rank && this.suit == other.suit);
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return rank.symbol() + suit.symbol(); //string concatenation
  }

  @Override
  public int compareTo(Card other) {
    int comparison = this.suit.compareTo(other.suit);
    if(comparison == 0) {
      comparison = this.rank.compareTo(other.rank);
    }
    return comparison;
  }
}