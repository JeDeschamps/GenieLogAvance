package com.gildedrose.conjured;

import com.gildedrose.*;
import com.gildedrose.behavior.*;

/** .
 * Classe implementant le comportement des items conjured
 * Ne redefinit pas updateSellIn
 *
 * Les changements de qualite sont doubles quand l'item est conjured
 *
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 *
 * @version 1.0
 */


public class ConjuredBehavior implements Behavior {
  /** .
   * Modifie la qualite des items conjures
   * Reutilise l'implementation du Behavior de l'item concerne
   * Respecte les contraintes de qualite existantes
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
