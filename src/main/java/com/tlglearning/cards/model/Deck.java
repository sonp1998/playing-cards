package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable<Card> {

  private final List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
  }

  //can iterate over deck of cards, but can't change contents (consumer).
  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(cards).iterator();
  }

  //shuffle method
  public void shuffle(Random rng) {
    Collections.shuffle(cards, rng);
  }

  //shuffle method default src of randomness. Now we know how to shuffle.
  public void shuffle() {
    Collections.shuffle(cards);
  }

  public void sort() {
    sort(null); // method invocation (of the 2nd sort below)
  }

  public void sort(Comparator<Card> comparator) {
    cards.sort(comparator);
  }

  //delegating tasks to the list of cards (overriding from object)
  @Override
  public int hashCode() {
    return cards.hashCode();
  }

  //if, else-if, else structure. Same structure for most equals objects, the line that changes is #49.
  @Override
  public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {
      result = true;
    } else if (obj instanceof Deck) {
      result = cards.equals(((Deck) obj).cards);
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return cards.toString();
  }
}
