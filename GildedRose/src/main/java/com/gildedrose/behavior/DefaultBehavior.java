package com.gildedrose.behavior;

import com.gildedrose.*;

/** .
 * Classe implementant le comportement par defaut des items
 * Ne redefinit pas updateSellIn
 *
 *
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 *
 * @version 1.0
 */

public class DefaultBehavior implements Behavior {
  /**
   * Espace de nom
   * Qualite minimale d'un item
   *
   * @see Item
   */
  private final transient int minquality = 0;

  /**
   * Espace de nom
   * Incrementation normale
   */
  private final transient int normalupgrade = 1;

  /** .
   * Methode d'augmentation de la qualite de l'item
   * Augmentation par defaut
   *
   * @see Item
   * @see Behavior
   *
   * @param it
   */
  public void updateItemQuality(Item it) {
    if (it.getQuality() > minquality) {
      it.setQuality(it.getQuality() - normalupgrade);
      if (it.getQuality() > minquality && isExpired(it)) {
        it.setQuality(it.getQuality() - normalupgrade);
      }
    }
  }
}
