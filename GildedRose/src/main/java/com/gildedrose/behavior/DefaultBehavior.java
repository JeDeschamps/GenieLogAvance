package com.gildedrose; 

/**
 * Classe implementant le comportement par defaut des items
 * Ne redefinit pas updateSellIn
 * 
 * 
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 * 
 * @version 1.0
 */

public class DefaultBehavior implements Behavior {
    /**
     * Espace de nom
     * Qualite minimale d'un item
     * 
     * @see Item
     */
    private final int MIN_QUALITY = 0;

    /**
     * Methode d'augmentation de la qualite de l'item
     * Augmentation par defaut
     * 
     * @see Item
     * @see Behavior
     * 
     * @param Item
     * 
     * @return rien, modifie la valeur dans l'item it
     */
    public void updateItemQuality(Item it){ 
        if (it.getQuality() > MIN_QUALITY)
        {
            it.setQuality(it.getQuality() - 1);
            if(it.getQuality() > MIN_QUALITY && isExpired(it))
                it.setQuality(it.getQuality() - 1);
        }
    }
}