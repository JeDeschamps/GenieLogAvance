package com.gildedrose.behavior;

import com.gildedrose.*;

/** .
 * Classe implementant le comportement particulier de degradation de l'item AgedBrie
 * Ne redefinit pas updateSellIn
 *
 * La qualite de l'item augmente avec le temps
 *
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 *
 * @version 1.0
 */

public class AgedBrieBehavior implements Behavior {
  /**
   * Espace de nom
   * Qualite a ne pas depasser
   *
   * @see Item
   */
  private final transient int maxquality = 50;

  /**
   * Espace de nom
   * Incrementation normale
   */
  private final transient int normalupgrade = 1;

  /** .
   * Methode d'augmentation de la qualite de l'item
   * L'item voit sa qualite augmenter meme si instancie avec une qualite negative
   *
   * @see Item
   * @see Behavior
   *
   * @param it
   */
  public void updateItemQuality(Item it) {
    if (it.quality < maxquality) {
      it.quality = it.quality + normalupgrade;
      if (it.quality < maxquality && isExpired(it)) {
        it.quality = it.quality + normalupgrade;
      }
    }
  }
}
