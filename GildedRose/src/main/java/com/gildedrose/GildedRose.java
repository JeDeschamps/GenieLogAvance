package com.gildedrose;
import com.gildedrose.behavior.*;
import com.gildedrose.conjured.*;

/**
 * Classe representant la taverne, 1 attribut :
 *  - Tableau d'items
 *
 * Va effectuer les operations de mise a jour de qualite et de sellIn sur tous ses items
 *
 * @see Item
 * @see Behavior
 * @see BehaviorFactory
 *
 * @version 2.0
 */

class GildedRose {
  /**
   * Collection des items de la taverne
   * Mise a jour de leurs valeurs dans les méthodes
   *
   * @see GIldedRose#updateQualityAndSellIn
   * @see Behavior
   */
  transient Item[] items;

  /**
   * Constructeur de GildedRose
   *
   * @see GildedRose#items
   *
   * @param itemsConstructor
   */
  GildedRose(Item[] itemsConstructor) {
    this.items = itemsConstructor;
  }

  /**
   * Mise a jour de la collection d'objet en attribut
   *
   * @see Item
   * @see GildedRose#updateQualityAndSellIn(Item)
   */
  public void updateQuality() {
    for (Item it : this.items) {
      updateQualityAndSellIn(it);
    }
  }

  /**
   * Mise a jour des valeurs sellIn et quality d'un objet
   *
   * @see Item
   * @see Behavior
   * @see BehaviorFactory
   *
   * @param it
   */
  private void updateQualityAndSellIn(Item it) {
    final Behavior itemBehavior = BehaviorFactory.getItemBehavior(it);
    itemBehavior.updateItemQuality(it);
    itemBehavior.updateItemSellIn(it);
  }
}
