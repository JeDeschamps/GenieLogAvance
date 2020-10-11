/**.
 * Le package behavior contient les implementations des comportements
 * de degration / d'augmentation de la qualite pour chacun des items.
 *
 * Behavior est une interface avec une methode d'update du sellIn par defaut
 * Cette methode est par defaut car tres rarement differente de celle de base
 * (tous sauf Sulfuras). La deuxieme methode est celle de l'update de la qualite
 *
 * Utilisation du pattern strategy pour instancier dynamiquement l'algorithme
 * approprie pour l'item. L'abstraction est fournie par l'interface unique
 * implementee par la famille d'algorithme.
 * Utilisation d'une factory, BehaviorFactory, pour l'instantiation dynamique.
 * BehaviorFactory fournit la methode getItemBehavior()
 */
package com.gildedrose.behavior;
