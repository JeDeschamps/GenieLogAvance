package com.gildedrose; 

/**
 * Classe implementant le comportement particulier de degradation de l'item Backstage Pass
 * Ne redefinit pas updateSellIn
 * 
 * La qualite de l'item augmente differement selon le nombre de jours restants
 * 
 * @see Item
 * @see Behavior
 * @see Behavior#updateItemSellIn(Item)
 * 
 * @version 1.0
 */

public class BackstagePassBehavior implements Behavior {
    /**
     * Espace de nom
     * Qualite minimale d'un item
     * 
     * @see Item
     */
    private final int MIN_QUALITY = 0;

    /**
     * Espace de nom
     * Qualite a ne pas depasser
     * 
     * @see Item
     */
    private final int MAX_QUALITY = 50;

    /**
     * Differents espaces de noms pour les differents valeurs d'incrementation de la qualite
     * selon le nombre de jours restants avant le concert
     */
    private final int DAYS_REMAINING_10 = 10;
    private final int DAYS_REMAINING_5 = 5;

    /**
     * Valeurs d'incrementation de qualite selon le nombre de jours restants
     */
    private final int NORMAL_UPGRADE = 1;
    private final int UPGRADE_DAYS_UNDER_10 = 2;
    private final int UPGRADE_DAYS_UNDER_5 = 3;


    /**
     * Methode d'augmentation de la qualite de l'item
     * Si l'item est perime, qualite nulle
     * 
     * @see Item
     * @see Behavior
     * 
     * @param Item
     * 
     * @return rien, modifie la valeur dans l'item it
     */
    public void updateItemQuality(Item it){ 
        int increase = (it.getSellIn() <= DAYS_REMAINING_10 ? (it.getSellIn() <= DAYS_REMAINING_5 ? UPGRADE_DAYS_UNDER_5 : UPGRADE_DAYS_UNDER_10) : NORMAL_UPGRADE);
        if (isExpired(it)){
            it.setQuality(0);
        }
        else {
            int tmp = (it.getQuality() + increase) > MAX_QUALITY ? 50 : it.getQuality() + increase;
            it.setQuality(tmp);
        }
    }
}
