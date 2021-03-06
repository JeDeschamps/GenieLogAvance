package com.gildedrose.conjured;

import com.gildedrose.*;
import com.gildedrose.behavior.*;

/**
 * Classe implementant le comportement des items conjured.
 * Ne redefinit pas updateSellIn
 *
 * Les changements de qualite sont doubles quand l'item est conjured
 *
 *
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 *
 * @version 1.0
 */


public class ConjuredBehavior implements Behavior {
  /**
   * Degrade 2 fois la qualite de l'item.
   * Utilise la behavior factory pour recuperer le comportement de
   * degradation de l'item de base
   *
   * @see Item
   * @see Behavior
   * @see Behavior#updateItemQuality(Item)
   * @see BehaviorFactory
   *
   * @param it
   */
  public void updateItemQuality(Item it) {
    final String strConjured = "Conjured ";
    final String str = it.name.replace(strConjured, "");
    it.name = str;
    final Behavior normalBehavior = BehaviorFactory.getItemBehavior(it);
    normalBehavior.updateItemQuality(it);
    normalBehavior.updateItemQuality(it);
    it.name = strConjured + it.name;
  }
}
