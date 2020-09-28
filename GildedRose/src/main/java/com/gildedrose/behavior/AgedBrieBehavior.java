package com.gildedrose;

/**
 * Classe implémentant le comportement particulier de dégradation de l'item AgedBrie
 * Ne redéfinit pas updateSellIn
 * 
 * La qualité de l'item augmente avec le temps
 * 
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 * 
 * @version 1.0
 */

public class AgedBrieBehavior implements Behavior {
    /**
     * Espace de nom
     * Qualité à ne pas dépasser
     * 
     * @see Item
     */
    private final int MAX_QUALITY = 50;

    /**
     * Méthode d'augmentation de la qualité de l'item
     * L'item voit sa qualité augmenter même si instancié avec une qualité négative
     * 
     * @see Item
     * @see Behavior
     * 
     * @param Item
     * 
     * @return rien, modifie la valeur dans l'item it
     */
    public void updateItemQuality(Item it){ 
        if (it.getQuality() < MAX_QUALITY)
        {
            it.setQuality(it.getQuality() + 1);
            if(it.getQuality() < MAX_QUALITY && isExpired(it))
                it.setQuality(it.getQuality() + 1);
        }
    }
}