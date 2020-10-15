package com.gildedrose.behavior;
import java.util.HashMap;

import com.gildedrose.*;
import com.gildedrose.conjured.*;

/**
 * Notre fabrique d'objets Behavior.
 *
 *
 * Instancie dynamiquement le comportement approprie a l'objet
 * qu'on passe en parametre a notre unique methode.
 *
 * Une HashMap statique contient toutes les entrees possibles de noms d'items
 * Rajouter un item avec un nouveau comportement implique une nouvelle entree
 * dans la HashMap
 *
 * Methode statique, pas besoin d'instancier la factory pour l'utiliser
 *
 * @see Behavior
 * @see Item
 *
 * @version 2.0
 */
public final class BehaviorFactory {

  private static HashMap<String, Behavior> behaviorMap;
  static {
    behaviorMap = new HashMap<>();
    behaviorMap.put("+5 Dexte", new DefaultBehavior());
    behaviorMap.put("Aged Bri", new AgedBrieBehavior());
    behaviorMap.put("Elixir o", new DefaultBehavior());
    behaviorMap.put("Sulfuras", new SulfurasBehavior());
    behaviorMap.put("Backstag", new BackstagePassBehavior());
    behaviorMap.put("Conjured", new ConjuredBehavior());
  }
  /**
   * Constructeur prive, cree uniquement pour le checkstyle.
   *
   */
  private BehaviorFactory() {

  }

  /**
   * Methode de la factory.
   *
   * On utilise les 8 premiers characteres du nom de l'item
   * On fait ca parce que sinon il faudrait gerer les cas des items
   * conjured avec un if externe
   * Aussi utile pour avoir des backstage pass pour n'importe
   * quel concert
   *
   * Retourne un comportement par defaut si l'item est inconnu
   *
   * @see Behavior
   * @see Item
   *
   * @param it l'objet dont on souhaite obtenir le comportement associe
   * @return Un objet behavior, comportement associe a l'objet
   */
  public static Behavior getItemBehavior(Item it) {
    final String str = it.name.substring(0, 8);
    if (behaviorMap.containsKey(str)) {
      return behaviorMap.get(str);
    } else {
      return new DefaultBehavior();
    }
  }
}
