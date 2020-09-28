package com.gildedrose; 

/**
 * Classe implémentant le comportement particulier de dégradation de l'item légendaire Sulfuras 
 * 
 * L'item est considéré comme n'ayant pas sellIn et une qualité qui ne se dégrade pas
 * 
 * @see Item
 * @see Behavior
 * 
 * @version 1.0
 */
public class SulfurasBehavior implements Behavior {

    /**
     * Les méthodes d'update pour l'item
     * Méthodes vides
     * 
     * @see Item
     * @see Behavior
     * 
     * @param Item
     */
    public void updateItemSellIn(Item it){
        ;
    }
    public void updateItemQuality(Item it){ 
        ;
    }
}