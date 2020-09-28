package com.gildedrose;

/**
 * L'interface Behavior est l'abstraction que de pattern strategy
 * La famille d'algorithme couverte par la stratégie implémente uniquement cette interface
 * 
 * L'interface couvre le comportement de dégradation de la qualité et du sellIn de l'item selon les Items
 * 
 * Interface implémentée par tous les comportements d'item
 * 
 * @see Item
 * 
 * @version 2.0
 */

public interface Behavior {
    /**
     * Méthode de dégradation de la qualité de l'item
     * 
     * @param Item
     * 
     * @see Item#quality
     */
    void updateItemQuality(Item it);

    /**
     * Méthode de dégradation du sellIn de l'item
     * 
     * @param Item
     * 
     * @implNote Implémentation par défaut, rarement redéfinie
     * 
     * @see Item#sellIn
     */
    default void updateItemSellIn(Item it){
        if(!it.getName().equals("Sulfuras, Hand of Ragnaros"))
        {
            it.setSellIn(it.getSellIn()-1);
        }
    }

    /**
     * Espace de nom pour le test de péremption de l'item
     * 
     * @param Item
     * @return si l'item est expiré
     * 
     * @see Item#quality
     */
    default public boolean isExpired(Item it){
        return (it.getSellIn() <= 0);
    }
}
