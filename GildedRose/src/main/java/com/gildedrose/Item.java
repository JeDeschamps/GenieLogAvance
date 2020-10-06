package com.gildedrose;
import com.gildedrose.behavior.*;
/** .
 * Classe representant un item, 3 attributs :
 *  - Nom
 *  - Date de peremption
 *  - Qualite
 *
 * Fournit accesseurs/setters sur chacun des attributs
 * @version 2.0
 */


public class Item {
  /** .
   * Nom de l'item
   */
  public String name;

  /** .
   * Jours restants avant peremption
   * Valeurs negative ou nulle si l'item est perime
   *
   * @see Behavior#isExpired(Item)
   */
  public int sellIn;

  /** .
   * Qualite de l'item
   * Valeur devant être comprise theoriquement entre 0 et 50
   * Sulfuras a une qualite fixe a 80 theoriquement
   *
   * Les items peuvent être instancies avec des valeurs normalement interdites
   */
  public int quality;

  /** .
   * Constructeur Item
   *
   * @param nameConstruct
   * @param sellInConstruct
   * @param qualityConstruct
   *
   * @see Item#name
   * @see Item#sellIn
   * @see Item#quality
   */
  public Item(String nameConstruct, int sellInConstruct, int qualityConstruct) {
    this.name = nameConstruct;
    this.sellIn = sellInConstruct;
    this.quality = qualityConstruct;
  }


  @Override
  public final String toString() {
    return this.name + this.sellIn + this.quality;
  }
}
