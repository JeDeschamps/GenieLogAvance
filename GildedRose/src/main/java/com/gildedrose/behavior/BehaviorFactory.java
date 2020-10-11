package com.gildedrose.behavior;
import com.gildedrose.*;
import com.gildedrose.conjured.*;

/**
 * Notre fabrique d'objets Behavior
 *
 * Instancie dynamiquement le comportement approprie a l'objet
 * qu'on passe en parametre a notre unique methode.
 * Utilise un switch sur le nom de l'item dans cette version.
 * --> Trop de return au sein d'une meme fonction
 *
 * Methode statique, pas besoin d'instancier la factory pour l'utiliser
 *
 * @see Behavior
 * @see Item
 *
 * @version 1.0
 */
public final class BehaviorFactory {
  /**
   * Constructeur prive, cree uniquement pour le checkstyle
   *
   */
  private BehaviorFactory() {

  }

  /**.
   * Methode de la factory
   *
   *
   * @see Behavior
   * @see Item
   *
   * @param it l'objet dont on souhaite obtenir le comportement associe
   * @return Un objet behavior, comportement associe a l'objet
   */
  public static Behavior getItemBehavior(Item it) {
    final String str = it.name.substring(0, 8);
    switch (str) {
      case "+5 Dexte":
        return new DefaultBehavior();

      case "Aged Bri":
        return new AgedBrieBehavior();

      case "Elixir o":
        return new DefaultBehavior();

      case "Sulfuras":
        return new SulfurasBehavior();
      case "Backstag":
        return new BackstagePassBehavior();
      case "Conjured":
        return new ConjuredBehavior();
      default:
        break;
    }
    return new DefaultBehavior();
  }
}
