package com.gildedrose.behavior;
import com.gildedrose.*;

/**
 * L'interface Behavior est l'abstraction que de pattern strategy
 * La famille d'algorithme couverte par la strategie implemente uniquement cette interface
 * 
 * L'interface couvre le comportement de degradation de la qualite et du sellIn de l'item selon les Items
 * 
 * Interface implementee par tous les comportements d'item
 * 
 * @see Item
 * 
 * @version 2.0
 */

public interface Behavior {
    /**
     * Methode de degradation de la qualite de l'item
     * 
     * @param Item
     * 
     * @see Item#quality
     */
    void updateItemQuality(Item it);

    /**
     * Methode de degradation du sellIn de l'item
     * 
     * @param Item
     * 
     * @implNote Implementation par defaut, rarement redefinie
     * 
     * @see Item#sellIn
     */
    default void updateItemSellIn(Item it){
        if(!it.getName().equals("Sulfuras, Hand of Ragnaros"))
        {
            it.setSellIn(it.getSellIn() - 1);
        }
    }

    /**
     * Espace de nom pour le test de peremption de l'item
     * 
     * @param Item
     * @return si l'item est expire
     * 
     * @see Item#quality
     */
    default public boolean isExpired(Item it){
        return (it.getSellIn() <= 0);
    }
}
