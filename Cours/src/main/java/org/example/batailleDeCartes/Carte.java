package org.example.batailleDeCartes;

import java.util.List;

public class Carte {
  static final List<Character> colorlist = List.of('♥', '♦', '♣', '♠');
  static final List<String> valuelist =
      List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
  private final char color;
  private final String value;
  
  public Carte(int color, int value) {
    this.color = colorlist.get(color);
    this.value = valuelist.get(value);
  }
  
  /**
   * Compare the value of two cards.
   * Return different value depending on the case. If the value is:
   * <ul><li>positive the card is indeed stronger.</li>
   * <li>0 the card is the same strength.</li>
   * <li>negative the card is weaker.</li></ul>
   *
   * @param carte the carte to compare to.
   * @return the différence in the cards value.
   */
  public int valueMinusCardValueOf(Carte carte) {
    
    return valuelist.indexOf(this.value) - valuelist.indexOf(carte.value);
  }
  
  @Override
  public String toString() {
    return value + color;
  }
}
