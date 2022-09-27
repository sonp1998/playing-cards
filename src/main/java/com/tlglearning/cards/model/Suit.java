package com.tlglearning.cards.model;

public enum Suit {

  CLUBS('\u2663', Color.BLACK), // 1. Becomes public static final Suit CLUBS = new Suit('\u2663', Color.BLACK);
  DIAMONDS('\u2662', Color.RED), //u in front is unicode, single ' is because char
  HEARTS('\u2661', Color.RED), //names of enumerated values are always UPPERSNAKECASE
  SPADES('\u2660', Color.BLACK);

  private final char symbol;
  private final Color color;

  //2. constructor (in enum, constructor is always private)
  private Suit(char symbol, Color color) {
    this.symbol = symbol;
    this.color = color;
  }

//3. now need a getter for symbol (or accessor/mutator)
  public char symbol() {
    return symbol;
  }

  public Color color() {
    return color;
  }

//4. type control + O for override to get toString Method
  @Override
  public String toString() {
    String name = name(); // local variable called name. Knows name varibale bc of ().
    return name.charAt(0) + name.substring(1).toLowerCase(); // to write out Clubs with upper C lower lubs
  }

  //nested enum class for color
  public enum Color {
    BLACK,
    RED
  }
}
