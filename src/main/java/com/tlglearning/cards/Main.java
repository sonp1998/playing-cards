package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    //constructing an anomalous class and instructing the instance into local variable comparator.


    Deck deck = new Deck();               //create an instance of Deck
    System.out.println(deck);             //print the string representation of the deck
    Random rng = new SecureRandom();     //create an acceptable source of randomness. Cryptographically secure
    deck.shuffle(rng);                  //shuffle the deck using the created source of randomness
    System.out.println(deck);           //Print the string representation of the deck after shuffling
    deck.sort();
    System.out.println(deck);
    deck.sort((card1, card2) -> {
      int comparison = card1.suit().color().compareTo(card2.suit().color());
      if (comparison == 0) {
        comparison = card1.suit().compareTo(card2.suit());
        if (comparison==0) {
          comparison = - card1.rank().compareTo(card2.rank()); // negative reverses the comparison going in descending order.
        }
      }
      return comparison;
    });
    //creating an instance of 3rd party that does it in descending order.
    System.out.println(deck);
  }


}