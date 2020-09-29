package com.gildedrose.behavior;
import com.gildedrose.*;

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
    private transient final int MIN_QUALITY = 0;

    /**
     * Espace de nom 
     * Incrementation normale
     */
    private transient final int NORMAL_UPGRADE = 1;

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
            it.setQuality(it.getQuality() - NORMAL_UPGRADE);
            if(it.getQuality() > MIN_QUALITY && isExpired(it))
                it.setQuality(it.getQuality() - NORMAL_UPGRADE);
        }
    }
}