package com.gildedrose; 
/**
 * Classe implémentant le comportement des items conjured
 * Ne redéfinit pas updateSellIn
 * 
 * Les changements de qualité sont doublés quand l'item est conjured
 * 
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 * 
 * @version 1.0
 */


public class ConjuredBehavior implements Behavior {

    /**
     * Modifie la qualité des items conjurés 
     * Réutilise l'implémentation du Behavior de l'item concerné
     * Respecte les contraintes de qualité existantes
     * 
     * @see Item
     * @see Behavior
     * @see Behavior#updateItemQuality(Item)
     * @see BehaviorFactory
     * 
     * @param Item
     */
    public void updateItemQuality(Item it){ 
        String str = it.getName().replace("Conjured ","");
        it.setName(str);
        Behavior normalBehavior = BehaviorFactory.getItemBehavior(it);
        normalBehavior.updateItemQuality(it);
        normalBehavior.updateItemQuality(it);
        it.setName("Conjured " + it.getName());
    }
}
