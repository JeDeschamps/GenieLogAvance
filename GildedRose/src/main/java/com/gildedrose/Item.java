package com.gildedrose;

/** 
 * Classe représentant un item, 3 attributs :
 *  - Nom
 *  - Date de péremption
 *  - Qualité
 * 
 * Fournit accesseurs/setters sur chacun des attributs
 * @version 2.0
 */


public class Item {
    /**
     * Nom de l'item, modification/accès par méthodes préférabl
     * 
     * @see Item#getQuality()
     * @see Item#setQuality(int)
     */
    public String name;

    /**
     * Jours restants avant péremption
     * Valeurs <= 0 si l'item est perime
     * 
     * @see Item#getSellIn()
     * @see Item#setSellIn(int)
     * 
     * @see Behavior#isExpired(Item)
     */
    public int sellIn;

    /** 
     * Qualité de l'item
     * Valeur devant être comprise théoriquement entre 0 et 50
     * Sulfuras a une qualité fixe à 80 théoriquement
     * 
     * @implNote Les items peuvent être instanciés avec des valeurs normalement interdites
     * 
     * @see Item#getQuality()
     * @see Item#setSellIn(int)
     */
    public int quality;

    /**
     * Constructeur Item 
     * 
     * @param name
     * @param sellIn
     * @param quality
     * 
     * @see Item#name
     * @see Item#sellIn
     * @see Item#quality
     */
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public String getName(){
        return this.name;
    }

    public int getSellIn(){
        return this.sellIn;
    }

    public int getQuality(){
        return this.quality;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSellIn(int newSellIn){
        this.sellIn = newSellIn;
    }

    public void setQuality(int newQuality){
        this.quality = newQuality;
    }
}
