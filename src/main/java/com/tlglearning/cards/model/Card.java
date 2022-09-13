package com.tlglearning.cards.model;
//Object is the superclass automatically
public class Card {
  //1. field Declaration. modifier modifier Type Name. Final is asking the compiler to only have single value,
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
  public String toString() {
    return rank.symbol() + suit.symbol(); //string concatenation
  }
  //TODO Override equals method.
  //TODO Override hashcode method.
}
