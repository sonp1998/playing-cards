package com.tlglearning.cards.model;

public enum Rank {

  ACE("A"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  JACK("J"),
  QUEEN("Q"),
  KING("K");

  private final String symbol;
//constructor parameter
  Rank(String symbol) {
    this.symbol = symbol;
  }

  public String symbol() {
    return symbol;
  }

  @Override
  public String toString() {
    String name = name(); // local variable called name. Knows name variable bc of ().
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
