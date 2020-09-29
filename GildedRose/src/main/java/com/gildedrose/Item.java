package com.gildedrose;
import com.gildedrose.*;
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
   * Nom de l'item, modification/acces par methodes preferable
   *
   * @see Item#getQuality()
   * @see Item#setQuality(int)
   */
  public String name;

  /** .
   * Jours restants avant peremption
   * Valeurs <= 0 si l'item est perime
   *
   * @see Item#getSellIn()
   * @see Item#setSellIn(int)
   *
   * @see Behavior#isExpired(Item)
   */
  public int sellIn;

  /** .
   * Qualite de l'item
   * Valeur devant être comprise theoriquement entre 0 et 50
   * Sulfuras a une qualite fixe a 80 theoriquement
   *
   * @implNote Les items peuvent être instancies avec des valeurs normalement interdites
   *
   * @see Item#getQuality()
   * @see Item#setSellIn(int)
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

  public final String getName() {
    return this.name;
  }

  public final int getSellIn() {
    return this.sellIn;
  }

  public final int getQuality() {
    return this.quality;
  }

  public final void setName(String newName) {
    this.name = newName;
  }

  public final void setSellIn(int newSellIn) {
    this.sellIn = newSellIn;
  }

  public final void setQuality(int newQuality) {
    this.quality = newQuality;
  }
}
