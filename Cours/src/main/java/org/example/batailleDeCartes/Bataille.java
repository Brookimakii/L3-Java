package org.example.batailleDeCartes;

import java.util.ArrayList;
import java.util.List;

/**
 * Envoyer le projet sur github et partager le lien à la prof par mail avec comme objet : [L3JAVA]
 */
public class Bataille {
  public static void main(String[] args) {
    List<Carte> deck = new ArrayList<>();
    
    for (int i = 0; i < Carte.colorlist.size(); i++) {
      for (int j = 0; j < Carte.valuelist.size(); j++) {
        deck.add(new Carte(i, j));
      }
    }
//    System.out.println(deck);
    
    Joueur j1 = new Joueur();
    Joueur j2 = new Joueur();
    
    int round = 0;
    
    while (!deck.isEmpty()) {
      round += 1;
      Carte carteJoueur1 = j1.drawCard(deck);
      Carte carteJoueur2 = j2.drawCard(deck);
      
      int valueDiffrence = carteJoueur1.valueMinusCardValueOf(carteJoueur2);
      
      
      String winningSentence;
      if (valueDiffrence > 0) {
        j1.addScore();
        winningSentence = "Player 1 win this round";
      } else if (valueDiffrence < 0) {
        j2.addScore();
        winningSentence = "Player 2 win this round";
      } else {
        winningSentence = "Draw";
      }
      System.out.printf(
          """
          Round %d :
          %d - %d
          %d Fold left.
          ---------------------------
          Player 1 card: %s
          Player 2 card: %s
          ---------------------------
          %s
          ===========================
          %n""", round, j1.getScore(), j2.getScore(), (int) (deck.size()/2), carteJoueur1, carteJoueur2, winningSentence);
    }
    
    if (j1.getScore() > j2.getScore()) {
      System.out.println("Player 1 has won!");
    } else if (j1.getScore() < j2.getScore()) {
      System.out.println("Player 2 has won!");
    }else{
      System.out.println("It's a draw!");
    }
    
    System.out.println("Card Played:\nPlayer 1: " + j1.getHand() + "\nPlayer 2: " + j2.getHand());
    
  }
  
}
