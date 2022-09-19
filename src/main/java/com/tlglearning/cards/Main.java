package com.tlglearning.cards;

import com.tlglearning.cards.model.Deck;
import java.security.SecureRandom;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    //create an instance of Deck
    Deck deck = new Deck();
    //print the string representation of the deck
    System.out.println(deck);
    //create an acceptable source of randomness. Cryptographically secure
    Random rng = new SecureRandom();
    //shuffle the deck using the created source of randomness
    deck.shuffle(rng);
    //Print the string representation of the deck after shuffling
    System.out.println(deck);
  }
}
