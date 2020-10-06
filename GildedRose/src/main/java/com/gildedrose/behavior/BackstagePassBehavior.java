package com.gildedrose.behavior;
import com.gildedrose.*;

/** .
 * Classe implementant le comportement particulier de degradation de l'item Backstage Pass
 * Ne redefinit pas updateSellIn
 *
 * La qualite de l'item augmente differement selon le nombre de jours restants
 *
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 *
 * @version 1.0
 */

public class BackstagePassBehavior implements Behavior {
  /**
   * Espace de nom
   * Qualite minimale d'un item
   *
   * @see Item
   */
  private final transient int minquality = 0;

  /**
   * Espace de nom
   * Qualite a ne pas depasser
   *
   * @see Item
   */
  private final transient int maxquality = 50;

  /**
   * Espaces de nom
   * Nombre de jours restants avant le concert
   */
  private final transient  int daysRemaining10 = 10;
  private final transient  int daysRemaining5 = 5;

  /** .
   * Methode d'augmentation de la qualite de l'item
   * Si l'item est perime, qualite nulle
   *
   * @see Item
   * @see Behavior
   *
   * @param it
   */
  public void updateItemQuality(Item it) {
    final int tmp = it.sellIn;
    final int inc = tmp > daysRemaining10 ? 1 : tmp <= daysRemaining10 && tmp > daysRemaining5 ? 2 : 3;
    if (isExpired(it)) {
      it.quality = 0;
    } else {
      it.quality = (it.quality + inc) > maxquality ? 50 : it.quality + inc;
    }
  }

}
