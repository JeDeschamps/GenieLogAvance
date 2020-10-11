package com.gildedrose.behavior;
import com.gildedrose.*;

/** .
 * L'interface Behavior est l'abstraction de notre pattern strategy
 * La famille d'algorithme couverte par la strategie implemente uniquement cette interface
 * L'utilisation d'une interface permet d'avoir un decouplage fort
 *
 * L'interface couvre le comportement de degradation de la qualite et du sellIn de l'item selon les Items
 *
 * Interface implementee par tous les comportements d'item
 *
 * @see Item
 *
 * @version 2.0
 */

public interface Behavior {
  /** .
   * Methode de degradation de la qualite de l'item
   *
   * @param it
   *
   * @see Item#quality
   */
  void updateItemQuality(Item it);

  /** .
   * Methode de degradation du sellIn de l'item
   *
   * @param it
   *
   * Implementation par defaut car rarement redefinie par les items
   *
   * @see Item#sellIn
   */
  default void updateItemSellIn(Item it) {
    if (!it.name.equals("Sulfuras, Hand of Ragnaros")) {
      it.sellIn = it.sellIn - 1;
    }
  }

  /** .
   * Espace de nom pour le test de peremption de l'item
   *
   * @param it
   * @return si l'item est expire
   *
   * @see Item#sellIn
   */
  default boolean isExpired(Item it) {
    return it.sellIn <= 0;
  }
}
