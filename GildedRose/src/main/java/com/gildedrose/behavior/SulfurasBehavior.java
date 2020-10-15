package com.gildedrose.behavior;

import com.gildedrose.*;

/**
 * Classe implementant le comportement particulier de degradation de l'item legendaire Sulfuras.
 *
 * L'item est considere comme n'ayant pas sellIn et une qualite qui ne se degrade pas
 *
 * @see Item
 * @see Behavior
 *
 * @version 1.0
 */
public class SulfurasBehavior implements Behavior {

  /**
   * Les methodes d'update pour l'item.
   * Redefinit updateItemSellIn
   * Methodes vides
   *
   * @see Item
   * @see Behavior
   *
   * @param it
   */
  public void updateItemSellIn(Item it) {

  }
  public void updateItemQuality(Item it) {

  }
}
