package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Suit;
import com.tlglearning.cards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Trick {
  //FIELDS (private list of card
  private final Random rng;
  private final List<Card> blackPile;
  private final List<Card> redPile;

  //CONSTRUCTOR
  public Trick(Random rng) {
    this.rng = rng;
    Deck deck = new Deck(); // creating a deck of 52 cards
    deck.shuffle(rng); //shuffling deck after creation.
    blackPile = new ArrayList<>(); //creating black pile (sorted)
    redPile = new ArrayList<>(); //creating red pile (sorted)
    divideIntoPiles(deck);
  }


  //helper method - divideIntoPiles (refactor/extract/method)
  private void divideIntoPiles(Deck deck) {
    for (Iterator<Card> iterator = deck.iterator(); iterator.hasNext(); ) { //iteration; traditional for loop but no counting. (initialization ; iteration condition, update)
      Card indicator = iterator.next(); // get me the next item, and advance.
      Card next = iterator.next(); //drawing the next card.
      if (indicator.suit().color() == Color.BLACK) { //checking to see if color is black
        blackPile.add(next); // adding next card to black pile
      } else {
        redPile.add(next); //adding next card to red pile

      }
    }
  }


  public static void main(String[] args) {
    Trick trick = new Trick(new SecureRandom()); // Create and shuffle a deck of cards from Trick class named trick.
    trick.swapBetweenPiles(); //Divide deck into 2 piles, red and black; discard indicator cards.
    trick.displayPile(trick.blackPile,Color.BLACK);
    trick.displayPile(trick.redPile,Color.RED);
  }

  private void swapBetweenPiles() { //swap method
    int maxSwapCount = Math.min(blackPile.size(), redPile.size());  //figure out how many cards we will swap.
    int swapCount = rng.nextInt(maxSwapCount + 1); // 0-9 , 10 possibilities. This is the bound.
    for (int i = 0; i < swapCount; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

  private void displayPile(List<Card> cards, Suit.Color color) {
    cards.sort(
        Comparator
        .comparing((Card card) -> card.suit().color())
        .thenComparing(Card::suit)
        .thenComparing(Card::rank)
    );
    int count = countColor(cards, color);
    System.out.printf("%s: %s: %d%n", color, cards, count);
  }

  private int countColor (Collection<Card> cards, Suit.Color color) {
    return (int) cards
        .stream() // creates a stream of card (on conveyor belt)
        .filter((card) -> card.suit().color() == color)
        .count();
  }
}
