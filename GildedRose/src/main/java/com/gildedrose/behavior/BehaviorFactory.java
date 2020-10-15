package com.gildedrose.behavior;
import java.util.HashMap;

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

  private static HashMap<String, Object> behaviorMap;
  static {
    behaviorMap = new HashMap<>();
    behaviorMap.put("+5 Dexte", new DefaultBehavior());
    behaviorMap.put("Aged Bri", new AgedBrieBehavior());
    behaviorMap.put("Elixir o", new DefaultBehavior());
    behaviorMap.put("Sulfuras", new SulfurasBehavior());
    behaviorMap.put("Backstag", new BackstagePassBehavior());
    behaviorMap.put("Conjured", new ConjuredBehavior());
  }
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
    if(behaviorMap.containsKey((str))) {
      return (Behavior) behaviorMap.get(str);
    }
    else {
      return new DefaultBehavior();
    }
  }
}
