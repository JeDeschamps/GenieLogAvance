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
   * Differents espaces de noms pour les differents valeurs d'incrementation de la qualite
   * selon le nombre de jours restants avant le concert
   */
  private final transient  int daysRemaining10 = 10;
  private final transient  int daysRemaining5 = 5;

  /**
   * Valeurs d'incrementation de qualite selon le nombre de jours restants
   */
  private final transient  int normalupgrade = 1;
  private final transient  int upgradeUnder10 = 2;
  private final transient int upgradeUnder5 = 3;


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
    final int inc;
    inc = it.getSellIn() > daysRemaining10 ? normalupgrade : isBetween5and10(it) ? upgradeUnder10 : upgradeUnder5;
    if (isExpired(it)) {
      it.setQuality(0);
    } else {
      final int tmp = (it.getQuality() + inc) > maxquality ? 50 : it.getQuality() + inc;
      it.setQuality(tmp);
    }
  }

  /** .
   * Methode de verification si le sellIn est entre 5 et 10
   *
   * @see Item
   *
   * @param it
   */
  private boolean isBetween5and10(Item it) {
    return it.getSellIn() <= daysRemaining10 && it.getSellIn() > 5;
  }
}
