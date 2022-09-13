package com.tlglearning.cards.model;

public enum Suit {

  CLUBS('\u2663'), // 1. Becomes public static final Suit CLUBS = new Suit('\u2663');
  DIAMONDS('\u2662'), //u in front is unicode, single ' is because char
  HEARTS('\u2661'),
  SPADES('\u2660');

  private final char symbol;
  //2. constructor
  private Suit(char symbol) {
    this.symbol = symbol;
  }
//3. now need a getter for symbol (or accessor/mutator)
  public char symbol() {
    return symbol;
  }
//4. type control + O for override to get toString Method
  @Override
  public String toString() {
    String name = name(); // local variable called name. Knows name varibale bc of ().
    return name.charAt(0) + name.substring(1).toLowerCase(); // to write out Clubs with upper C lower lubs
  }
}
