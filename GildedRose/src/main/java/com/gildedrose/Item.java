package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

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
