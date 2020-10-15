package com.gildedrose;
import com.gildedrose.behavior.*;
/**
 * Classe representant un item, fournie dans le kata.
 * 3 attributs :
 *  - Nom
 *  - Date de peremption
 *  - Qualite
 *
 */


public class Item {
  /**
   * Nom de l'item.
   */
  public String name;

  /**
   * Jours restants avant peremption.
   * Valeur negative ou nulle si l'item est perime
   *
   * @see Behavior#isExpired(Item)
   */
  public int sellIn;

  /**
   * Qualite de l'item.
   * Valeur devant être comprise theoriquement entre 0 et 50
   * Sulfuras a une qualite fixe a 80 theoriquement
   *
   * Les items peuvent être instancies avec des valeurs normalement interdites
   */
  public int quality;

  /**
   * Constructeur Item.
   *
   * @param name nom
   * @param sellIn jours avant peremption
   * @param quality qualite
   *
   * @see Item#name
   * @see Item#sellIn
   * @see Item#quality
   */
  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }


  @Override
  public final String toString() {
    return this.name + this.sellIn + this.quality;
  }
}
